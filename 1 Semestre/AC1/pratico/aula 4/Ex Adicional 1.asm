# Mapa de registos
# pointer: $t0
# p: $t1 (ponteiro)
# *p: $t2
# char = $t3
	
			
	.data
str1:	.asciiz "\nIntroduza uma string: "
str2:	.asciiz "\nString alterada: "
str:	.space 20
	.eqv SIZE, 20
	.eqv print_string, 4
	.eqv read_string, 8
	.eqv print_int10,1

	.text
	.globl main
	
main: 	la $a0,str # $a0=&str[0] (endereço da posição 0 do array, i.e., endereço inicial do array)
	li $t1,SIZE
	li $v0,read_string
	syscall
	la $t1,str # p = str;

while: 	# while (*p != '\0')
	lb $t2,0($t1) #
	beq $t2,0,endw # {
	
	sub $t4,$t2,'a' # *P-a (a = 0x61)
	addi $t2,$t4,'A' # *P-a+A
	sb $t2, 0($t1)
	addiu $t1,$t1,1
	j while
	
endw: # print_int10(num);
	la $a0,str
	li $v0,print_string
	syscall
	
	li $v0,10
	jr $ra # termina o programa