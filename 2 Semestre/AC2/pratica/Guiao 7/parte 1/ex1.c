#include <detpic32.h>
// atendimento por polling
int main (void){
  // Configure Timer T3 (2 Hz with interrupts disabled)
  T3CONbits.TCKPS = 7; // Kprescaler=256
  PR3 = 39061; // FoutPrescaler = 78125 PR3 = 39060
  TMR3=0; // reset timer T3 count register
  T3CONbits.TON = 1; // Enable timer T3
  while (1);
  return 0;

}
