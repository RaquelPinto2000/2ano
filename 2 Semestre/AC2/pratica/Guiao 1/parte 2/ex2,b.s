#int main(void)
#{
#char c;
#do
#{
#	while( (c = inkey()) == 0 );
#	if( c != '\n' )
#		putChar( c );
#} while( c != '\n' );
#	return 0;
#}	 
	 
	   .equ inkey,1
	   .equ putchar,3
	   .data
	   .text
	   .globl main
	   
main:  nop
do: 
while1: li $v0, inkey
	    syscall
	    or $t0,$v0,$0
		beq $t0,$0, if
if: beq $t0,'\n',while2
	li $v0, putchar
	syscall
	move $a0, $t0
while2: bne $t0,'\n',do
	li $v0,0
	jr $ra
