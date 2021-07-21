#include<detpic32.h>
void putc(char);
unsigned char toBcd(unsigned char);
int i = 0, sum = 0, V = 0, k = 0;
#define BUF_SIZE 64
#define INDEX_MASK (BUF_SIZE - 1)

typedef struct
{
    unsigned char data[BUF_SIZE];
    unsigned int head;
    unsigned int tail;
    unsigned int count;
} circularBuffer;

volatile circularBuffer buffer;

void flush(void) {
    int i = 0;
    for (i = 0; i < BUF_SIZE; i++) {
        buffer.data[i] = 0;
    }
    buffer.count = 0;
    buffer.tail = 0;
    buffer.head = 0;
}

void buffer_putc(char ch)
{
    while(buffer.count == BUF_SIZE);
    buffer.data[buffer.tail] = ch;
    buffer.tail = (buffer.tail + 1) & INDEX_MASK;
    buffer.count++;
}

char buffer_getc(char *pchar) {
    if(buffer.count == 0){
        return 0;
        printf("%s\n", "SOU ZERO");
    }
    *pchar = buffer.data[buffer.head];  // Copy character pointed by "head" to *pchar
    buffer.count--;
    buffer.head = (buffer.head + 1) & INDEX_MASK;
    return 1;
}


void puts(char *str) {
    int i = 0;
    while(str[i]!='0'){
        putc(str[i]);
        i++;
    }
}

int main(void){

    // TRIS
    TRISE = TRISE | 0x00F0;

    //UART1
    U1BRG = ((20000000 + 8 * 57600) / (16 * 57600)) - 1;
    U1MODEbits.BRGH = 0;
    U1MODEbits.STSEL = 0;
    U1MODEbits.PDSEL = 2;
    U1STAbits.URXEN = 1;
    U1STAbits.UTXEN = 1;
    U1MODEbits.ON = 1;

    //UART interrupts
    U1STAbits.URXISEL = 00;
    IEC0bits.U1RXIE = 1;
    IPC6bits.U1IP = 3;

    //Timer 2
    PR2 = 49999;
    T2CONbits.TCKPS = 3;
    TMR2 = 0;

    // Timer interrupts
    IFS0bits.T2IF = 0;
    IPC2bits.T2IP = 2;
    IEC0bits.T2IE = 1;

    //ADC
    TRISBbits.TRISB14 = 1;
    AD1PCFGbits.PCFG14 = 0;
    AD1CHSbits.CH0SA = 14;
    AD1CON2bits.SMPI = 15;
    AD1CON1bits.SSRC = 7;
    AD1CON1bits.CLRASAM = 1;
    AD1CON3bits.SAMC = 16;
    AD1CON1bits.ON = 1;

    //ADC interrupts
    IPC6bits.AD1IP = 3;
    IEC1bits.AD1IE = 1;

    EnableInterrupts();

    while(1);

}

void _int_(24) isr_uart1(void){
    if(IFS0bits.U1RXIF){
        char c = U1RXREG;

        if(c == 'R'){
            T2CONbits.TON = 1;
        }else if(c == 'L'){
            T2CONbits.TON = 0;
            char pchar;
            while(buffer_getc(&pchar)){
                putc('0' + ((toBcd(pchar) & 0xF0)>>4));
                putc('0' + ((toBcd(pchar) & 0x0F)));
                putc('\n');
            }
        }
    }
    IFS0bits.U1RXIF = 0;
}

void putc(char byte2send) {
    while(U1STAbits.UTXBF);// wait while UTXBF == 1
    U1TXREG = byte2send;    // Copy byte2send to the UxTXREG register
}

void _int_(27) isr_adc(void){

    int *p = (int *)(&ADC1BUF0);
    for( i = 0; i < 16; i++ ){
        sum += p[i*4];
    }

    V=((sum/16)*70+511)/1023;

    sum = 0;

    IFS1bits.AD1IF = 0;
}

void _int_(8) isr_T2(void){
    AD1CON1bits.ASAM = 1;
    if(++k == 25){
        k = 0;
        putc('0' + ((toBcd(V) & 0xF0)>>4));
        putc('0' + ((toBcd(V) & 0x0F)));
        putc('\n');
        buffer_putc(V);
    }
    IFS0bits.T2IF = 0;
}
