#include <detpic32.h>
// atendimento por interrupcao
static int count = 1;
// interrupt Handler
void _int_(12) isr_T3(void){ // ele quando chama faz 1 Interrupcao
  if(count == 2){
    putChar('.');
    count = 1;
  }else{
    count++;
  }

  IFS0bits.T3IF = 0; // reset T3IF
}


int main (void){
  // Configure Timer T3 (2 Hz with interrupts enabled)
  T3CONbits.TCKPS = 7; // Kprescaler=256
  PR3 = 39061; // FoutPrescaler = 78125 PR3 = 39060
  TMR3=0; // reset timer T3 count register
  T3CONbits.TON = 1; // Enable timer T3

  IPC3bits.T3IP=2; // Interrupt priority (must be in range [1..6]) -> set priority
  IEC0bits.T3IE=1;// Enable timer T3 interrupts
  IFS0bits.T3IF=0; // Reset timer T3 interrupt flag
  EnableInterrupts(); //Global interrupt enable
  while (1);
  return 0;

}
