#include <detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void incresengment(char ler){
    LATB = LATB & 0x00FF; // mete todas as saidas a 0 e depois altera o bit que for para ligar
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
    LATB = LATB & 0x00FF; // das o valor inicial dos pinos (0)
    LATD = LATD & 0xFF9F;// das o valor inicial dos pinos (0)
    LATDbits.LATD6 = 1; // display high active
    LATDbits.LATD5 = 0; // display low inactive
    TRISD = TRISD & 0xFF9F;// configure RD5-RD6 as outputs
    TRISB = TRISB & 0x80FF;// configure RB8-RB14 as outputs
    while(1){
        LATDbits.LATD6 = !LATDbits.LATD6; //
        LATDbits.LATD5 = !LATDbits.LATD5; // toggle display selection
        segment = 'a';
        while(segment!='h'){
            incresengment(segment);
            // send "segment" value to display
            delay(500); // wait 0.5 second
            segment++; //danos a letra seguinte do alfabeto
        }
        // ou  em vez di while(segment......)
  /*      for(i=0; i < 7; i++){ // do a ate ao h vao 7 letras
            // send "segment" value to display
            incresengment(segment);
            delay(500); // wait 0.5 second
            segment = segment << 1;
        }
    }
    */
    }
    return 0;
}