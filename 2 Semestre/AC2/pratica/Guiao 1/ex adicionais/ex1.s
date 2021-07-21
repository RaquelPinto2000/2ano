#void wait(int);
#int main(void)
#{
#	int s = 0;
#	int cnt = 0;
#	char c;
#	do
#	{
#		putChar('\r');
#		// Carriage return character
#		printInt( cnt, 10 | 3 << 16 ); // 0x0003000A: decimal w/ 3 digits
#		putChar('\t');
#		// Tab character
#		printInt( cnt, 2 | 8 << 16 ); // 0x00080002: binary w/ 8 bits
#		wait(5);
#		c = inkey();
#		if( c == '+' )
#		s = 0;
#		if( c == '-' )
#		s = 1;
#		if( s == 0 )
#		cnt = (cnt + 1) & 0xFF;
#		else
#		cnt = (cnt - 1) & 0xFF;
#	} while( c != 'q' );
#	return 0;
#	}
#	void wait(int ts)
#	{
#	int i;
#	for( i=0; i < 515000 * ts; i++ );
#	}

#Mapa de isntrucoes:
# $t0 = s
# $t1 = cnt
# $t2 = c
# $t4 = i
# $s0 = ts
	   .equ getchar,2
	   .equ putchar,3
	   .equ printInt,6
	   .equ inkey,1
	   .data
	   .text
	   .globl main
main:  li $t0,0 # $t0 = s
	   li $t1,0 # $t1 = cnt
	   li $s0, 5
	   
	   #stack
	   addiu $sp,$sp,-8
	   sw $ra,0($sp)
	   sw $s0,4($sp)
	   
do:    li $a0, '\r' 	#putChar( '\r' );
	   li $v0, putchar
	   syscall
	   
	   #printInt( cnt, 10 | 3 << 16 ); // 0x0003000A: decimal w/ 3 digits
	   li $t3, 0x0003000A
	   sll $t3,$t3,16
	   ori $t3,$t3,10
	   move $a0, $t1 
	   move $a1, $t3
	   li $v0 ,printInt
	   syscall
	   
	   li $a0, '\t' 	#putChar( '\t' );
	   li $v0, putchar
	   syscall
	   
	   #printInt( cnt, 2 | 8 << 16 ); // 0x00080002: binary w/ 8 bits
	   li $t3, 0x00080002
	   sll $t3,$t3,16
	   ori $t3,$t3,2
	   move $a0, $t1 
	   move $a1, $t3
	   li $v0 ,printInt
	   syscall
	   
	   #wait(5)
	   move $a0, $s0
	   jal void
	   	   
	   li $v0, inkey #c = inkey();
	   syscall
	   move $t2,$v0
if:    bne $t2,'+',if1 # if( c == '+' )
	   li $t0,0 #s = 0;
if1:   bne $t2,'-',if2 #if( c == '-' )
	   li $t0,1 #s = 1;
if2:   bne $t0, $0, else #if( s == 0 )
	   addi $t1,$t1,1 #cnt = (cnt + 1) & 0xFF;
	   and $t1,$t1,0xFF
else:  addi $t1,$t1,-1 #cnt = (cnt - 1) & 0xFF;
	   and $t1,$t1,0xFF
	   
	   
while: bne $t2, 'q', do
	   
	   #repor os valores e libertar a stack 
	   lw $ra,0($sp)
	   lw $s0,4($sp)
	   addiu $sp,$sp,8
	   
	   #return 0
end:   jr $ra

#	void wait(int ts)
#	{
#	int i;
#	for( i=0; i < 515000 * ts; i++ );
#	}

void: li $t4,0
	  li $t5, 515000
	  mult $v0, $t5 
	  mfhi $t6
	  mflo $t7
	  and $t5, $t6,$t7
for : bge $t4, $t5 ,end1
	  addi $t4,$t4,1

end1 : jr $ra
