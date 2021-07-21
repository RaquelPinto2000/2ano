# include <detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void send2displays(unsigned char value){
    static const char display7codes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};
    static char displayFlag=0;
    int dh = display7codes[value>>4]; // display high - 6
    int dl = display7codes[value & 0x0F]; // display low - 5
    if(displayFlag==0){ // ativa o display low
        LATDbits.LATD6=0;
        LATDbits.LATD5 = 1;
        LATB = (dl<<8)| (LATB & 0x80FF); // ou vamos andar no array ou vai ficar desligado
        if(value%2==0){ // se for par ativa nos do low - unidades
            LATBbits.LATB15=1;
        }
    }else{ // ativa o displa high
        LATDbits.LATD6=1;
        LATDbits.LATD5 = 0;
        LATB = (dh<<8) | (LATB & 0x80FF);// ou vamos andar no array ou vai ficar desligado
        if(value%2!=0){ // se for par ativa no high - dezenas
            LATBbits.LATB15=1;
        }
    }
    displayFlag = ! displayFlag;
}

unsigned char toBcd (unsigned char value){
    return ((value/10)<<4) + (value % 10);
}

int main(void){
    TRISB = TRISB & 0x00FF; // configurar os portos RB14 ate RB8 como saida
    TRISD = TRISD & 0xFF9F; //configurar RD6 to RD5 como outputs;
    LATB = LATB & 0x00FF; // inicializacao dos portos
    LATD = LATD & 0xFF9F; // inicializacao dos portos
    int count=0;
    int i = 0;
    int c = 0;
    unsigned char valor=0;
    while(1){
        i++;
        valor = toBcd(count);
        send2displays(valor);
        double tempo = 1/1;
        tempo = tempo * 1000;
        delay(tempo); // aumentando o delay pode fazer com que a mudanca de um display para outro ja nao se note tanto - mete de 10
        if(i % 4 == 0 ){
            count++;
        }
        if(count>99 || count < 0){
            count=0;
            for(c=0;c<=5;c++){ // fazer isto 5 vezes
                LATDbits.LATD6 = 1;
                LATDbits.LATD5 = 1;
                LATB = (LATB & 0x00FF)| 0x3F00; // ou esta desligado ou esta a 00
                tempo = 0.5 *1000;
                delay(tempo); // esperar meio segundo
                LATB = LATB & 0x00FF; // desligar tudo
                delay(tempo); // esperar meio segundo
            }
        }
    }
    return 0;
}
