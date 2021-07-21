	.data
	.eqv print_str, 4
	.eqv print_int, 1
str1:	.asciiz "Arquitetura de computarores I"
	.text
	.globl main 

main:	#alogar espaco da stack para o $ra
	addiu $sp ,$sp, -4
	# guardamos o $ra na stack
	sw $ra, 0($sp)
	#guardamos a string em a0 e chamamos a funcao
	la $a0,str1
	jal strlen # chama a funcao strlen()
	
	#printamos o $v0 (os dados que vieram da funcao
	move $a0,$v0
	li $v0, print_int # == ori $v0, $0, print_int	
	syscall
	
	#reposicao de $ra
	lw $ra,0($sp)
	#pomos o $sp como estava (liberta espaco da stack)
	addiu $sp,$sp,4
	# return
	jr $ra 
	

# O argumento da função é passado em $a0
# O resultado é devolvido em $v0
# Sub-rotina terminal: não devem ser usados registos $sx
# funcao strlen() em c serve para determina e devolve a dimensao de uma string 

strlen:	li $t1,0 # len = 0;
while:	lb $t0, 0($a0)# while(*s++ != '\0')
	addiu $a0,$a0,1 #
	beq $t0,'\0',endw # {
	addi $t1,$t1,1 # len++;
	j while # }
endw:	move $v0,$t1 # return len;
	jr $ra #