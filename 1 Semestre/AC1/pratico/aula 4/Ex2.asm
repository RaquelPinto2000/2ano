# Mapa de registos
# num: $t0
# p: $t1
# *p: $t2
	.data
	.eqv SIZE,20
	.eqv read_string,8
	.eqv print_int10,1
str: .space SIZE
	.text
	.globl main
main: 	la $a0,str # $a0=&str[0] (endere�o da posi��o 0 do array, i.e., endere�o inicial do array)
	li $t1,SIZE
	li $v0,read_string
	syscall
	
	la $t1,str # p = str;
while: 	# while(*p != '\0')
	lb $t2,0($t1) #
	beq $t2,0,endw # {
	blt $t2,'0',endif # if(str[i] >='0' &&
	bgt $t2,'9',endif # str[i] <= '9')
	addi $t0,$t0,1 # num++;
endif:
	addiu $t1,$t1,1 # p++;
	j while # }
endw:  # print_int10(num);
	move $a0,$t0
	li $v0,print_int10
	syscall
	
	li $v0,10
	jr $ra # termina o programa
