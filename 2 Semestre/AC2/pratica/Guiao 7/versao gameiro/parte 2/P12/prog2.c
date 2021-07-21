#include <detpic32.h>

void setPWM(unsigned int dutyCycle){
    if((dutyCycle<0) | (dutyCycle> 100))
        printStr("ERROR: dutyCycle must be in range [0,100]");
    else
        OC1RS = 500*dutyCycle;                //OC1RS = (PR3+1)*(dutycycle/100)    
}

int main(void)
{
    TRISEbits.TRISE0 = 0;

    //Configure Timer T3
    T3CONbits.TCKPS = 2;            //Kprescaler = 4  FoutPrescaler = 5*10^6 Hz
    PR3 = 49999;                    //Fout = 100 Hz = (PBCLK/(49999+1)*4)
    TMR3 = 0;                       //reset Timer T3 counter
    T3CONbits.TON = 1;              //Timer T3 enabled

    OC1CONbits.OCM = 6;
    OC1CONbits.OCTSEL = 1;          //Timer T3 selected as clock source

    while(1){
        //setPWM(0);
        //setPWM(10);                     //set OC1RS constant value
        //setPWM(40);
        //setPWM(65);
        //setPWM(80);
        setPWM(90);
        OC1CONbits.ON = 1;              //Output compare module is enabled

        LATEbits.LATE0 = LATDbits.LATD0;
    }
    return 0;
}
