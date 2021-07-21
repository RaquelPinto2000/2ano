#include<detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while (readCoreTimer() < 20000);
    }
}

void send2displays(unsigned char value){
    static const char display7Scodes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    static char displayFlag = 0;
    // send digit_high (dh) to display_high: 
    unsigned char dh = (value & 0xF0) >> 4;
    // send digit_low (dl) to display_low: 
    unsigned dl = value & 0x0F;

    char hexCode;

    if(displayFlag){
        LATDbits.LATD5 = 1;
        LATDbits.LATD6 = 0;    
        hexCode = display7Scodes[dl];
        LATB = (LATB & 0x00FF) | ((int)hexCode << 8);
    }

    else{
        LATDbits.LATD5 = 0;
        LATDbits.LATD6 = 1;
        hexCode = display7Scodes[dh];
        LATB = (LATB & 0x00FF) | ((int)hexCode << 8);
    }

    displayFlag = !displayFlag;    
}

unsigned int f = 100;
unsigned char select = 0;
unsigned int count = 0;
unsigned char c = 0;
unsigned int i = 0;
unsigned char old = 0;

void _int_(12) isr_T3(void){

    select = inkey();
    if(select == '\n'){
        c = count;
        printf("%d >> %d\r",count, c);
        send2displays(c);
        delay(20);
    }
    else if(select == '0' || select == '1' || select == '2' || select == '3' || select == '4'){
        f = 10*(1+(int)select);
        delay(1/f*0.001);
        printf("%d\r",count);
    }
    printf("%d\r",count);
    
    if(count == 99) count = 0;
    count++;
    IFS0bits.T3IF = 0;

}

int main(void){
    LATE = (LATE & 0xFFF0);    
    TRISE = (TRISE & 0xFFF0);   
    TRISB = (TRISB & 0x80FF);
    LATB = (LATB & 0x00FF);
    // displays
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;

    LATDbits.LATD5 = 1;
    LATDbits.LATD5 = 0;
    
    // timer 3 config
    T3CONbits.TCKPS = 2;
    PR3 = 49999;
    TMR3 = 0;
    T3CONbits.TON = 1;

    
    while(1){
        LATDbits.LATD5 = 1;
        LATDbits.LATD6 = 0;
        //interrupçao
        IPC3bits.T3IP = 2;
        IEC0bits.T3IE = 1;
        IFS0bits.T3IF = 0;
        EnableInterrupts();
    }

    return 0;
}
