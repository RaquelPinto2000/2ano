#void main(void)
#{
#    int v = 0;
#    TRISE0 = 0;   // Configura o porto RE0 como saída
#    while(1)
#    {
#        LATE0 = v;     // Escreve v no bit 0 do porto E -> queres alterar o bit 0
#        delay(500);   // Atraso de 500ms
#        v ^= 1;   // complementa o bit 0 de v (v = v xor 1)
#    }
#}
        .equ SFR_BASE_HI, 0xBF88  # 16 MSbits of SFR area
        .equ TRISE, 0x6100 #TRISE address is 0xBF886100
        .equ PORTE, 0x6110 #PORTE address is 0xBF886110
        .equ LATE, 0x6120  #LATE address is 0xBF886120
        .equ READ_CORE_TIMER,11
        .equ RESET_CORE_TIMER,12
        .data
        .text
        .globl main


#mapa de registos
# $t0 = v
main:   li $t0,0  #int v = 0;
        #TRISE0 = 0;   // Configura o porto RE0 como saída
        lui $t1, SFR_BASE_HI 
        lw $t2,TRISE($t1) # READ (Mem_addr = 0xBF880000 + 0x6100)
        andi $t2,$t2,0xFFFE # MODIFICA o bit 0   E = 1110
        sw $t2,TRISE($t1) # WRITE (Write TRISE register)


       # while(1)
while:  # LATE0 = v;     // Escreve v no bit 0 do porto E -> queres alterar o bit 0
        lw $t2, LATE($t1)
        andi $t2,$t2, 0xFFFE # fui buscar o bit 0
        or $t2,$t2,$t0 # alteras te o bit 0 que tinhas ido buscar anteriormente
        sw $t2,LATE($t1)

        addiu $sp,$sp,-4 # cria a stack
        sw $ra, 0($sp)
       # li $a0, 500 # alinea a
       # li $a0, 20 # alinea b
       # li $a0, 50 # alinea b
         li $a0,10 # alinea c
        jal delay #delay(500);   // Atraso de 500ms
        lw $ra, 0 ($sp)
        addiu $sp,$sp,4

        xor $t0, $t0,0x0001 # v ^= 1;   // complementa o bit 0 de v (v = v xor 1)
        j while


delay: 
for:     ble $a0, 0, endfor   #for(; ms > 0; ms--)
         sub $a0, $a0, 1				#	ms--;
         li $v0,RESET_CORE_TIMER
         syscall #resetCoreTimer();
whiled: li  $v0, READ_CORE_TIMER	
        syscall
         bge $v0,20000,end1 #while(readCoreTimer() < K);
         j whiled
end1:    j for
endfor:  jr $ra