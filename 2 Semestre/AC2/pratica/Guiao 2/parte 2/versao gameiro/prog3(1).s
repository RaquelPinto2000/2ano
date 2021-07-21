	.equ READ_CORE_TIMER, 11
	.equ RESET_CORE_TIMER, 12
	.equ PRINT_INT, 6
	
	.data
	.text
	.globl main
	
main:	addiu $sp, $sp, -4		#Reservar espaço na stack
	sw  $ra, 0($sp)			#Salvaguardar valores da stack
while:					#while(1)
	li  $a0, 500			#	delay(500)
	jal delay			#
					#
	lui $t1, 0xBF88			#
	lw  $t2, 0x6050($t1)		#	ler valor binário dos 4 switches
	move $a0, $t2			#
	li  $a1, 0x00040002		#
	li  $v0, PRINT_INT		#	imprimir o valor dos switches com um mínimo de 4 digitos em binário
	syscall				#
	j   while			#}
	
	lw  $ra, 0($sp)			#devolver valor ao registo
	addiu $sp, $sp, 4		#Libertar espaço na stack
	jr  $ra				#


#Mapa de Registos delay
#$a0:	ms	
delay:						#
for:	ble $a0, 0, endf			#for(ms > 0){
	sub $a0, $a0, 1				#	ms--;
	li  $v0, RESET_CORE_TIMER		#	resetCoreTimer();
	syscall
whiled:	li  $v0, READ_CORE_TIMER		#	while(readCoreTimer()<k)
	syscall
	bge $v0, 20000, endwd			#
	j   whiled				#
endwd:	j   for					#}
endf:	jr  $ra					#fim da função 
