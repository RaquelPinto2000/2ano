#include <detpic32.h>

int main(void){
    TRISB = (TRISB & 0xFFF0) | 0x000F; // configurar os portos RB3-RB0 como entrada -> 1 dizer que sao saidas mas depois dizes nao afinal sao entradas
    TRISE = TRISE & 0xFFF0; // configurar ocmo saidas o RE3-RE0

    while(1){
        LATEbits.LATE0 = PORTBbits.RB3;
        LATEbits.LATE1 = PORTBbits.RB2;
        LATEbits.LATE2 = PORTBbits.RB1;
        LATEbits.LATE3 = PORTBbits.RB0;
    }
    return 0;

}