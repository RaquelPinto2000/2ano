#include <detpic32.h>
#include "i2c.h"

// @mbc
int getTemperature(int *);

volatile int voltage = 0;     //global variable
int temperature;
// @mbc
volatile int T1Flag = 0;
volatile int displayValue = 0;


void send2displays(unsigned char value){
    static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};
    static char displayFlag=0; // static variable: doesn't loose its
    // value between calls to function

    int dh = display7Scodes[value >> 4];// digit_high (dh)
    // digit_low (dl)
    int dl = display7Scodes[value & 0x0F];

    // send digit_low (dl)
    if(displayFlag==0){
        LATDbits.LATD6 = 0;
        LATDbits.LATD5 = 1;
        LATB = (dl << 8) | (LATB & 0x80FF);
    }else{ // // send digit_high (dh)
        LATDbits.LATD6 = 1;
        LATDbits.LATD5 = 0;
        LATB = (dh << 8) | (LATB & 0x80FF);
    }
    // sao nos dois displays o bit 15 pois 1º define-se qual dos displays queremos atraves disto   LATDbits.LATD6 = 1; LATDbits.LATD5 = 0;

    // toggle "displayFlag" variable
    displayFlag = !displayFlag;

}
// converte para decimal de Hexadecimal
unsigned char toBcd(unsigned char value){
    return ((value/10)<<4) + (value % 10);
}

void _int_(4) isr_T1(void){
  AD1CON1bits.ASAM = 1;   			//start A/D conversion
//  getTemperature(&temperature);   //measure the temperature  // @mbc now done in main()
  T1Flag = 1;						// @mbc set flag to signal that 250ms has passed
  IFS0bits.T1IF = 0; 				// reset T1IF
}

void _int_(12) isr_T3(void){ // ele quando chama faz 1 Interrupcao
  send2displays(displayValue); // Send to displays "voltage" or temperature according to switches 
  IFS0bits.T3IF = 0; // reset T3F
}

// interrupt Handler
void _int_(27) isr_adc(void){
    int soma=0;
    double media;
    int *p = (int *) (&ADC1BUF0);
        for(;p<=(int *) (&ADC1BUFF);p+=4){
            soma += *p;
        }
    media = (double) (soma/8.0); // soma dos resultados de conversao a dividir pelo numero deles
    voltage = (int) ((media*33)/1023);
// @mbc convertion to BCD is done in main function
//  voltage = toBcd(voltage&0xFF); // toBcd(v & 0xFF) -> converte para hexadecimal
    IFS1bits.AD1IF = 0;             //reset a AD1IF
}

void configureAll(){
  //displays -> configure digital I/O
  TRISB = TRISB & 0X00FF;//configurar RB15 to RB8 como outputs; (RB15 = ponto)
  LATB = LATB & 0X00FF;

  TRISD = TRISD & 0xFF9F; //configurar RD6 to RD5 como outputs;
  LATD = LATD & 0XFF9F;


   // , analog input, A/D module)
  TRISBbits.TRISB4 = 1;               //Desligar a componente digital de saída do porto
  AD1PCFGbits.PCFG4 = 0;              //Configurar o porto como entrada analógica (AN4)

  AD1CON1bits.SSRC = 7;               //Bits de seleção do acionador de conversão: neste modo, um contador interno termina a amostragem e inicia a conversão
  AD1CON1bits.CLRASAM = 1;            //Parar conversões quando uma interrupção for gerada

  AD1CON3bits.SAMC = 16;
  AD1CON2bits.SMPI = 8-1;             //Número de conversões consecutivas no canal é 8  -> 8 amostras consecutivas

  AD1CHSbits.CH0SA = 4;               //Selecionar AN4 como entrada para o Conversor A/D

  AD1CON1bits.ON = 1;                 //ativar o conversor

  IPC6bits.AD1IP = 2; // configure priority of A/D interrupts to 2
  IEC1bits.AD1IE = 1; // enable A/D interrupts
  IFS1bits.AD1IF=0; // Reset interrupts flag
}

void configureTimers(){
  // configurar o T1
  T1CONbits.TCKPS = 3; // Kprescaler=256
  PR1 = 19530; // PR1 = 19530
  TMR1=0; // reset timer T1 count register
  T1CONbits.TON = 1; // Enable timer T1

  // configurar 0 T3
  T3CONbits.TCKPS = 2; // Kprescaler=4
  PR3 = 49999; // PR3 = 49999
  TMR3=0; // reset timer T3 count register
  T3CONbits.TON = 1; // Enable timer T3

  // configure timer T1 interrupts
  IPC1bits.T1IP=2; // Interrupt priority (must be in range [1..6]) -> set priority
  IEC0bits.T1IE=1;// Enable timer T1 interrupts
  IFS0bits.T1IF=0; // Reset timer T1 interrupt flag

  // configurar timer T3 interrupts
  IPC3bits.T3IP=2; // Interrupt priority (must be in range [1..6]) -> set priority
  IEC0bits.T3IE=1;// Enable timer T3 interrupts
  IFS0bits.T3IF=0; // Reset timer T3 interrupt flag
}
void gerarSinalPWM(){
  OC1CONbits.OCM = 6; //PWM mode on OCx; fault pin disabled
  OC1CONbits.OCTSEL = 1; //Use timer T3 as the time base for PWM generation
  OC1CONbits.ON = 1; //Enable OC1 module
}
void setPWM(unsigned int dutyCycle){
    OC1RS = ((49999+1)*dutyCycle)/100; // Evaluate OC1RS as a function of "dutyCycle"
      OC1CONbits.ON = 1; //Enable OC1 module
    // para acender o led da placa
    TRISEbits.TRISE0 = 0;
    LATEbits.LATE0 = LATDbits.LATD0;
}



int getTemperature(int *temperature){
  int ack;
  i2c1_start();// Send Start event
  ack = i2c1_send(ADDR_WR); // Send Address + WR (ADDR_WR); copy return value to "ack" variable
  ack += i2c1_send(RTR);// Send Command (RTR); add return value to "ack" variable
  i2c1_start(); // Send Start event (again)
  ack+=i2c1_send(ADDR_RD); // Send Address + RD (ADDR_RD); add return value to "ack" variable
  // Test "ack" variable; if "ack" != 0 then an error has occurred; send the Stop event, print an error message and exit loop
  if(ack != 0){
    i2c1_stop();
    printStr("ERRO MESSAGE\n");
    return 0;
  }

  *temperature = i2c1_receive(I2C_NACK);// Receive a value from slave (send NACK as argument); copy received value to "temperature" variable
  i2c1_stop();// Send Stop event

  return ack;
}


int main(void){
    int dutyCycle;
    configureAll();
    configureTimers();
    gerarSinalPWM();
    i2c1_init(TC74_CLK_FREQ);
    EnableInterrupts();//Global interrupt enable
    while(1){
      // Read RB1, RB0 to the variable "portVal"
      int portVal = PORTB & 0x0003; // vai buscar a entrada do RB1 e RB0
      switch (portVal) {
        case 0: // Measure input voltage
          IEC0bits.T1IE = 1;// Enable T1 interrupts
          displayValue = toBcd((unsigned char) voltage);			//@mbc send2displays() is only called in isr_T3
          if (1 == T1Flag) {				// @mbc 250ms has passed
          	T1Flag = 0;
            printStr("\nVoltage: ");
            printInt10(voltage / 10);		// @mbc print int digit of voltage
            printStr(",");
            printInt10(voltage % 10);		// @mbc print decimal digit of voltage
            printStr("V");            
          }
          setPWM(0); // LED OFF
          break;

        case 1: //freeze
          IEC0bits.T1IE = 0;// Disable T1 interrupts
          setPWM(100); // LED ON (maximum bright)
          break;

        case 2: // LED brigthness control
          IEC0bits.T1IE = 1; // Enable T1 interrupts
          dutyCycle = voltage * 3;
          setPWM(dutyCycle);
          break;

        case 3:
          // @mbc
          IEC0bits.T1IE = 1;				// Enable T1 interrupts
          if (1 == T1Flag) {				// @mbc 250ms has passed
          	T1Flag = 0;
          	getTemperature(&temperature);   //measure the temperature  // @mbc
            printStr("\nTemperatura: ");
            printInt10(temperature);
          }
          // @mbc
          displayValue = toBcd((unsigned char) temperature);		//@mbc send2displays() is only called in isr_T3
          break;
      }

    }
    return 0;
}

