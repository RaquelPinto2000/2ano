#include <detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);

    }
}

int main(void){
    TRISB = (TRISB & 0xFFF0) | 0x000F;  // configurar os portos de RB0-RB3 como entrada

    while(1){

        printInt(PORTBbits.RB0,2 | 1<<2);
        printInt(PORTBbits.RB1,2 | 1<<2);
        printInt(PORTBbits.RB2,2 | 1<<2);
        printInt(PORTBbits.RB3,2 | 1<<2);
        printStr("\n");
        delay(1000); // 1s = 1000 ms
    }
    return 0;
}