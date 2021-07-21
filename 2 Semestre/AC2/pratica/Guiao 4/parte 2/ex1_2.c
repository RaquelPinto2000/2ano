
#include <detpic32.h>


void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void send2displays(unsigned char value){
    static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};
    int dh = display7Scodes[value >> 4];// send digit_high (dh)
    // send digit_low (dl)
    int dl = display7Scodes[value & 0x0F];

    // send digit_high (dh)
    LATDbits.LATD6 = 1;
    LATDbits.LATD5 = 0;
    LATB = (dh << 8) | (LATB & 0x80FF);

    delay(30); // se nao esperares, ele faz isso mas e muito rapido que nao se ve (ex 3) -> nao da para ver os dois ao mesmo tempo
    // o delay faz com que envie o do high espere e so depois envie o low, se nao tiver isto nao se ve o resultado
    // send digit_low (dl)
    LATDbits.LATD6 = 0;
    LATDbits.LATD5 = 1;
    LATB = (dl << 8) | (LATB & 0x80FF);
}

int main(void){
    TRISB = TRISB & 0x80FF;  //configurar RB14 to RB8 como outputs;
    TRISD = TRISD & 0xFF9F; //configurar RD6 to RD5 como outputs;
   
   int count =0;
   while(1){
       send2displays(count);
       delay(200); // frequencia de 5 Hz
       count++;
   }
    return 0;
}