#include <detpic32.h>

volatile unsigned char voltage = 0;     //global variable

void delay(int ms)
{
    for(;ms>0;ms--)
    {
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

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
  AD1CON1bits.ASAM = 1;   //start A/D conversion
  IFS0bits.T1IF = 0; // reset T1IF
}

void _int_(12) isr_T3(void){ // ele quando chama faz 1 Interrupcao
  send2displays(voltage); // Send "voltage" global variable to displays
  IFS0bits.T3IF = 0; // reset T3F
}

// interrupt Handler
void _int_(27) isr_adc(void){ // codigo do stor mais o meu para nao se ter de usar o osciloscopio
    int soma=0;
    double media;
    int *p = (int *) (&ADC1BUF0);
        for(;p<=(int *) (&ADC1BUFF);p+=4){
            soma += *p;
        }
        media = (double) (soma/8.0); // soma dos resultados de conversao a dividir pelo numero deles
        voltage = (char) ((media*33)/1023);
        voltage = toBcd(voltage&0xFF); // toBcd(v & 0xFF) -> converte para hexadecimal
        IFS1bits.AD1IF = 0;             //reset a AD1IF
}

void configureAll(){
  TRISB = TRISB & 0X00FF;//configurar RB15 to RB8 como outputs; (RB15 = ponto)
  LATB = LATB & 0X00FF;

  TRISD = TRISD & 0xFF9F; //configurar RD6 to RD5 como outputs;
  LATD = LATD & 0XFF9F;

   // configure all(digital I/O, analog input, A/D module)
  TRISBbits.TRISB4 = 1;               //Desligar a componente digital de saída do porto
  AD1PCFGbits.PCFG4 = 0;              //Configurar o porto como entrada analógica (AN4)

  AD1CON1bits.SSRC = 7;               //Bits de seleção do acionador de conversão: neste modo, um contador interno termina a amostragem e inicia a conversão
  AD1CON1bits.CLRASAM = 1;            //Parar conversões quando uma interrupção for gerada

  AD1CON3bits.SAMC = 16;
  AD1CON2bits.SMPI = 8-1;             //Número de conversões consecutivas no canal é 8  -> 8 amostras consecutivas

  AD1CHSbits.CH0SA = 4;               //Selecionar AN4 como entrada para o Conversor A/D

  AD1CON1bits.ON = 1;                 //ativar o conversor

  //Configure Interrupt System
  IPC6bits.AD1IP = 2; // configure priiority of A/D interrupts to 2
  IEC1bits.AD1IE = 1; // enable A/D interrupts

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


  // configurar timer T3 interrupts
  IPC3bits.T3IP=2; // Interrupt priority (must be in range [1..6]) -> set priority
  IEC0bits.T3IE=1;// Enable timer T3 interrupts

}

int main(void){
    configureAll(); // Function to configure all (digital I/O, analog input, A/D module, timers T1 and T3, interrupts)
    configureTimers();
    // Reset AD1IF, T1IF and T3IF flags
    IFS1bits.AD1IF = 0; // clear A/D interrupt flag -> reset
    IFS0bits.T1IF=0; // Reset timer T1 interrupt flag
    IFS0bits.T3IF=0; // Reset timer T3 interrupt flag

    EnableInterrupts();             //Global interrupt enable
    while(1);
    return 0;
}
