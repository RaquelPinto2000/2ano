#include <detpic32.h>

void configUart(unsigned int baud, char parity, unsigned int stopbits)
{
    if(baud < 600 || baud > 115200)
        baud = 115200;
    if(parity!='N' || parity!='E' || parity!='O')
        parity = 'N';
    if(stopbits!=1 || stopbits!=2)
        stopbits = 1;
    
    U1BRG = ((PBCLK+8*baud)/(16*baud))-1;       //configure baudrate generator
    U1MODEbits.BRGH = 0;                        //16x baud clk enabled

    //config parity,  nºbits = 8
    switch(parity){
        case 'N':
            U1MODEbits.PDSEL = 0;               //8 bits, no parity
            break;
        case 'E':
            U1MODEbits.PDSEL = 1;               //8 bits, even parity
            break;
        case 'O':
            U1MODEbits.PDSEL = 2;               //8 bits, odd parity
            break;
    }

    //config stopbits
    switch(stopbits){
        case 2:
            U1MODEbits.STSEL = 1;               //2 stop bits
            break;
        case 1:
            U1MODEbits.STSEL = 0;               //1 stop bit
            break;
    }

    U1STAbits.URXEN = 1;                        //UART1 receiver is enabled
    U1STAbits.UTXEN = 1;                        //UART1 transmitter is enabled
    U1MODEbits.ON = 1;                          //UART1 enabled
}

void delay(int ms)
{
    for(;ms>0;ms--)
    {
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void putc(char byte2send)
{
    while(U1STAbits.UTXBF == 1);                    //wait while UTXBF==1
    U1TXREG = byte2send;

}

void puts(char * str)
{
    while(*str !='\0'){
        putc(*str);
        str++;
    }
}


int main(void)
{
    configUart(600, 'N', 1);          
    //configUart(1200, 'O', 2);
    //configUart(9600, 'E', 1);
    //configUart(19200, 'N', 2);
    //configUart(115200, 'N', 1); //Se aquilo ali em baixo funcionar apaga essa merda e descomenta este e testa com este
    //configUart(1200, 'O', 8, 2);

  /*  //Configure UART1  --isto é o que tens de apagar se funcionar(todas estas linhas deste bloco)
    U1BRG = ((PBCLK + 8*115200)/(16*115200))-1;     //Constant U1BRG, baudrate 115200bps
    U1MODEbits.BRGH = 0;                            //16x baud clock enabled
    U1MODEbits.PDSEL = 0;                           //8 data bits, no parity
    U1MODEbits.STSEL = 0;                           //1 stop bit
    U1STAbits.URXEN = 1;                            //Receiver is enabled
    U1STAbits.UTXEN = 1;                            //Transmiter is enabled
    U1MODEbits.ON = 1;                              //UART1 enabled
*/
    while(1)
    {
        putc('+');
        delay(1000);                                //wait 1 s
    }

    return 0;
}
