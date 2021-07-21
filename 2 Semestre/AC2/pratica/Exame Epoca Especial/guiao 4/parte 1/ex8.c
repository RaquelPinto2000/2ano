# include <detpic32.h>

static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71};

int main(void){
    TRISB = TRISB & 0x80FF;// configurar os portos de RB8-RB14 como saida
    LATB = LATB & 0x80FF;// inicializar RB8-RB14 a 0
    TRISD = TRISD & 0xFF9F;
   
    TRISB = TRISB & 0x000F;/// configurar os portos de RB0-RB3 como entradas
    LATD = (LATD & 0xFF9F) | 0x0020; // para o mais significativo poe se 0040

    while(1){
        int s = PORTB & 0x000F;
        
        LATB = (LATB & 0x80FF)| display7Scodes[s]<<8; // ou fica a 0 ou queremos atualizar
    }
    return 0;
}
