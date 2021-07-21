#include <detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void incresengment(char ler){
    LATB = LATB & 0x00FF;
    switch(ler){
        case 'a':
            LATBbits.LATB8 =1;
            break;
        case 'b':
            LATBbits.LATB9 =1;
            break;
        case 'c':
            LATBbits.LATB10 =1;
            break;
        case 'd':
            LATBbits.LATB11 =1;
            break;
        case 'e':
            LATBbits.LATB12 =1;
            break;
        case 'f':
            LATBbits.LATB13 =1;
            break;
        case 'g':
            LATBbits.LATB14 =1;
            break;
        default:
            LATB = LATB & 0xFFFF;
            break;
        }

}


int main(void) {
    unsigned char segment;
    LATB = LATB & 0x00FF; // configurar os pinos como saida 
    LATD = LATD & 0xFF9F;// configurar os pinos como saida
    //LATDbits.LATD6 = 1; // display high active
    //LATDbits.LATD5 = 0; // display low inactive
    LATD = (LATD & 0xFF9F) | 0x0040; // display high active, low inactive
    TRISD = TRISD & 0xFF9F;// configure RD5-RD6 as outputs
    TRISB = TRISB & 0x00FF;// configure RB8-RB14 as outputs
    while(1){
        
        LATD = LATD ^ 0x0060;// toggle display selection
        segment = 'a';
        while(segment!='h'){
            incresengment(segment);
            // send "segment" value to display
            delay(500); // wait 0.5 second 
            segment++;
        }
    }
    return 0;
}