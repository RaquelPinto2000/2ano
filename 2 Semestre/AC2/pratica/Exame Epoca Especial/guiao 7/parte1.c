#include <detpic32.h>

volatile unsigned char v = 0;

void _int_(4) isr_T1(void){
    AD1CON1bits.ASAM = 1;
    IFS0bits.T1IF = 0;
}

unsigned char toBcd(unsigned char value){
    return ((value/10)<<4)+(value%10);
}
void send2display(unsigned char value){
    static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};
    static char displayFlag=0;
    int dh = display7Scodes[value>>4];
    int dl = display7Scodes[value & 0xFF];
    if(displayFlag == 0){
        LATDbits.LATD5=1;
        LATDbits.LATD6=0;
        LATB = (LATB & 0x80FF)| (dl<<8);
    }else{
        LATDbits.LATD6=1;
        LATDbits.LATD5=0;
        LATB = (LATB & 0x80FF) | (dh<<8);
    }
    displayFlag = ! displayFlag;
}

void _int_(12) isr_T3(void){
    send2display(toBcd(v*0xFF));
    IFS0bits.T3IF = 0;
}

void _int_(27) isr_adc(void){
    int soma = 0;
    double media=0;
    int *p = (int *)(&ADC1BUF0);
    for(;p<= (int *) (&ADC1BUFF);p+=4){
        soma += *p;

    }
    media = (double) soma/8;
    v = (char) (media*33)/1023;
    
    IFS1bits.AD1IF = 0;
}

void COnfigureAll(){

    TRISB = TRISB & 0x80FF;
    LATB = LATB & 0x80FF;
    TRISD = TRISD & 0xFF9F;
    LATD = LATD & 0xFF9F;


    TRISBbits.TRISB4 = 1;
    AD1PCFGbits.PCFG4= 0;
    AD1CON1bits.SSRC = 7;
    AD1CON1bits.CLRASAM = 1;
    AD1CON3bits.SAMC = 16;
    AD1CON2bits.SMPI = 8-1; 
    AD1CHSbits.CH0SA = 4;

    AD1CON1bits.ON = 1;
    
    IPC6bits.AD1IP = 2;
    IEC1bits.AD1IE = 1;
    IFS1bits.AD1IF = 0;
    
    
    
    T3CONbits.TCKPS = 2;
    PR3 = 49999;
    TMR3 = 0;
    T3CONbits.TON = 1;

    IPC3bits.T3IP = 2;
    IEC0bits.T3IE = 1;
    IFS0bits.T3IF = 0;


    T1CONbits.TCKPS = 3;
    PR1 = 19999;
    TMR1 = 0;
    T1CONbits.TON = 1;

    IPC1bits.T1IP = 2;
    IEC0bits.T1IE = 1;
    IFS0bits.T1IF = 0;


    EnableInterrupts();
}

int main(void){
    COnfigureAll();


    while(1);
    return 0;
}
