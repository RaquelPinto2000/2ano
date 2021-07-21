#Mapa de registos
#n: $a0-> $s0
#b: $a1->$s1
#s: $a2->$s2
#p: $s3
#digit: $t0
#Sub-rotina intermédia

	.data
	
	.text
	.globl main
main: 


	jr $ra
#----funcao itoa-----
itoa:	addiu $sp, $sp, -16 #reserva espacos da stack 
	sw $s0,0($sp) # guarda registos $sx e $ra 
	sw $s1,4($sp)
	sw $s2,8($sp)
	sw $s3,16($sp)
	move $s0,$a0  #copia n,b e s para registos "called-saved"
	move $s1,$a1
	move $s2,$a2 #called saved
	sb $s3,0($s2) #*p=s
	

do:	divu $s0,$a1   # digit = n%b       ou rem $s0,$s0,$a1
	mflo $s0
	mfhi $a0
	jal toascii
	sb $v0,0($a2)
	addiu $a2,$a2,1
	bltz $s0,do
	li $s2,'\0'
	jal strrev 
	
	move $v0,$s2
	lw $s0,0($sp)
	lw $s1,4($sp)
	lw $s2,8($sp)
	lw $s2,12($sp)
	addiu $sp,$sp,16
	jr $ra
	
	
#--- funcao toascii---
toascii: addi $a0,$a0,'0'

if:	ble $a0,'9',endif
	addi $a0,$a0,7

endif move $v0,$a0  #return v
	jr $ra
	
	
	
#----funcao strrev----

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
