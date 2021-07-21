#include <detpic32.h>

void delay (int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

int main(void){

    TRISE = (TRISE & 0xFFF0);

    while(1){
        char letra = getChar();
        if(letra=='0'){
            LATE = (LATE & 0xFFFE) | 0x0001; // liga o RE0
        }else if(letra=='1'){
            LATE =(LATE & 0xFFFD) | 0x0002;// liga o RE1
        }else if(letra=='2'){
            LATE = (LATE & 0xFFFB) | 0x0004; // liga o RE2
        }else if(letra=='3'){
            LATE = (LATE & 0xFFF7) | 0x0008; // liga o RE3
        }else{
            LATE = (LATE & 0xFFF0) | 0x000F; // liga todos
            delay(1000); // espera 1 segundo 
            LATE = (LATE & 0xFFF0) | 0x0000; // deliga todos
        }
    }
    return 0;
}