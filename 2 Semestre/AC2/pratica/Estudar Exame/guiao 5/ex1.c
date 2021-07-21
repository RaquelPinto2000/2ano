# include <detpic32.h>
// vai ate ao 5 deste guiao
void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void send2displays(unsigned char value){ // este value e o espaco do display7codes----acho
    static const char display7codes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};
    static char displayFlag=0;
    int dh = display7codes[value>>4];
    int dl = display7codes[value & 0x0F];
    if(displayFlag==0){ // ligar o low
        LATDbits.LATD6=0;
        LATDbits.LATD5=1;
        LATB = (dl<<8) | (LATB & 0x80FF);
    }else{ // liga o high
        LATDbits.LATD6=1;
        LATDbits.LATD5=0;
        LATB = (dh<<8) | (LATB& 0x80FF);
    }
    displayFlag = ! displayFlag;
}

unsigned char toBcd(unsigned char value){
    return ((value/10)<<4) + value%10;
}

int main(void){
    // configuracao completa do modulo A/D
    TRISBbits.TRISB4 = 1;               //Desligar a componente digital de saída do porto
    AD1PCFGbits.PCFG4 = 0;              //Configurar o porto como entrada analógica (AN4) -> RB4

    AD1CON1bits.SSRC = 7;               //Bits de seleção do acionador de conversão: neste modo, um contador interno termina a amostragem e inicia a conversão
    AD1CON1bits.CLRASAM = 1;            //Parar conversões quando uma interrupção for gerada

    AD1CON3bits.SAMC = 16;              
    AD1CON2bits.SMPI = 4-1;             //Número de conversões consecutivas no canal é 4

    AD1CHSbits.CH0SA = 4;               //Selecionar AN4 como entrada para o Conversor A/D

    AD1CON1bits.ON = 1;                 //ativar o conversor

    // configuracao dos portos
    TRISB = TRISB & 0x80FF; // configuracao como saida
    TRISD = TRISD & 0xFF9F; // configuracao como saida
    LATB = LATB & 0x80FF; // inicializacao dos portos
    LATD = LATD & 0xFF9F; // inicializacao dos portos

    int i=0;
    int v=0;
    while(1){
        if(i++%25==0){
            AD1CON1bits.ASAM = 1; // comecar a conversao
            while(IFS1bits.AD1IF == 0);
            int *p = (int *) (&ADC1BUF0);
            double soma =0;
            for(; p<=(int *) (&ADC1BUFF);p+=4){
                printInt(*p, 10| 4<<10);
                printStr("\n"); 
                soma += *p;
            
            }
            double media = (double) soma/4;
             v = (media*3.3)/1023;
            printStr("\nMedia: ");
            printInt((int)media,10|4<<10);
            printStr("\nAmplitude de tenção: ");
            printInt((int)v, 10| 4<<10);
            printStr("\n");
          //  delay(900);
            IFS1bits.AD1IF=0;
        }
        send2displays(toBcd(v & 0x00FF)); // ou esta desligado ou vai apresentar o valor do v
        delay(10);


    }
    return 0;
}
