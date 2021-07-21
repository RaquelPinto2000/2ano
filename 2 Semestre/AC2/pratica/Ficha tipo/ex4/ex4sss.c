# include <detpic32.h>

static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};


void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void send2displays(int value0 ,int value1){

    static char displayFlag=0;
    if(displayFlag==0){
        LATDbits.LATD5=1;
        LATDbits.LATD6=0;
        LATB = (LATB & 0x00FF) | value0;
    }else{
        LATDbits.LATD5=0;
        LATDbits.LATD6 = 1;
        LATB = (LATB & 0x00FF) | value1;
    }
    displayFlag= !displayFlag;
}

int main(void){
    //TRISE = (TRISE & 0xFFF0); // configurar os portos RE0-RE3 como saida
    TRISB = (TRISB & 0x00FF);  // configurar os portos de RB8 AO RB15
    TRISD = (TRISD & 0xFF9F); // configurar os portos de RD5 e o RD6
    char ch=' ';
    while(1){
        ch = inkey();
        char ultimo;
        if(ch=='0'){
          //  LATE = (LATE & 0xFFFE) | 0x0001; // liga o RE0
            send2displays (display7Scodes[0],display7Scodes[0]);
            ultimo='0';
        }else if(ch == '1'){
          //  LATE = (LATE & 0xFFFD) | 0x0002; // liga o RE1
            send2displays(display7Scodes[0],display7Scodes[1]);
            ultimo='1';
        }else if(ch == '2'){
           // LATE = (LATE & 0xFFFB) | 0x0004; // liga o RE2
            send2displays(display7Scodes[0],display7Scodes[2]);
            ultimo='2';
        }else if(ch=='3'){
            //LATE = (LATE & 0xFFF7) | 0x0008; // liga o RE3
            send2displays(display7Scodes[0],display7Scodes[3]);
            ultimo='3';
        }else if(ch!='\0'){
           // LATE = (LATE & 0xFFF0) | 0x000F; // liga todos
            send2displays(display7Scodes[15],display7Scodes[15]);
            delay(1000); // espera 1 segundo 
            //LATE = (LATE & 0xFFF0) | 0x0000; // deliga todos
           // LATB= (LATB & 0x00FF);
            ultimo=ch;
        
        }else{
            ch = ultimo;
        }

        delay(10);
    }
    return 0;
}