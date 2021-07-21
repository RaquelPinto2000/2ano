#include <detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}


void send2displays(unsigned int value1,unsigned int value2){
   
    static char displayFlag=0; // static variable: doesn't loose its
    // value between calls to function

    // send digit_low (dl)
    if(displayFlag==0){
        LATDbits.LATD6 = 0;
        LATDbits.LATD5 = 1;
        LATB = (LATB & 0x80FF) | value1;
    }else{ // // send digit_high (dh)
        LATDbits.LATD6 = 1;
        LATDbits.LATD5 = 0;
        LATB = (LATB & 0x80FF)| value2;
    }
    // sao nos dois displays o bit 15 pois 1º define-se qual dos displays queremos atraves disto   LATDbits.LATD6 = 1; LATDbits.LATD5 = 0;

    // toggle "displayFlag" variable
    displayFlag = !displayFlag;

}

int main (void){
    TRISE = (TRISE & 0xFFF0); // configurar leds como saida
    TRISB = (TRISB & 0x00FF); // configurar os displays RB15-RB8 como saida
    TRISD = (TRISD & 0xFF9F); // configurar os portos RD6-RD5 como saida
    unsigned int value1=0;
    unsigned int value2=0;
    unsigned int valueAnt1=0;
    unsigned int valueAnt2=0;
    while(1){
        char letra = inkey();
        if(letra=='0'){
            value1=0x3F00;
            value2 = 0x3F00;
            LATE = (LATE & 0xFFFE) | 0x0001; // liga o RE0
            valueAnt1=0x3F00;
            valueAnt2=0x3F00;
            send2displays(value1,value2);

        }else if(letra=='1'){
            value1=0x0600;
            value2 = 0x3F00;
            LATE =(LATE & 0xFFFD) | 0x0002;// liga o RE1
             valueAnt1=0x0600;
            valueAnt2=0x3F00;
            send2displays(value1,value2);

        }else if(letra=='2'){
            value1=0x5B00;
            value2 = 0x3F00;
            LATE = (LATE & 0xFFFB) | 0x0004; // liga o RE2
            valueAnt1=0x5B00;
            valueAnt2=0x3F00;
            send2displays(value1,value2);

        }else if(letra=='3'){
            value1=0x4F00;
            value2 = 0x3F00;
            LATE = (LATE & 0xFFF7) | 0x0008; // liga o RE3
            valueAnt1=0x4F00;
            valueAnt2=0x3F00;
            send2displays(value1,value2);

        }else if(letra=='\0'){
            if(valueAnt1==0x7100 && valueAnt2==0x7100){ // desliga os displays
                LATB = LATB & 0x80FF;
                LATD = LATD & 0xFF9F;
                
            }else{
                send2displays(valueAnt1,valueAnt2);
            }

        }else{ // nao fica FF fica so um F...nao sei bem o pq tem haver com o delay
            value1 = 0x7100;
            value2 = 0x7100;
            
            LATE = (LATE & 0xFFF0) | 0x000F; // liga todos
            send2displays(value1,value2);
            delay(1000); // espera 1 segundo 
            LATE = (LATE & 0xFFF0) | 0x0000; // deliga todos
            valueAnt1 = 0x7100;
            valueAnt2 = 0x7100;
           // LATB = LATB & 0x80FF;
           // LATD = LATD & 0xFF9F;
        }
      
        delay(10);
    }
    return 0;
}