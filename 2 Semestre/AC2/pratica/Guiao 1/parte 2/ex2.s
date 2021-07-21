#nao da bem	
#int main(void)
#{
#char c;
#do
#{
#c = getChar();
#	if( c != '\n' )
#		putChar( c );
#} while( c != '\n' );
#	return 0;
#}  
	  
	   .equ getchar,2
	   .equ putchar,3
	   .data
	   .text
	   .globl main
main: nop
do:    li $v0, getchar
	   syscall
	   or $t0,$v0,$0
if:    beq $t0,'\n', while
	   or $a0, $t0, $0  #		putChar( c );
	   li $v0, putchar
	   syscall
while: bne $t0, '\n',do
	   li $v0,0
	   jr $ra
