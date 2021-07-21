#include <detpic32.h>

static int count =0;

void _int_(4) isr_T1(void){
    putChar('1');
     IFS0bits.T1IF=0; // reset
} 

void _int_(12) isr_T3(void){
    putChar('3');
    
    IFS0bits.T3IF=0; // reset
}

int main(void){
    //timer t1
    T1CONbits.TCKPS=3;
    PR1 = 39061;
    TMR1=0;
    T1CONbits.TON=1;

    IPC1bits.T1IP=2; 
    IEC0bits.T1IE=1;
    IFS0bits.T1IF=0; 
    //timer t3
    T3CONbits.TCKPS=5;
    PR3 = 62499;
    TMR3=0;
    T3CONbits.TON=1;

    IPC3bits.T3IP=2; // Interrupt priority (must be in range [1..6]) -> set priority
    IEC0bits.T3IE=1;// Enable timer T3 interrupts
    IFS0bits.T3IF=0; // Reset timer T3 interrupt flag
 
    EnableInterrupts(); //Global interrupt enable
    while(1);
    return 0;
}
