#include <detpic32.h>

int main(void){

  T3CONbits.TCKPS = 2;// Kprescaler=4
  PR3 = 49999;// PR3 = 49999
  TMR3 = 0;// reset timer T3 count register
  T3CONbits.TON = 1;// Enable timer T3 -> (must be the last command of the timer configuration sequence)

  OC1CONbits.OCM = 6; //PWM mode on OCx; fault pin disabled
  OC1CONbits.OCTSEL = 1; //Use timer T3 as the time base for PWM generation
  OC1RS = 12500; //Ton constant
  OC1CONbits.ON = 1; //Enable OC1 module

  TRISEbits.TRISE0 = 0; // para acender o led da placa
  LATEbits.LATE0 = LATDbits.LATD0;// para acender o led da placa
  while(1);
  return 0;
}
