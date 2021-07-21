# include <detpic32.h>

int main(void){
    TRISB = (TRISB & 0xFFF0) | 0x000F; // configurar os portos RB3-RB0 como entrada -> 1 dizer que sao saidas mas depois dizes nao afinal sao entradas
    TRISE = TRISE & 0xFFF0; // configurar ocmo saidas o RE3-RE0

    while(1){
        int value = PORTB & 0x000F;
       // value = ((LATE & 0xFFF0) | value);
        LATE = value;
    }
    return 0;

}