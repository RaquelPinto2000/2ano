# include <detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

int main(void){
    int count=0;
    while(1){
        count++;
        delay(100);
        if(count==100){
            count=0;
        }
        printStr("\r");
        printInt(count,10| 2<<10);
    }
    return 0;
}