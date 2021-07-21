// igual ao ex7_8.c e alterar isto  LATDbits.LATD6 = 1; // display high inactive LATDbits.LATD5 = 0; // display low active



#include <detpic32.h>

 static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

int main(void){
    LATB = LATB & 0x00FF; // inicializar os pinos
    LATD = LATD & 0xFF9F; // inicializar os pinos
   
    TRISB = TRISB & 0x000F;   // configure RB0 to RB3 as inputs
    // configure RB8 to RB14 and RD5 to RD6 as outputs
    TRISB = TRISB & 0x80FF;
    TRISD = TRISD & 0xFF9F;// configure RD5-RD6 as outputs

    LATD = (LATD & 0xFF9F) | 0x0040;    //Select display high

//    LATD = (LATD & 0xFF9F) | 0x0020;    //Select display low

    LATB = LATB & 0x80FF;

    while(1){
        int s = PORTB & 0x000F; // read dip-switch
       // delay(500); // wait 0.5 second 
       
        // convert to 7 segments code
        // send to display
        LATB = (LATB & 0x80FF) | (display7Scodes[s]<<8);
       
        }
    return 0;
}