#void delay(int ms)
#{
    #for(; ms > 0; ms--)
#   {
    #   resetCoreTimer();
        #while(readCoreTimer() < K);
    #}
#}

    .equ READ_CORE_TIMER,11
    .equ RESET_CORE_TIMER,12
    .equ PUT_CHAR,3
    .equ PRINT_INT,6
    .data
    .text
    .globl main
    
main:	addiu $sp, $sp, -8			#
	sw  $ra, 0($sp)				#
	sw  $s0, 4($sp)				#

while:						#while(1){
#	li  $a0, 100				#	frequência 10Hz
#	li  $a0, 200				#	frequência 5Hz
	li  $a0, 1000				#	frequência 1Hz 
	jal delay				#
	li  $a0, ' '				#
	li  $v0, PUT_CHAR			#	putChar(' '),
	syscall					#
	addi $s0, $s0, 1			#	counter+;
	move $a0, $s0				#
	li  $a1, 10				#
	li  $v0, PRINT_INT			#	printInt(counter++, 10);
	syscall					#
	j   while				#}
endw:	
	lw  $ra, 0($sp)				#
	lw  $s0, 4($sp)				#
	addiu $sp, $sp, 4			#
	jr  $ra					#


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
     
