# Mapa de registos
# res:$v0
#s: $a0
#*s: $t0
#digit : $t1
# Sub-rotina terminal: não devem ser usados registos $sx

	.data
str:    .asciiz "101101"
	.eqv print_int10,1
	.text
	.globl main

main:	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	la $a0, str
	jal atoi   # chama a funcao
	move $a0, $v0			
	li $v0, print_int10		
	syscall
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	li $v0, 0	
	jr $ra
	
atoi:	li $v0,0 #res = 0

while:	lb $t0,0($a0) # while(*s>=..)
	blt $t0,'0',endw
	bgt $t0, '9',endw
	sub $t1,$t0,'0'  # digit = *s-1
	addi $a0,$a0,1   # s++
	mul $v0,$v0,2   # e dois por ser binario
	add $v0,$v0,$t1
	j while
endw: jr $ra