#include <detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void send2displays(unsigned char value){
    static const char display7codes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};
    static int displayFlag=0;
    int dh = display7codes[value<<4];
    int dl = display7codes[value & 0x0F];
    if(displayFlag==0){
        LATDbits.LATD5=1;
        LATDbits.LATD6=0;
        LATB = (LATB &0x80FF) | (dl<<8);
    }else{
        LATDbits.LATD6=1;
        LATDbits.LATD5=0;
        LATB = (LATB &0x80FF) | (dh<<8);
    }
    displayFlag = ! displayFlag;
}

unsigned char toBcd (unsigned char value){
    return ((value/10)<<4) + value%10;
}
int main(void){
    TRISBbits.TRISB4 = 1;
    AD1PCFGbits.PCFG4= 0;
    AD1CON1bits.SSRC = 7;

    AD1CON1bits.CLRASAM = 1; 
    AD1CON3bits.SAMC = 16;
    AD1CON2bits.SMPI = 4-1; 
    AD1CHSbits.CH0SA = 4;

    AD1CON1bits.ON = 1;


    while(1){
        int i = 0;
        int v =0;
        if(i++ %25 ==0){
        AD1CON1bits.ASAM = 1;
        while(IFS1bits.AD1IF==0);
        double soma=0;
        int *p = (int *) (&ADC1BUF0);
       
        for(; p<= (int *) (&ADC1BUFF); p+=4){
            printInt(*p,16|3<<16);
            printStr("\n");
            soma += *p;
        }
        double media = (double) soma /4;
        v = (media*33)/1023;
        printStr("\nMedia: ");
        printInt((int)media,10|4<<10);
        printStr("\nAmplitude de tenção: ");
        printInt((int)v, 10| 4<<10);
        printStr("\n");
        IFS1bits.AD1IF=0;
        }
        send2displays (toBcd(v*0xFF));
        delay(10);
    }
    return 0;
}
