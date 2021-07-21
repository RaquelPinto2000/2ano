#include <detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}
void putc(char byte2send){
    while(U1STAbits.UTXBF==1);
    U1TXREG = byte2send;
}
void puts(char * str){
    while(*str!='\0'){
        putc(*str);
        str++;
    }
}

void configUart(unsigned int baud, char parity, unsigned int stopbits){
    if(baud <600 || baud>115200){
        baud = 115200;
    }
    if(parity!= 'N' || parity != 'E' || parity != 'O'){
        parity = 'N';
    }
    if(stopbits != 1 || stopbits != 2){
        stopbits = 1;
    }
    U1BRG = ((PBCLK + 8*baud)/(16*baud))-1; 
    U1MODEbits.BRGH = 0 ;
    if(parity=='N'){
        U1MODEbits.PDSEL = 0;
    }else if(parity=='E'){
        U1MODEbits.PDSEL = 1;
    }else if(parity=='O'){
        U1MODEbits.PDSEL = 2;
    }else{
        puts("Algo de errado nao esta certo na seleção de paridade para o UART\n");
    }
    
    if(stopbits == 1){
        U1MODEbits.STSEL = 0;
    }else if(stopbits ==2){
        U1MODEbits.STSEL = 1;
    }else{
        puts("Algo de errado nao esta certo na seleção dos stopbits para o UART\n");
    }
    
    U1STAbits.UTXEN = 1; 
    U1STAbits.URXEN = 1; 

    IPC6bits.U1IP = 2;       //priority 2
    IEC0bits.U1RXIE = 1;     //interrupts enabled
    IFS0bits.U1RXIF = 0;     //clear interrupts flag


    U1MODEbits.ON = 1;

}

void _int_(24) isr_uart1(void){
    putc(U1RXREG);
    IFS0bits.U1RXIF=0;
}

int main (void){
    configUart(115200,'N',1);
    
    EnableInterrupts();
    while(1);
    return 0;
}
