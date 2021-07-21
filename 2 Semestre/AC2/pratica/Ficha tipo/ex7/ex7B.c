#include <detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);

    }
}



int main(void){
    TRISB = (TRISB & 0xFFF0) | 0x000F;  // configurar os portos de RB0-RB3 como entrada
    TRISBbits.TRISB4 = 1;
    AD1PCFGbits.PCFG4= 0;
    AD1CON1bits.SSRC = 7;

    AD1CON1bits.CLRASAM = 1;
    AD1CON3bits.SAMC = 16;

    AD1CON2bits.SMPI = 4-1; 

    AD1CHSbits.CH0SA = 4;

    AD1CON1bits.ON = 1;
    double t = 0;

    while(1){
        printInt(PORTBbits.RB0,2 | 1<<2);
        printInt(PORTBbits.RB1,2 | 1<<2);
        printInt(PORTBbits.RB2,2 | 1<<2);
        printInt(PORTBbits.RB3,2 | 1<<2);
        printStr("\n");

        // comecar a conversao
        AD1CON1bits.ASAM=1;
        while(IFS1bits.AD1IF == 0);

        double freq = 1 + (ADC1BUF0/255);
        t = 1/freq;
        delay(t*1000); // 1s = 1000 ms

        //Reset do AD1IF
        IFS1bits.AD1IF = 0;    
    }
    return 0;
}