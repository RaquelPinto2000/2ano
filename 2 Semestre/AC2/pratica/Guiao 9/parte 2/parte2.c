#include <detpic32.h>

#define DisableUart1RxInterrupt() IEC0bits.U1RXIE = 0 // disable e 0
#define EnableUart1RxInterrupt() IEC0bits.U1RXIE = 1 // enable e 1
#define DisableUart1TxInterrupt() IEC0bits.U1TXIE = 0
#define EnableUart1TxInterrupt() IEC0bits.U1TXIE = 1

#define BUF_SIZE 8
#define INDEX_MASK (BUF_SIZE -1)

typedef struct{
  unsigned char data[BUF_SIZE];
  unsigned int head;
  unsigned int tail;
  unsigned int count;
  unsigned int overrun;
} circularBuffer;

volatile circularBuffer txb; // Transmission Buffer
volatile circularBuffer rxb; // Reception Buffer


void comDrv_flushRx(void){
  // Initialize variables of the reception buffer
  rxb.head =0 ;
  rxb.tail=0;
  rxb.count = 0;
  rxb.overrun = 0; // false
}

void comDrv_flushTx(void){
  // Initialize variables of the transmission buffer
  txb.head=0;
  txb.tail=0;
  txb.count=0;
  txb.overrun = 0; //false
}


//write a char in the transmission buffer
void comDrv_putc(char ch){
    while(txb.count == BUF_SIZE){} // Wait while buffer is full
    txb.data[txb.tail] = ch; // Copy character to the transmission and buffer at position "tail"
    txb.tail = (txb.tail + 1) & INDEX_MASK; // Increment "tail" index and (mod. BUF_SIZE)
    DisableUart1TxInterrupt(); // Begin of critical section
    txb.count ++;// Increment "count" variable
    EnableUart1TxInterrupt(); // End of critical section
}


//write a string in the transmission buffer -> invoca a funcao anterior
void comDrv_puts(char *s){
  while(*s != '\0'){
    comDrv_putc(*s);
    s++;
  }
}

// funcao aux para a main
//como argumentos o baudrate, o tipo de paridade e o número de stop bits (o número de data bits deverá ser fixo e igual a 8)
void comDrv_config (unsigned int baud, char parity, unsigned int stopbits){
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
  IEC0bits.U1RXIE = 1;     // Rx interrupts enabled
  IEC0bits.U1TXIE = 1;     //Tx interrupts enabled
  IFS0bits.U1RXIF = 0;     //clear interrupts flag
  IFS0bits.U1TXIF = 0;     //reset Tx interrupt flag

  // Enable UART1
  U1MODEbits.ON = 1; //UARTx is enabled. UARTx pins are controlled by UARTx as defined by UEN<1:0> and UTXEN control bits
}


char comDrv_getc(char *pchar){
    // Test "count" variable (reception buffer) and return FALSE
    if(rxb.count ==0){ // if it is zero
      return 0;  // = return FALSE;
    }

    DisableUart1RxInterrupt(); // Begin of critical section
    *pchar = rxb.data[rxb.head]; // Copy character pointed by "head" to *pchar
    rxb.count--; // Decrement "count" variable
    rxb.head = (rxb.head +1) & INDEX_MASK;// Increment "head" variable (mod BUF_SIZE)
    EnableUart1RxInterrupt(); //End of critical section
    return 1; // = return TRUE;
}

// rotina de serviço à interrupção de receção da UART1
void _int_(24) isr_uart1 (void){
    //interrupcao a transmissao
    if(IFS0bits.U1TXIF==1){ //if U1TXIF is set
      while(txb.count>0){ // if "count" variable (transmission buffer, txb) is greater than 0
        U1TXREG =  txb.data[txb.head];          //copy char in head positio to the U1TXREG register
        txb.head= (txb.head +1) & INDEX_MASK;   //Increment "head" variable (mod BUF_SIZE)
        txb.count--;                            //decrement "count" variable
      }
      if(txb.count==0){ //if "count" variable is 0 then
        DisableUart1TxInterrupt();
      }
      IFS0bits.U1TXIF = 0; // Reset UART1 TX interrupt flag
    }

    //interrupcao a rececao
    if(IFS0bits.U1RXIF==1){ //if U1RXIF is set
      while(txb.count != BUF_SIZE && U1STAbits.UTXBF!=0){
        rxb.data[rxb.tail] = U1RXREG; // Read character from UART and write it to the "tail" position of the reception buffer
        rxb.tail = (rxb.tail + 1) & INDEX_MASK;//Increment "tail" variable (mod BUF_SIZE)
        if(rxb.count < BUF_SIZE){  //if reception buffer is not full
            rxb.count++;  //increment count variable
        }else{
          rxb.head = (rxb.head+1) & INDEX_MASK;//increment "head" variable (mod BUF_SIZE) discard oldest character
        }
      }
      IFS0bits.U1RXIF = 0;  //reset UART1 RX interrupt flag
    }

    if(IFS0bits.U1EIF == 1){
      char dumb;
      if(U1STAbits.OERR==1){
        rxb.overrun = 1;
        U1STAbits.OERR;
      }else{
        dumb = U1RXREG;
      }
      IFS0bits.U1EIF = 0;
    }
    
}

int main (void){
  char read;
  comDrv_config(115200,'N',1); // default "pterm" parameters with RX interrupts enabled and TX interrupts disabled
  comDrv_flushRx();
  comDrv_flushTx();
  EnableInterrupts();
  comDrv_puts("PIC32 UART Device-driver\n");
  while(1){
    comDrv_getc(&read); // Read character from reception buffer
    if(read == 'S'){
      comDrv_puts("abcdefghijklmpqrstuvxyz1234567890\n");
    }else{
      comDrv_putc(read);// Send character to the transmission buffer
    }
  }
}
