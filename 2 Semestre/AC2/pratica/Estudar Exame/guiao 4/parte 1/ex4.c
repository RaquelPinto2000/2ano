# include <detpic32.h>

void delay(int ms){
    for(;ms>0;ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

void display(unsigned char sg){
      switch(sg){
            case 'a'|'A':
                LATB = LATB & 0x00FF;
                LATBbits.LATB8 =1;
                break;
            case 'b'|'B':
                LATB = LATB & 0x00FF;
                LATBbits.LATB9 =1;
                break;
            case 'c'|'C':
                LATB = LATB & 0x00FF;
                LATBbits.LATB10 =1;
                break;
            case 'd'|'D':
                LATB = LATB & 0x00FF;
                LATBbits.LATB11 =1;
                break;
            case 'e'|'E':
                LATB = LATB & 0x00FF;
                LATBbits.LATB12 =1;
                break;
            case 'f'|'F':
                LATB = LATB & 0x00FF;
                LATBbits.LATB13 =1;
                break;
            case 'g'|'G':
                LATB = LATB & 0x00FF;
                LATBbits.LATB14 =1;
                break;
            case '.':
                LATB = LATB & 0x00FF;
                LATBbits.LATB15 =1;
                break;
            default: // fica tudo desativado = desligado
                LATB = LATB & 0xFFFF;
                break;
        } 
}

int main (void){
    unsigned char segment;
    TRISB = TRISB & 0x00FF; // configurar os portos de RB8-RB15 como saida
    TRISD = TRISD & 0xFF9F; // configurar os portos RD5 e RD6 como saida
    LATB = LATB & 0x00FF;
    LATD = LATD & 0xFF9F;

    // seleciona o display high
    LATDbits.LATD5 = 0; 
    LATDbits.LATD6 = 1;
    // ou assim LATD = (LATD & 0xFF9F) | 0x0040;

    while(1){
        segment='a';
        LATDbits.LATD5 = !LATDbits.LATD5; 
        LATDbits.LATD6 = !LATDbits.LATD6;
        // ou assim LATD = LATD ^ 0x0060;
        int i = 0;
        for(i = 0 ;i<7;i++){
            display(segment);
            delay(500);
            segment++;
        }

    }
    return 0;
}
