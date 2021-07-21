#include <detpic32.h>
void delay(int ms)
{
    for(;ms>0;ms--)
    {
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

int main(void){
    int i;
    TRISBbits.TRISB4 = 1;               //Desligar a componente digital de saída do porto
    AD1PCFGbits.PCFG4 = 0;              //Configurar o porto como entrada analógica (AN4)

    AD1CON1bits.SSRC = 7;               //Bits de seleção do acionador de conversão: neste modo, um contador interno termina a amostragem e inicia a conversão
    AD1CON1bits.CLRASAM = 1;            //Parar conversões quando uma interrupção for gerada

    AD1CON3bits.SAMC = 16;              
    AD1CON2bits.SMPI = 4-1;             //Número de conversões consecutivas no canal é 4

    AD1CHSbits.CH0SA = 4;               //Selecionar AN4 como entrada para o Conversor A/D

    AD1CON1bits.ON = 1;                 //ativar o conversor

    while(1){
        AD1CON1bits.ASAM=1;    // ordem de conversao
        while(IFS1bits.AD1IF==0); // espera pelo final de conversao
        int soma =0;
        int v; // amplitude da tensao
        double media;
        int *p = (int *) (&ADC1BUF0);
        
        for(;p<=(int *) (&ADC1BUFF);p+=4){
            printInt(*p, 10 | 4 << 10);
            printStr("  ");
            soma += *p;
        }

        media = (double) soma/4.0; // soma dos resultados de conversao a dividir pelo numero deles
        v = (media*33)/1023;
        printStr("\nMedia: ");
        printInt ((int)media, 10 | 4 << 10);
        printStr("\nAmplitude da tensao: ");
        printInt(v, 10 | 4 << 10);
        printStr("\n"); 
        delay(900); // atrasa 900ms , e so para vermos a funcionar
        IFS1bits.AD1IF = 0;             //reset a AD1IF
    }
    return 0;
}