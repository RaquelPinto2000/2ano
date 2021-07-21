#include <detpic32.h>

volatile unsigned char v = 0;     //global variable

void delay (int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void send2display (unsigned char value){
    static const char display7codes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};
    static char displayFlag =0;
    int dh = display7codes[value>>4];
    int dl = display7codes[value & 0x0F];
    if(displayFlag ==0){
        LATDbits.LATD5 = 1;
        LATDbits.LATD6 = 0;
        LATB = (dl<<8) | (LATB & 0x80FF);
    }else{
        LATDbits.LATD5 = 0;
        LATDbits.LATD6 = 1;
        LATB = (LATB & 0x80FF) | (dh<<8);
    }
    displayFlag = ! displayFlag;
}

unsigned char toBcd (unsigned char value){
    return ((value /10)<<4) + (value%10);
}

void _int_(27) isr_adc(void){
   /* ex 1-3
    LATBbits.LATB6 = 0;     
    printInt(ADC1BUF0, 16 | 3<<16);
    printStr("\n");
    LATBbits.LATB6 = 1; 
    AD1CON1bits.ASAM = 1;// comecar a conversao A\D
    IFS1bits.AD1IF = 0;
    */
    double soma =0;
    double media = 0;
    int *p = (int*) (&ADC1BUF0);
    for(;p<=(int*)(&ADC1BUFF);p+=4){
        soma+=*p;
    }
    media = soma/8;
    v = (int) (media *33)/1023;
    IFS1bits.AD1IF = 0; // clear A\D interrupt flag



}


int main(void){

    TRISB = TRISB & 0x80FF;
    LATB = LATB & 0x80FF;
    TRISD= TRISD & 0xFF9F;
    LATD = LATD & 0xFF9F;

    TRISBbits.TRISB4 = 1;
    AD1PCFGbits.PCFG4= 0;
    AD1CON1bits.SSRC = 7;

    AD1CON1bits.CLRASAM = 1; 
    AD1CON3bits.SAMC = 16;
    AD1CON2bits.SMPI = 8-1; 
    AD1CHSbits.CH0SA = 4;

    AD1CON1bits.ON = 1;

    //configurar as interrupcoes
    IPC6bits.AD1IP = 2;
    IEC1bits.AD1IE = 1;
    IFS1bits.AD1IF = 0;
    EnableInterrupts();

    int i = 0;
    while(1){
        delay(10);
        if(i++==25){
            AD1CON1bits.ASAM = 1;// comecar a conversao A\D
            i=0;
        }
        send2display(toBcd(v & 0xFF));
    }

    //TRISBbits.TRISB6 = 1;

   // AD1CON1bits.ASAM = 1; // so depois e que se inicia a conversao


    return 0;
}
