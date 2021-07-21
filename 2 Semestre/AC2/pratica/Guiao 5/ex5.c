#include <detpic32.h>

// converte para decimal de Hexadecimal
unsigned char toBcd(unsigned char value){
    return ((value/10)<<4) + (value % 10);
}

// funcao para esperar tanto
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
    if(displayFlag==0){
        LATDbits.LATD6 = 0;
        LATDbits.LATD5 = 1;
        LATB = (dl << 8) | (LATB & 0x80FF);
    }else{ // // send digit_high (dh) 
        LATDbits.LATD6 = 1;
        LATDbits.LATD5 = 0;
        LATB = (dh << 8) | (LATB & 0x80FF);
    }
    // sao nos dois displays o bit 15 pois 1º define-se qual dos displays queremos atraves disto   LATDbits.LATD6 = 1; LATDbits.LATD5 = 0;
    
    // toggle "displayFlag" variable
    displayFlag = !displayFlag;
   
}

int main(void){
    // portos analogicos convertor de input/ AD

    TRISBbits.TRISB4 = 1;               //Desligar a componente digital de saída do porto
    AD1PCFGbits.PCFG4 = 0;              //Configurar o porto como entrada analógica (AN4)

    AD1CON1bits.SSRC = 7;               //Bits de seleção do acionador de conversão: neste modo, um contador interno termina a amostragem e inicia a conversão
    AD1CON1bits.CLRASAM = 1;            //Parar conversões quando uma interrupção for gerada

    AD1CON3bits.SAMC = 16;              
    AD1CON2bits.SMPI = 4-1;             //Número de conversões consecutivas no canal é 4

    AD1CHSbits.CH0SA = 4;               //Selecionar AN4 como entrada para o Conversor A/D

    AD1CON1bits.ON = 1;                 //ativar o conversor
    
    // portos I/O configuracao
    TRISB = TRISB & 0x00FF;  //configurar RB15 to RB8 como outputs; (RB15 = ponto)
    LATB = LATB & 0x00FF;
    TRISD = TRISD & 0xFF9F; //configurar RD6 to RD5 como outputs;
    TRISD = TRISD & 0xFF9F;
    
    int i=0; // for
    int v=0;
    while (1){
        int soma=0;
        double media;
        if(i++ % 25 ==0){ // 0,250ms,500ms,750ms,.... (250 a 250)
            AD1CON1bits.ASAM=1;    // ordem de conversao
            while(IFS1bits.AD1IF==0); // espera pelo final de conversao

            int *p = (int *) (&ADC1BUF0);
            
            for(;p<=(int *) (&ADC1BUFF);p+=4){
                soma += *p;
            }

            media = (double) soma/4.0; // soma dos resultados de conversao a dividir pelo numero deles
            v = (media*33)/1023;
            IFS1bits.AD1IF = 0;             //reset a AD1IF
        }

        send2displays(toBcd(v & 0xFF)); // toBcd(v & 0xFF) -> converte para hexadecimal
        delay(10); // espera 10 ms
    }
    
    return 0;
}