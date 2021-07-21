# include <detpic32.h>
 static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

int main(void){
  /*  LATB = LATB & 0x000F; // inicializa os pinos
    LATD = LATD & 0xFF9F; // inicializa os pinos
    */ // E preciso isto ? 
    TRISB = TRISB & 0x000F; // configurar os portos de RB0-RB3 como entradas
    TRISB = TRISB & 0x80FF; // configurar os portos de RB8-RB14 como saida
    TRISD = TRISD & 0xFF9F; // configurar os portos RD5 e RD6 como saida

    LATD = (LATD & 0xFF9F ) | 0x0020; // ativar o display low
    //LATD = (LATD & 0xFF9F ) | 0x0040; // ativar o display high

    while(1){
        int sitch = PORTB & 0x000F;

        LATB = (LATB & 0x80FF)|(display7Scodes[sitch]<<8); // <<8 serve para percorrer o array (4 bits para cada numero hexadecimal)
    }
    return 0;
}
