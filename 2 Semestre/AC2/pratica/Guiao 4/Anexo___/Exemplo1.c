// (led nao liga e nao fica ligado)
# include <detpic32.h>
int main(void){
    PORTDbits.RD0 =1;
    TRISDbits.TRISD0 = 0; //output

    PORTDbits.RD0 = 0;
    PORTDbits.RD0 = !PORTDbits.RD0;
    return 0;
}

/* // (led liga e fica ligado depois)
# include <detpic32.h>
int main(void){
    PORTDbits.RD0 =1;
    TRISDbits.TRISD0 = 0; //output

    PORTDbits.RD0 = 0;
    asm volatile ("nop"); //inline
    asm volatile ("nop"); // assembly
    PORTDbits.RD0 = !PORTDbits.RD0;
    return 0;
} 
*/