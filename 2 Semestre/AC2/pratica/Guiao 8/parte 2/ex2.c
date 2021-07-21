#include <detpic32.h>
#include "functions.h"
//nao apresenta os resultados bem quando os valores passam do 9
//global variable
volatile int voltage = 0;
volatile int voltMin = 666;// valor maior que o possivel para ver que esta a funcionar
volatile int voltMax = 0;

void _int_(4) isr_T1(void){
  AD1CON1bits.ASAM = 1;   //start A/D conversion
  IFS0bits.T1IF = 0; // reset T1IF
}

void _int_(12) isr_T3(void){ // ele quando chama faz 1 Interrupcao
  static int count =0;
  send2displays(voltage); // Send "voltage" global variable to displays
  if(++count == 100){
    count=0;
    U1RXREG =voltage; // send voltage to the serial port UART1
  }
  IFS0bits.T3IF = 0; // reset T3F -> Clear T3 interrupt flag
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
        voltage = (int) ((media*33)/1023);
        // Convert voltage amplitude to decimal. Assign it to "value2display"
        voltage = toBcd(voltage&0xFF); // toBcd(v & 0xFF) -> converte para decimal de haxadecimal

        // Update variables "voltMin" and "voltMax"
        if(voltage>voltMax){
          voltMax = voltage;
        }
        if(voltage<voltMin){
          voltMin = voltage;
        }

        IFS1bits.AD1IF = 0;             //reset a AD1IF
}

void _int_(24) isr_uart1(void) {
  if(U1RXREG == 'L'){
    puts("\nValor Minimo: ");
    char unidades = 0x30 | ((voltMin & 0xF0) >>4);
    char dezenas = 0x30 | ((voltMin & 0x0F));
    putc(unidades);
    putc(dezenas);
    puts("\nValor Maximo: ");
    unidades = 0x30 | ((voltMax & 0xF0) >>4);
    dezenas = 0x30 | ((voltMax & 0x0F));
    putc(unidades);
    putc(dezenas);
    // Send "voltMin" and "voltMax" to the serial port UART1
    U1RXREG = voltMin;
    U1RXREG = voltMax;
  }
//  putc(U1RXREG);
  IFS0bits.U1RXIF=0;  // Clear UART1 rx interrupt flag -> Pag. 21 do manual
}


int main(void){
    int dutyCycle;
    configUart(115200, 'N', 1);
    configureAll(); // Function to configure all (digital I/O, analog input, A/D module)
    configureTimers(); // timers e interrupts
    gerarSinalPWM();
    //Reset AD1IF, T1IF and T3IF flags
        IFS1bits.AD1IF = 0;         //Reset AD1IF flag
        IFS0bits.T1IF = 0;
        IFS0bits.T3IF = 0;
    EnableInterrupts();//Global interrupt enable
    while(1){
      // Read RB1, RB0 to the variable "portVal"
      int portVal = PORTB & 0x0003; // vai buscar a entrada do RB1 e RB0
      switch (portVal) {
        case 0: // Measure input voltage
          IEC0bits.T1IE = 1;// Enable T1 interrupts
          setPWM(0); // LED OFF
          break;
        case 1: //freeze
          IEC0bits.T1IE = 0;// Disable T1 interrupts
          setPWM(100); // LED ON (maximum bright)
          break;
        default: // LED brigthness control
          IEC0bits.T1IE = 1; // Enable T1 interrupts
          dutyCycle = voltage * 3;
          setPWM(dutyCycle);
          break;
      }

    }
    return 0;
}
