#include <detpic32.h>

int main(void){
    TRISB = TRISB & 0x00FF;
    LATB = LATB & 0x00FF;
    TRISD = TRISD & 0xFF9F;
    LATD = LATD & 0xFF9F;
    
    LATDbits.LATD5 = 1; // seleciona o display low
    LATDbits.LATD6 = 0;
    while(1){
        char ch = getChar();
        switch(ch){
            case 'a'|'A':
                LATB = LATB & 0x00FF;
                LATBbits.LATB8 =1;
                break;
            case 'b'|'B':
                LATB = LATB & 0x00FF;
                LATBbits.LATB9 =1;
                break;
            case 'c'|'C':
                LATB = LATB & 0x00FF;
                LATBbits.LATB10 =1;
                break;
            case 'd'|'D':
                LATB = LATB & 0x00FF;
                LATBbits.LATB11 =1;
                break;
            case 'e'|'E':
                LATB = LATB & 0x00FF;
                LATBbits.LATB12 =1;
                break;
            case 'f'|'F':
                LATB = LATB & 0x00FF;
                LATBbits.LATB13 =1;
                break;
            case 'g'|'G':
                LATB = LATB & 0x00FF;
                LATBbits.LATB14 =1;
                break;
            case '.':
                LATB = LATB & 0x00FF;
                LATBbits.LATB15 =1;
                break;
            default:
                LATB = LATB & 0xFFFF;
                break;
        } 
    }
    return 0;
}
