#include <detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void send2displays(unsigned char value){
    static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};
    static char displayFlag=0;
    int dh = display7Scodes[value>>4];
    int dl = display7Scodes[value & 0x0F];
    if(displayFlag==0){
        LATDbits.LATD5=1;
        LATDbits.LATD6=0;
        LATB=(dl<<8) | (LATB & 0x80FF);
    }else{
        LATDbits.LATD6=1;
        LATDbits.LATD5=0;
        LATB = (dh<<8) | (LATB & 0x80FF);
    }

    displayFlag = !displayFlag;
}

int main(void){
    TRISB = TRISB & 0x80FF;
    LATB = LATB & 0x80FF;
    TRISD = TRISD & 0xFF9F;
    LATD = LATD & 0xFF9F;
    unsigned i = 0 ;
    int count=0;
    while(1){
        i++;
        send2displays(count);
        //delay(50);
        //delay(100);
        delay(20);
        if(i%4==0){
            count++;
        }
        
    }
    return 0;
}
