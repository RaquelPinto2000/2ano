# a funcao de strrev() reverte o conteudo de uma string. O ponteiro com o mesmo valor que foi passado como argumento.

# Mapa de registos:
# str: $a0 -> $s0 (argumento é passado em $a0)
# p1: $s1 (registo callee-saved)
# p2: $s2 (registo callee-saved)
#

	.data
str1:	.asciiz "ITED - orievA ed edadisrevinU"
	.eqv print_string, 4
	.eqv print_int, 1
	.text
	.globl main
	
main:	#alogar espaco da stack para o $ra
	addiu $sp ,$sp, -4
	# guardamos o $ra na stack
	sw $ra, 0($sp)
	#guardamos a string em a0 e chamamos a funcao
	la $a0,str1
	jal strrev # chama a funcao streev
	
	#printamos o $v0 (os dados que vieram da funcao
	move $a0,$v0
	li $v0, print_string # == ori $v0, $0, print_int	
	syscall
	
	#reposicao de $ra
	lw $ra,0($sp)
	#pomos o $sp como estava
	addiu $sp,$sp,4
	# return 0
	jr $ra 

strrev: addiu $sp,$sp,-16 # reserva espaço na stack
	sw $ra,0($sp) # guarda endereço de retorno
	sw $s0,4($sp) # guarda valor dos registos
	sw $s1,8($sp) # $s0, $s1 e $s2
	sw $s2,12($sp) #
	move $s0,$a0 # registo "callee-saved"
	move $s1,$a0 # p1 = str
	move $s2,$a0 # p2 = str
	
while1:	lb $t1, 0($s2) # $tt1 = *p2
	#temos que ir buscar o valor primeiro (*p2) e so depois comparar as coisas
 	beq $t1,'\0', endw1# while( *p2 != '\0' ) {  
	addiu $s2,$s2,1 # p2++;
	j while1 # }
	
endw1: addiu $s2,$s2,-1 # p2--;

while2:	bgeu $s1, $s2,endw2  # while(p1 < p2) {    comparacao de enderesos de memoria(ponteiros) -- comparacao sem sinal   (s)
	move $a0, $s1 #
	move $a1, $s2 #
	jal exchange # exchange(p1,p2)
	addiu $s1,$s1,1
	addiu $s2,$s2,-1
	j while2 # }
	

endw2:	move $v0,$s0 # return str ($s0)
	lw $ra,0($sp) # repõe endereço de retorno
	lw $s0,4($sp) # repõe o valor dos registos
	lw $s1,8($sp) # $s0, $s1 e $s2
	lw $s2,12($sp) #
	addiu $sp,$sp,16 # liberta espaço da stack
	jr $ra # termina a sub-rotina

exchange: lb $t2,0($a0)    # nao percebi esta funcao 
	  lb $t1,0($a1)
	
          sb $t1,0($a0)
	  sb $t2,0($a1)
	
	  jr $ra
