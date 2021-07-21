#include <detpic32.h>


int main(void){
    LATB = LATB & 0x00FF; // atribuies um valor a cada uma delas primeiro
    LATD = LATD & 0xFF9F; // atribuies um valor a cada uma delas primeiro
    TRISB = TRISB & 0x00FF; // define os bits de 15 a 8 como saidas
    TRISD = TRISD & 0xFF9F; // define os bits 5 e 6 como saidas
   
    LATDbits.LATD5 = 0; // atribuies o valor a um so bit a parte
    LATDbits.LATD6 = 1;

    while(1){
        char ler = getChar();
       
        switch(ler){
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