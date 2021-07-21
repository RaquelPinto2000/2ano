# include <detpic32.h>
int main (void){
    LATDbits.LATD0 =1;
    TRISDbits.TRISD0 = 0; //output

    LATDbits.LATD0 = 0;
    LATDbits.LATD0 = !LATDbits.LATD0;
    return 0;
}