#include <detpic32.h>

void _int_(4) isr_T1(void){
  printInt10(1);
  IFS0bits.T1IF = 0; // reset T1IF
}

void _int_(12) isr_T3(void){ // ele quando chama faz 1 Interrupcao
  printInt10(3);
  IFS0bits.T3IF = 0; // reset T3F
}


int main (void){
  // configurar o T1
  T1CONbits.TCKPS = 3; // Kprescaler=256
  PR1 = 39061; // PR1 = 39061
  TMR1=0; // reset timer T1 count register
  T1CONbits.TON = 1; // Enable timer T1

  // configurar 0 T3
  T3CONbits.TCKPS = 5; // Kprescaler=32 -> 10 Hz
  //T3CONbits.TCKPS = 4; // Kprescaler=16 -> 20 Hz
  PR3 = 62499; // PR3 = 62499
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

  EnableInterrupts();
  while(1);
  return 0;
}
