#include <detpic32.h>
//da erro

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);

    }
}
void send2displays(unsigned char value){
    static const char displays7codes[]={0x3F,0x06,0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x7C,0x39,0x5E,0x79,0x71};
    static char displaysFlag=0;
    int dh = displays7codes[value>>4];
    int dl = displays7codes[value & 0x0F];
    if(displaysFlag==0){
        LATDbits.LATD6=1;
        LATDbits.LATD5=0;
        LATB = (dl<<8) | ( LATB & 0x00FF);
        if(value % 2 != 0){
            LATBbits.LATB15 = 1;
        }
    }else{
        LATDbits.LATD6=1;
        LATDbits.LATD5=0;
        LATB = (dh<<8) | ( LATB & 0x00FF);
        if(value % 2 != 0){
            LATBbits.LATB15 = 1;
        }
    }

    displaysFlag = ! displaysFlag;    
}

unsigned int freq = 0;
void _int_(8) isr_T2(void){
    
    send2displays(freq);

    // Reset T2 interrupt flag
    IFS0bits.T2IF = 0;
}


void _int_(27) isr_adc(void){
   
    freq = 1+(ADC1BUF0/255);
    

    delay((1/freq)*1000);

    IFS1bits.AD1IF = 0;
}

void putc(char byte2send ){ // imprimir char
    while(U1STAbits.UTXBF==1);
    U1TXREG = byte2send;
}

void puts (char *str){
    while(*str != '\0'){
        puts(*str);
        str++;
    }
}

void configUART(unsigned int baudrate, char priority, unsigned int stopbits){

    if(baudrate > 115200 || baudrate< 600){
        baudrate = 115200;
    }
    if(parity != 'N' || parity != 'E' || parity != 'O'){
        parity = 'N';
    }
    if(stopbits != 1 || stopbits !=2){
        stopbits = 1;

    }
    // baudrate = 1200
    U1BRG = ((PBCLK + 8 *baudrate)/(16*baudrate))-1;
   
    U1MODEbits.BRGH = 0;
    if(parity == 'N'){
        U1MODEbits.PDSEL = 0;  // nao tem paridade 
    }else if(parity == 'E'){
         U1MODEbits.PDSEL = 1;  // paridade par
    }else if(parity == 'O'){
         U1MODEbits.PDSEL = 2;  // paridade impar
    }else {
        printf("ERRO na paridade");
    }

    if(stopbits==1){
        U1MODEbits.STSEL = 0; // 1 stop bit
    }else if(stopbits == 2){
        U1MODEbits.STSEL = 1; // 2 stop bit
    }else{
        printf("ERRO no stop");
    }
   
    // Enable the trasmitter and receiver modules -> ativar os modilos
    U1STAbits.UTXEN = 1; //UARTx transmitter is enabled. UxTX pin is controlled by UARTx (if ON = 1)
    U1STAbits.URXEN = 1; //UARTx receiver is enabled. UxRX pin is controlled by UARTx (if ON = 1)

      IPC6bits.U1IP = 2;       //priority 2
  IEC0bits.U1RXIE = 1;     //interrupts enabled
  IFS0bits.U1RXIF = 0;     //clear interrupts flag

    // Enable UART1
    U1MODEbits.ON = 1; //UARTx is enabled. UARTx pins are controlled by UARTx as defined by UEN<1:0> and UTXEN control bits

}

int main(void){

    configUART();
    TRISB = TRISB & 0x000F;  // configurar os portos de RB0-RB3 como entrada
   

    //adc
    TRISBbits.TRISB4 = 1;
    AD1PCFGbits.PCFG4= 0;
    AD1CON1bits.SSRC = 7;

    AD1CON1bits.CLRASAM = 1;
    
    AD1CON3bits.SAMC = 16;

    AD1CON2bits.SMPI = 1-1; 

    AD1CHSbits.CH0SA = 4;

    AD1CON1bits.ON = 1;
    

    // configurar a IPC6
    IPC6bits.AD1IP = 2; // A/D interrupts priority 
    IEC1bits.AD1IE = 1; // A/D interrupts enabled
    IFS1bits.AD1IF = 0; // Reset AD1IF flag

    TRISDbits.TRISD5 = 0;       // configure RD5-RD6 as outputs
    TRISDbits.TRISD6 = 0;

    // configurar o timer

    T2CONbits.TCKPS = 2;
    PR2 = 50000;
    TMR2 = 0;
    T2CONbits.TON = 1;

    IPC2bits.T2IP = 2;  // Interrupt priority (must be in range [1..6])
    IEC0bits.T2IE = 1;  // Enable timer T2 interrupts
    IFS0bits.T2IF = 0;  // Reset timer T2 interrupt flag
    
    EnableInterrupts();

    while(1){
        //comecar a conversao
       // AD1CON1bits.ASAM = 1;  
        //while(IFS1bits.AD1IF == 0);


        
        putc(PORTBbits.RB0);
        putc(PORTBbits.RB1);
        putc(PORTBbits.RB2);
        putc(PORTBbits.RB3);
        puts("\n");

        AD1CON1bits.ASAM = 1;
        //while(IFS1bits.AD1IF == 0);
    }
    return 0;

}
