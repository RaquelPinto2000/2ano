#include <detpic32.h>
// ex 2 e 3

void setPWM(unsigned int dutyCycle){
  if(dutyCycle <0 || dutyCycle >100){
    printStr ("ERROR : duty_cycle must be in the range [0, 100]");
  }else{
    OC1RS = ((49999+1)*dutyCycle)/100; // Evaluate OC1RS as a function of "dutyCycle"
  }
}

int main(void){

  T3CONbits.TCKPS = 2;// Kprescaler=4
  PR3 = 49999;// PR3 = 49999
  TMR3 = 0;// reset timer T3 count register
  T3CONbits.TON = 1;// Enable timer T3 -> (must be the last command of the timer configuration sequence)

  OC1CONbits.OCM = 6; //PWM mode on OCx; fault pin disabled
  OC1CONbits.OCTSEL = 1; //Use timer T3 as the time base for PWM generation
//  setPWM(10);
  setPWM(25);
//  setPWM(65);
//  setPWM(80);
//  setPWM(100);
  OC1CONbits.ON = 1; //Enable OC1 module

// para acender o led da placa
  TRISEbits.TRISE0 = 0;
  LATEbits.LATE0 = LATDbits.LATD0;
  while(1);
  return 0;
}
