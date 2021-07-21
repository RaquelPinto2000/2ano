# include <detpic32.h>




void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

int count=0;

void _int_(12) isr_T3(void){
    char ch = inkey();
    int t=0;
    int freq=0;
    
    count++;
    if(ch == '\n'){
        printStr("\r");
        printInt(count, 10 | 2 << 10);
        printStr(" >> ");
        printInt(count, 10 | 2 << 10);
        printStr("\n");
        delay(t);

    }else if(ch == '0' ){
        freq = 10*(1+0);
        t=1/freq;
        if(count==100){
        count=0;
        }
        printStr("\r");
        printInt(count,10| 2<<10);
        delay(t*1000);

    }else if(ch=='1'){
        freq = 10*(1+1);
        t=1/freq;
        if(count==100){
            count=0;
        }
        printStr("\r");
        printInt(count,10| 2<<10);
        delay(t*1000);

    }else if(ch=='2'){
        freq = 10*(1+2);
        t=1/freq;
        if(count==100){
            count=0;
        }
        printStr("\r");
        printInt(count,10| 2<<10);
        delay(t*1000);

    }else if(ch=='3'){
        freq = 10*(1+3);
        t=1/freq;
        if(count==100){
            count=0;
        }
        printStr("\r");
        printInt(count,10| 2<<10);
        delay(t*1000);

    }else{
        t = 100; 
           freq=0;
           delay(t);  
    }
    if(count==100){
        count=0;
    }
    printStr("\r");
    printInt(count,10| 2<<10);
    
    IFS0bits.T3IF = 0;
}

int main(void){ 
    // frequencia inicialmente e 10hz
    // configurar o timer
    T3CONbits.TCKPS = 5;
    PR3 = 62499;
    TMR3 = 0;
    T3CONbits.TON = 1;

    while(1){
        //interrupcao
        IPC3bits.T3IP = 2;
        IEC0bits.T3IE = 1;
        IFS0bits.T3IF = 0;
        EnableInterrupts();
    }
    return 0;
}

