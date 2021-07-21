# include <detpic32.h>


int main(void){
    volatile int aux;
    TRISEbits.TRISE0=0;
    // configuracao completa do modulo A/D
    TRISBbits.TRISB4 = 1;               //Desligar a componente digital de saída do porto
    AD1PCFGbits.PCFG4 = 0;              //Configurar o porto como entrada analógica (AN4) -> RB4

    AD1CON1bits.SSRC = 7;               //Bits de seleção do acionador de conversão: neste modo, um contador interno termina a amostragem e inicia a conversão
    AD1CON1bits.CLRASAM = 1;            //Parar conversões quando uma interrupção for gerada

    AD1CON3bits.SAMC = 16;              
    AD1CON2bits.SMPI = 1-1;             //Número de conversões consecutivas no canal é 4

    AD1CHSbits.CH0SA = 4;               //Selecionar AN4 como entrada para o Conversor A/D

    AD1CON1bits.ON = 1;                 //ativar o conversor

    while(1){
        LATEbits.LATE0 = 1; // enviar o LATE0
      
        AD1CON1bits.ASAM = 1; // comecar a conversao
        while(IFS1bits.AD1IF == 0);
        LATEbits.LATE0 = 0; // reset do LATE0
        aux = (ADC1BUF0);
        IFS1bits.AD1IF=0;

    
    }
    return 0;
}
