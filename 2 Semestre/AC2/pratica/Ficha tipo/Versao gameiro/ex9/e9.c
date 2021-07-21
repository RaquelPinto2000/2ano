#include <detpic32.h>

void configUART1()
{
    U1BRG = ((PBCLK + 8*1200)/(16*1200)) - 1;
    U1MODEbits.PDSEL = 0;
    U1MODEbits.STSEL = 0;
}

void configIO()
{
    TRISB = (TRISB & 0xFFF0) | 0x000F;
}

void putc(char byte2send)
{
    while(U1STAbits.UTXBF == 1);
    U1TXREG = byte2send;
}


int main(void)
{
    printStr("João Gameiro - Nº93097\n");
    printStr("Ex9 Preparação Exame Prático - AC2\n");

    configUART1();
    configIO();
    while(1)
    {
        printStr("\nValor nos interruptores: ");
        putc(PORTBbits.RB0);
        putc(PORTBbits.RB1);
        putc(PORTBbits.RB2);
        putc(PORTBbits.RB3);
    }

    return 0;
}

