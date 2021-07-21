# include <detpic32.h>
volatile unsigned char v = 0;     //global variable

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000){

        }
    }
}

void send2diplay(unsigned char value){
    static const char display7codes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};
    static char displayFlag=0;
    int dh=display7codes[value>>4];
    int dl=display7codes[value & 0x0F];
    if(displayFlag ==0){ // ligar o low
        LATDbits.LATD6=0;
        LATDbits.LATD5=1;
        LATB = (dl<<8) | (LATB & 0x80FF);
    }else{
        LATDbits.LATD6=1;
        LATDbits.LATD5=0;
        LATB = (dh<<8) | (LATB & 0x80FF);
    }
    displayFlag = !displayFlag;
}

unsigned char toBcd (unsigned char value){
    return ((value/10)<<4) + value%10;
}


void _int_(27) isr_adc(void){
    /*LATEbits.LATE6=0; // reset ao RE6
    printInt(ADC1BUF0, 16 | 3<<16);
    LATEbits.LATE6 = 1; // enviar o RE6
    AD1CON1bits.ASAM = 1;// comecar a conversao A\D
    IFS1bits.AD1IF=0;

    */
    double soma = 0;
    double media = 0;
    v=0;
    int *p = (int*) (&ADC1BUF0);
    for(;p<=(int*)(&ADC1BUF7);p+=4){
        soma+=*p;
    }
    media = soma/8;
    v = (int) (media*3.3)/1023;
    IFS1bits.AD1IF = 0; // clear A\D interrupt flag
}


int main(void){
    TRISB = TRISB & 0x80FF; // configurar os portos de RB8-RB14 como saida
    TRISD = TRISD & 0xFF9F; // configurar o RD5 e RB6 como saida
    LATB = LATB & 0x80FF; // inicializar os portos
    LATD = LATD & 0xFF9F; // inicializar os portos
    // configurar o RB6
    TRISEbits.TRISE6 = 1;

    // configuracao completa do modulo A/D
    TRISBbits.TRISB4 = 1;               //Desligar a componente digital de saída do porto
    AD1PCFGbits.PCFG4 = 0;              //Configurar o porto como entrada analógica (AN4) -> RB4

    AD1CON1bits.SSRC = 7;               //Bits de seleção do acionador de conversão: neste modo, um contador interno termina a amostragem e inicia a conversão
    AD1CON1bits.CLRASAM = 1;            //Parar conversões quando uma interrupção for gerada

    AD1CON3bits.SAMC = 16;              
    AD1CON2bits.SMPI = 8-1;             //Número de conversões consecutivas no canal é 1

    AD1CHSbits.CH0SA = 4;               //Selecionar AN4 como entrada para o Conversor A/D

    AD1CON1bits.ON = 1;                 //ativar o conversor

    // configurar as interrupcoes
    IPC6bits.AD1IP=2; // configurar as prioridades
    IEC1bits.AD1IE=1; // enable A\D interrupters
    IFS1bits.AD1IF = 0; // clear A\D interrupt flag
    EnableInterrupts();

    int i=0;

    while(1){ 
        delay(10);
        if(i++==25){
            AD1CON1bits.ASAM = 1;// comecar a conversao A\D
            i=0;
        }
        send2diplay(toBcd(v&0x00FF));
    }
    return 0;
}
