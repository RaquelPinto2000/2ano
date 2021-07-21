    .equ READ_CORE_TIMER, 11
	.equ RESET_CORE_TIMER, 12
	.equ PRINT_INT, 6
	.equ PUT_CHAR,3
	
	.data
	.text
	.globl main
	
main:	addiu $sp, $sp, -8		#Reservar espaço na stack
	sw  $ra, 0($sp)			#Salvaguardar valores da stack
	sw $s0,4($sp)
while:					#while(1)
	lui $t1, 0xBF88			#
	lw  $t2, 0x6050($t1)		#	ler valor binário dos 4 switches
	andi $t2, $t2, 0x0F		#
	addi $s0, $t2, 1
	li  $a0, 1000 #	delay(500) K= 500 = 2 Hz
	div  $a0, $s0			#
	mflo $a0 

	jal delay

	li  $a0, ' '			#
	li  $v0, PUT_CHAR		#	putChar(' '),
	syscall	

	move $a0, $t2			#
	li  $a1, 0x00040002		#
	li  $v0, PRINT_INT		#	imprimir o valor dos switches com um mínimo de 4 digitos em binário
	syscall				#
	j   while			#}
	
	lw  $ra, 0($sp)			#devolver valor ao registo
	lw $s0,4($sp)
	addiu $sp, $sp, 8		#Libertar espaço na stack
	jr  $ra				#




delay: 
for:     ble $a0, $0, endfor   #for(; ms > 0; ms--)
         sub $a0, $a0, 1				#	ms--;
         li $v0,RESET_CORE_TIMER
         syscall #resetCoreTimer();
whiled: li  $v0, READ_CORE_TIMER
		syscall	
         bge $v0,20000,end1 #while(readCoreTimer() < K);
         j whiled
end1:    j for
endfor:  jr $ra