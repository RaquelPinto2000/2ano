# include <detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void _int_(12) isr_T3(void){
     IFS0bits.T3IF = 0;
}

int main(void){
    int count=0;
    double freq=0;
    double t = 0;
    while(1){
        char ch = inkey();
        count++;
        if(ch == '0'){
            while(ch =='0'){
                ch = inkey();
                freq = 10*(1+0);
                t = 1/freq;
                T3CONbits.TCKPS = 5;
                PR3 = 62499;
                TMR3 = 0;
                T3CONbits.TON = 1;
                IPC3bits.T3IP = 2;
                IEC0bits.T3IE = 1;
                IFS0bits.T3IF = 0;
                EnableInterrupts();
                
                if(count==100){
                    count=0;
                }
                printStr("\r");
                printInt(count,10| 2<<10);
                delay(t*1000);
            }
        }else if(ch == '1'){
            //char flag='1';
            while(ch =='1'){
                ch = inkey();
                freq = 10*(1+1);
                t = 1/freq;

                T3CONbits.TCKPS = 4;
                PR3 = 62499;
                TMR3 = 0;
                T3CONbits.TON = 1;
                IPC3bits.T3IP = 2;
                IEC0bits.T3IE = 1;
                IFS0bits.T3IF = 0;
                EnableInterrupts();

                if(count==100){
                    count=0;
                }
                printStr("\r");
                printInt(count,10| 2<<10);
                delay(t*1000);
            }

        }else if(ch=='2'){
            // char flag='2';
            while(ch =='2'){
                ch = inkey();
                //flag = (ch=='2' | inkey());
                freq = 10*(1+2);
                t = 1/freq;

                T3CONbits.TCKPS = 4;
                PR3 = 41664;
                TMR3 = 0;
                T3CONbits.TON = 1;
                IPC3bits.T3IP = 2;
                IEC0bits.T3IE = 1;
                IFS0bits.T3IF = 0;
                EnableInterrupts();

                if(count==100){
                    count=0;
                }
                printStr("\r");
                printInt(count,10| 2<<10);
                delay(t*1000);
            }

        }else if(ch=='3'){
            //char flag='3';
            while(ch =='3'){
                ch = inkey();
                //flag = (ch=='3' | inkey());
                freq = 10*(1+3);
                t = 1/freq;
                
                T3CONbits.TCKPS = 8;
                PR3 = 62499;
                TMR3 = 0;
                T3CONbits.TON = 1;
                IPC3bits.T3IP = 2;
                IEC0bits.T3IE = 1;
                IFS0bits.T3IF = 0;
                EnableInterrupts();

                if(count==100){
                    count=0;
                }
                printStr("\r");
                printInt(count,10| 2<<10);
                delay(t*1000);
            }

        }else if(ch=='4'){
            //char flag='4';
            while(ch =='4'){
                ch = inkey();
              //  flag = (ch=='4' | inkey());
                freq = 10*(1+4);
                t = 1/freq;
                T3CONbits.TCKPS = 8;
                PR3 = 49999;
                TMR3 = 0;
                T3CONbits.TON = 1;
                IPC3bits.T3IP = 2;
                IEC0bits.T3IE = 1;
                IFS0bits.T3IF = 0;
                EnableInterrupts();

                if(count==100){
                    count=0;
                }
                printStr("\r");
                printInt(count,10| 2<<10);
                delay(t*1000);
            }

        }else if(ch=='\n'){
            printStr("\r");
            printInt(count, 10 | 2 << 10);
            printStr(" >> ");
            printInt(count, 10 | 2 << 10);
            t = 100;
            freq = 0;
            printStr("\n");
            delay(t); 
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
               
    }
    return 0;
}

