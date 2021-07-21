# include <detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void _int_(27) isr_adc(void){
    resetCoreTimer(); //contar o tempo ( codigo do stor)
    LATBbits.LATB6 = 0; // reset RB6
    printInt(ADC1BUF0, 16 | 3<<16);
    // para ver no terminal (foi o stor que disse)
    printStr(" ");
    //delay (200); // so para se esta a contar bem
    int timeValue = readCoreTimer(); // da nos o tempo
    printStr("Timer: ");
    printInt10(timeValue*50); // O período do PBClk = 1/ 20MHz = 50ns
    printStr(" ns\n");
    // para ver no terminal -> nao ha osciloscopio
    LATBbits.LATB6 = 0; // set RB6
    AD1CON1bits.ASAM = 1; // Star A/D conversion
    IFS1bits.AD1IF = 0; // reset interruption AD1IF flag 
}


int main(void){

    // configurar o RB6
    TRISEbits.TRISE6 = 1;

    // configuracao completa do modulo A/D
    TRISBbits.TRISB4 = 1;               //Desligar a componente digital de saída do porto
    AD1PCFGbits.PCFG4 = 0;              //Configurar o porto como entrada analógica (AN4) -> RB4

    AD1CON1bits.SSRC = 7;               //Bits de seleção do acionador de conversão: neste modo, um contador interno termina a amostragem e inicia a conversão
    AD1CON1bits.CLRASAM = 1;            //Parar conversões quando uma interrupção for gerada

    AD1CON3bits.SAMC = 16;              
    AD1CON2bits.SMPI = 1-1;             //Número de conversões consecutivas no canal é 1

    AD1CHSbits.CH0SA = 4;               //Selecionar AN4 como entrada para o Conversor A/D

    AD1CON1bits.ON = 1;                 //ativar o conversor

    // configurar as interrupcoes
    IPC6bits.AD1IP=2; // configurar as prioridades
    IEC1bits.AD1IE=1; // enable A\D interrupters
    IFS1bits.AD1IF = 0; // clear A\D interrupt flag
    EnableInterrupts();

    AD1CON1bits.ASAM = 1;// comecar a conversao A\D

    while(1){ }
    return 0;
}