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
    U1MODEbits.ON = 1;

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

int main (void){
    configUart(115200,'N',1);
    
    while(1){
       putc(getc());
    }
    return 0;
}
