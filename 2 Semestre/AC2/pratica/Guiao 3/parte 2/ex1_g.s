    .equ READ_CORE_TIMER,11
    .equ RESET_CORE_TIMER,12
  
    .equ SFR_BASE_HI, 0xBF88  # 16 MSbits of SFR area
    .equ TRISE, 0x6100 #TRISE address is 0xBF886100
    .equ PORTE, 0x6110 #PORTE address is 0xBF886110
    .equ LATE, 0x6120  #LATE address is 0xBF886120

    .equ PORTB, 0x6050
    .equ TRISB, 0x6040
    .equ LATB, 0x6060
    .data
    .text
    .globl main

# $t1 = endereco base
#configuracao do porto para entrada ou saida
main: li $t0,0 # contador = 0
      lui $t1, SFR_BASE_HI # endereco inicial
      # configura os portos RE0,RE1,RE2,RE3 como saidas
      lw $t2,TRISE($t1) # READ (Mem_addr = 0xBF880000 + 0x6100)
      andi $t2,$t2,0xFFF0 # MODIFY os bits todos como output
      sw $t2,TRISE($t1) # WRITE (Write TRISE register)
      
      lw $t2, TRISB($t1)
      andi $t2,$t2,0x000F # modificar os bits todos como input
      sw $t2,TRISB($t1)


while:  lw $t3, LATE($t1)
        andi $t3,$t3, 0xFFF0 # buscar o bits todos 
        or $t3,$t3,$t0 # alteras os bits que incrementaste 
        sw $t3,LATE($t1)

        addiu $sp,$sp,-4 # cria a stack
        sw $ra, 0($sp)
        li $a0, 667 # 
        jal delay #delay(667);   // Atraso de 667ms - pisca a 1.5Hz
        lw $ra, 0 ($sp)
        addiu $sp,$sp,4 # liberta espaco da stack

        lw $t4,PORTB($t1)
        andi $t4,$t4,0x0002 # le o bit RB1 = 1 -> 0x0002

if:    beq $t4, 0x0002,esq # se o valor lido no porto RB1 for igual a 1 entao ele vai para a esquerda
#direita
dir:    andi $t5, $t0, 0x0001		#	extrair o bit mais significativo de cnt
	    srl  $t0, $t0, 1		#	cnt = cnt>>1;
	    andi $t0, $t0, 0xFFF7
if1:bne $t5, 0x0001, if0		#	if(bit3 = 1)
	ori $t0, $t0, 0x0000		#		cnt[bit0]=0;
	j   while				#	else
if0:	ori $t0, $t0, 0x0008		#		cnt[cntbit0]=1
        j while

#esquerda
esq:    andi $t5, $t0, 0x0008		#	extrair o bit mais significativo de cnt
	    sll  $t0, $t0, 1		#	cnt = cnt<<1;
	    andi $t0, $t0, 0xFFFE
        
if11:bne $t5, 0x0008, if00		#	if(bit3 = 1)
	ori $t0, $t0, 0x0000		#		cnt[bit0]=0;
	j   while				#	else
if00:	ori $t0, $t0, 0x0001		#		cnt[cntbit0]=1
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