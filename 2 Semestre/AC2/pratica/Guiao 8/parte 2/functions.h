#include <detpic32.h>

//como argumentos o baudrate, o tipo de paridade e o número de stop bits (o número de data bits deverá ser fixo e igual a 8)
void configUart (unsigned int baud, char parity, unsigned int stopbits){
  // verificar valores
  if(baud > 115200 || baud< 600){
    baud = 115200;
  }
  if(parity != 'N'||parity != 'E'||parity != 'O'){
    parity = 'N';
  }
  if(stopbits != 1 || stopbits !=2){
    stopbits = 1;
  }

  // Configure BaudRate Generator
  U1BRG = ((PBCLK + 8*baud)/(16*baud))-1; // contas do guiao
  U1MODEbits.BRGH = 0 ; //16x baud clock enabled
  // Configure number of data bits (8), parity and number of stop bits
  //data bits e paridade
  if(parity == 'N'){ // tbm pode ser 0,01,10
    U1MODEbits.PDSEL = 0; // 8-bit data, no parity  (sem paridade)
  }else if(parity == 'E'){
    U1MODEbits.PDSEL = 1; // 8-bit data, even parity  (paridade par)
  }else if(parity == 'O'){
    U1MODEbits.PDSEL = 2; // 8-bit data, old parity (paridade impar)
  }else{
    printf("Algo de errado nao esta certo na seleção de paridade para o UART\n");
  }
  //stop bits
  if(stopbits ==1){
    U1MODEbits.STSEL = 0;   //1 stop bit
  }else if(stopbits ==2){
      U1MODEbits.STSEL = 1;   //2 stop bit
  }else{
    printf("Algo de errado nao esta certo com o numero de paragem para o UART\n");
  }
  // Enable the trasmitter and receiver modules
  U1STAbits.UTXEN = 1; //UARTx transmitter is enabled. UxTX pin is controlled by UARTx (if ON = 1)
  U1STAbits.URXEN = 1; //UARTx receiver is enabled. UxRX pin is controlled by UARTx (if ON = 1)


  IPC6bits.U1IP = 2;       //priority 2
  IEC0bits.U1RXIE = 1;     //interrupts enabled
  IFS0bits.U1RXIF = 0;     //clear interrupts flag


  // Enable UART1
  U1MODEbits.ON = 1; //UARTx is enabled. UARTx pins are controlled by UARTx as defined by UEN<1:0> and UTXEN control bits
}

// envia o caracter que recebe
void putc (char byte2send){
  while (U1STAbits.UTXBF == 1); // wait while UTXBF == 1
  U1TXREG=byte2send; // Copy byte2send to the UxTXREG register
}

//processa a string que recebe(array de char) e envia -> usa a putc(char byte2send)
void puts(char *str){
  while(*str != '\0'){ // o ultimo caracter de uma string e '\0'
    putc(*str);
    str++; // aumenta o ponteiro para apontar para o char seguinte
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

// converte para decimal de Hexadecimal
unsigned char toBcd(unsigned char value){
    return ((value/10)<<4) + (value % 10);
}


void configureAll(){
  //displays -> configure digital I/O
  TRISB = TRISB & 0X00FF;//configurar RB15 to RB8 como outputs; (RB15 = ponto)
  LATB = LATB & 0X00FF;

  TRISD = TRISD & 0xFF9F; //configurar RD6 to RD5 como outputs;
  LATD = LATD & 0XFF9F;

  TRISBbits.TRISB0 = 1;               //configure RB0 as input
  TRISBbits.TRISB1 = 1;               //configure RB1 as intput


   // analog input, A/D module)
  TRISBbits.TRISB4 = 1;               //Desligar a componente digital de saída do porto
  AD1PCFGbits.PCFG4 = 0;              //Configurar o porto como entrada analógica (AN4)

  AD1CON1bits.SSRC = 7;               //Bits de seleção do acionador de conversão: neste modo, um contador interno termina a amostragem e inicia a conversão
  AD1CON1bits.CLRASAM = 1;            //Parar conversões quando uma interrupção for gerada

  AD1CON3bits.SAMC = 16;
  AD1CON2bits.SMPI = 8-1;             //Número de conversões consecutivas no canal é 8  -> 8 amostras consecutivas

  AD1CHSbits.CH0SA = 4;               //Selecionar AN4 como entrada para o Conversor A/D

  AD1CON1bits.ON = 1;                 //ativar o conversor

  IPC6bits.AD1IP = 2; // configure priority of A/D interrupts to 2
  IEC1bits.AD1IE = 1; // enable A/D interrupts
  IFS1bits.AD1IF=0; // Reset interrupts flag
}

void configureTimers(){
  // configurar o T1
  T1CONbits.TCKPS = 3; // Kprescaler=256
  PR1 = 19530; // PR1 = 19530
  TMR1=0; // reset timer T1 count register
  T1CONbits.TON = 1; // Enable timer T1

  // configurar 0 T3
  T3CONbits.TCKPS = 2; // Kprescaler=4
  PR3 = 49999; // PR3 = 49999
  TMR3=0; // reset timer T3 count register
  T3CONbits.TON = 1; // Enable timer T3

  // configure timer T1 interrupts
  IPC1bits.T1IP=2; // Interrupt priority (must be in range [1..6]) -> set priority
  IEC0bits.T1IE=1;// Enable timer T1 interrupts
  IFS0bits.T1IF=0; // Reset timer T1 interrupt flag

  // configurar timer T3 interrupts
  IPC3bits.T3IP=2; // Interrupt priority (must be in range [1..6]) -> set priority
  IEC0bits.T3IE=1;// Enable timer T3 interrupts
  IFS0bits.T3IF=0; // Reset timer T3 interrupt flag
}

void gerarSinalPWM(){
  OC1CONbits.OCM = 6; //PWM mode on OCx; fault pin disabled
  OC1CONbits.OCTSEL = 1; //Use timer T3 as the time base for PWM generation
  OC1CONbits.ON = 1; //Enable OC1 module
}
void setPWM(unsigned int dutyCycle){
    OC1RS = ((49999+1)*dutyCycle)/100; // Evaluate OC1RS as a function of "dutyCycle"
      OC1CONbits.ON = 1; //Enable OC1 module
    // para acender o led da placa
    TRISEbits.TRISE0 = 0;
    LATEbits.LATE0 = LATDbits.LATD0;
}
