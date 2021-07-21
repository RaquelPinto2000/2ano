#include <detpic32.h>
void setPWM(unsigned int dutyCycle){
    if(dutyCycle <0 || dutyCycle >100){
        printStr ("ERROR : duty_cycle must be in the range [0, 100]");
    }else{
        OC1RS = ((49999+1)*dutyCycle)/100;
    }

}

int main (void){
    T3CONbits.TCKPS = 2;
    PR3 = 49999;
    TMR3 = 0;
    T3CONbits.TON = 1;

    OC1CONbits.OCM = 6;
    OC1CONbits.OCTSEL =1;
    setPWM(25);
    OC1CONbits.ON = 1;

    TRISEbits.TRISE0 = 0;
    LATEbits.LATE0=LATDbits.LATD0;
    while(1);
    return 0;

}

