#include <detpic32.h>


static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};


void delay (int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}
void send2displays(int value1, int value2){
    static char displayFlag = 0;
    if( displayFlag== 0){
        LATDbits. LATD6 = 0;
        LATDbits. LATD5 = 1;
        LATB = (LATB & 0x00FF) | value1;
    }else{
        LATDbits. LATD6 = 1;
        LATDbits. LATD5 = 0;
        LATB = (LATB & 0x00FF) | value2;
    }

    displayFlag = ! displayFlag;

}

int main(void){

    TRISE = (TRISE & 0xFFF0); // lds
    TRISD = (TRISD & 0xFF9F); // o RD5 e o RD6 configurar como saida
    TRISB = (TRISE & 0x00FF); // do RB8 ao RB15 configurar como saida
    while(1){
      
        char letra = getChar();
        if(letra=='0'){
            LATE = (LATE & 0xFFFE) | 0x0001; // liga o RE0
            send2displays(display7Scodes[0], display7Scodes[0]);
            delay(10);
        }else if(letra=='1'){
            LATE =(LATE & 0xFFFD) | 0x0002;// liga o RE1
            send2displays(display7Scodes[0], display7Scodes[1]);
            delay(10);
        }else if(letra=='2'){
            LATE = (LATE & 0xFFFB) | 0x0004; // liga o RE2
            send2displays(display7Scodes[0], display7Scodes[2]);
            delay(10);
        }else if(letra=='3'){
            LATE = (LATE & 0xFFF7) | 0x0008; // liga o RE3
            send2displays(display7Scodes[0], display7Scodes[3]);
            delay(10);
        }else{
            LATE = (LATE & 0xFFF0) | 0x000F; // liga todos
            send2displays(display7Scodes[15], display7Scodes[15]);
            // fica a FF
            delay(1000); // espera 1 segundo 
            LATE = (LATE & 0xFFF0) | 0x0000; // deliga todos
           // LATDbits. LATD6 = 0;
            //LATDbits. LATD5 = 0;

        }
       
    }
    return 0;
}