# include <detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

int main (void){

    TRISE = TRISE & 0xFFF0; // configurar os portos de RE0-RE3 como saida
    LATE = LATE & 0xFFF0; // ler os portos como saida
    int count=0;
    while(1){
        delay(250);
        LATE = 0xFFF0 | count; // nos queremos que fique tudo desligado menos os bits do count
        count++;

    }
    return 0;
}
