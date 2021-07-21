#include <detpic32.h>

void delay(int ms)
{
    for(;ms>0;ms--)
    {
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

// interrupt Handler
void _int_(27) isr_adc(void){ // codigo do stor mais o meu para nao se ter de usar o osciloscopio
    resetCoreTimer();
    printInt(ADC1BUF0, 16 | 3<<16);
    AD1CON1bits.ASAM = 1; // para conversoes quando a interrupcao for guardada
    IFS1bits.AD1IF=0; // da reset a AD1IF flag   
    LATBbits.LATB6 = 1; // ativa RB6 no final da interrupcao
}

void main(void){
     // configure all(digital I/O, analog input, A/D module)
    TRISBbits.TRISB4 = 1;               //Desligar a componente digital de saída do porto
    AD1PCFGbits.PCFG4 = 0;              //Configurar o porto como entrada analógica (AN4)

    AD1CON1bits.SSRC = 7;               //Bits de seleção do acionador de conversão: neste modo, um contador interno termina a amostragem e inicia a conversão
    AD1CON1bits.CLRASAM = 1;            //Parar conversões quando uma interrupção for gerada

    AD1CON3bits.SAMC = 16;              
    AD1CON2bits.SMPI = 1-1;             //Número de conversões consecutivas no canal é 1

    AD1CHSbits.CH0SA = 4;               //Selecionar AN4 como entrada para o Conversor A/D

    AD1CON1bits.ON = 1;                 //ativar o conversor

    //Configure Interrupt System 

    IPC6bits.AD1IP = 2; // configure priiority of A/D interrupts to 2
    IEC1bits.AD1IE = 1; // enable A/D interrupts
    IFS1bits.AD1IF = 0; // clear A/D interrupt flag -> reset
    EnableInterrupts();             //Global interrupt enable

    AD1CON1bits.ASAM = 1;           //A/D conversion begins

    while(1){
        LATBbits.LATB6 = 0;
        // codigo do stor para vermos os tempos em vez do que viamos no osciloscopio
        int value = readCoreTimer();
        printStr(" Time: ");
        printInt10(value*50);
        printStr("ns\n");
    }


    return 0;
}