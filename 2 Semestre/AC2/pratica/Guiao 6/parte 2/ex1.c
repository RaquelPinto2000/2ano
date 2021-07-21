#include <detpic32.h>
// nao esta bem
volatile int adc_value;

void delay(int ms)
{
    for(;ms>0;ms--)
    {
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

// interrupt Handler -> rotina de servico a interrupcao
void _int_(27) isr_adc(void){
    LATE0 = 0; // reset RE0
   // printInt(ADC1BUF0, 16 | 3<<16);
    adc_value= ADC1BUF0; // read ADC1BUF0 value to "adc_value"
    LATE0 = 1; // set RE0
    AD1CON1bits.ASAM = 1; // Star A/D conversion
    IFS1bits.AD1IF = 0; // reset interruption AD1IF flag 
}

void main(void){

    TRISE = TRISE & 0xFFFE; //configurar RE0 como saida
    LATE0 = LATE0 & 0xFFFE;

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

    // start A/D conversion
    while(1){ 

    }
    return 0;
}