#include <detpic32.h>

void delay(int ms)
{
    for(;ms>0;ms--)
    {
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void putc (char byte2send){
  while (U1STAbits.UTXBF == 1); // wait while UTXBF == 1
  U1TXREG=byte2send; // Copy byte2send to the UxTXREG register
}

int main(void){
  // Configure UART1: ->  == Configure UART1 (115200, N, 8, 1)
   // 1 - Configure BaudRate Generator
  U1BRG = ((PBCLK + 8*115200)/(16*115200))-1; // contas do guiao
  U1MODEbits.BRGH = 0 ; //16x baud clock enabled
  // 2 – Configure number of data bits, parity and number of stop bits  (see U1MODE register)
  U1MODEbits.PDSEL = 0; // 8-bit data, no parity
  U1MODEbits.STSEL = 0;   //1 stop bit
  // 3 – Enable the trasmitter and receiver modules (see register U1STA)
  U1STAbits.UTXEN = 1; //UARTx transmitter is enabled. UxTX pin is controlled by UARTx (if ON = 1)
  U1STAbits.URXEN = 1; //UARTx receiver is enabled. UxRX pin is controlled by UARTx (if ON = 1)
  // 4 – Enable UART1 (see register U1MODE)
  U1MODEbits.ON = 1; //UARTx is enabled. UARTx pins are controlled by UARTx as defined by UEN<1:0> and UTXEN control bits

  while(1){
    putc('+');
    delay(1000); // wait 1s -> 1000ms
  }
  return 0;
}
