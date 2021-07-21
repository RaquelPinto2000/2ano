#include <detpic32.h>

void delay(int ms)
{
    for(;ms>0;ms--)
    {
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
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
  // Enable UART1
  U1MODEbits.ON = 1; //UARTx is enabled. UARTx pins are controlled by UARTx as defined by UEN<1:0> and UTXEN control bits

}

char getc(void){
  if(U1STAbits.OERR == 1){   // If OERR == 1 then reset OERR
    U1STAbits.OERR =0;
  }
  while(U1STAbits.URXDA==0);// Wait while URXDA == 0
  if(U1STAbits.FERR || U1STAbits.PERR){ // If FERR or PERR then
    //read UxRXREG (to discard the character) and return 0
    char read = U1RXREG;
    return 0;
  }else{ //else Return U1RXREG
    return U1RXREG;
  }
}


int main(void){
    configUart(115200, 'N', 1);
    while(1){
      putc(getc());
    }
    return 0;
}
