
#include <detpic32.h>


void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void send2displays(unsigned char value){
    static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};
    static char displayFlag=0; // static variable: doesn't loose its
    // value between calls to function
    
    int dh = display7Scodes[value >> 4];// digit_high (dh)
    // digit_low (dl)
    int dl = display7Scodes[value & 0x0F];

    // send digit_low (dl)
    if(displayFlag=0){
        LATDbits.LATD6 = 0;
        LATDbits.LATD5 = 1;
        LATB = (dl << 8) | (LATB & 0x80FF);
    }else{ // // send digit_high (dh) 
        LATDbits.LATD6 = 1;
        LATDbits.LATD5 = 0;
        LATB = (dh << 8) | (LATB & 0x80FF);
    }
    
    // toggle "displayFlag" variable
    displayFlag = !displayFlag;
   
}

int main(void){
     
    unsigned int i;
    unsigned int count;
    TRISB = TRISB & 0x80FF;  //configurar RB14 to RB8 como outputs;
    TRISD = TRISD & 0xFF9F; //configurar RD6 to RD5 como outputs;
   
    count =0;
    i=0;
    while(1){
        i++;
        send2displays(count);
        delay(50); // frequencia de 20 Hz
        if(i%4==0){
            count++;
        }
    }
    
    return 0;
}

/*
 // ou -> nao funciona
int main (void){
    
    TRISB = TRISB & 0x80FF;  //configurar RB14 to RB8 como outputs;
    TRISD = TRISD & 0xFF9F; //configurar RD6 to RD5 como outputs;
    int count =0;
    while(1){
        int i=0;
        do{
            send2displays(count);
            delay(50); // frequencia de 20 Hz
        }while(++i<4);
    }
    return 0;
}
*/