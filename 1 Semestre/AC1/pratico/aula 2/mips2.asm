# ex 2

.data
.text
.globl main
main: li $t0,0x12345678 # instrução virtual (decomposta
# em duas instruções nativas)
	sll $t2,$t0,4 #
	srl $t3,$t0,4#
	sra $t4,$t0,4#
	
	#por de binario para gray
#li $t0,15
#	srl $t5,$t0,1 # bin >> 1
#	xor $t6,$t5,$t0 #gray = bin ^ (bin >> 1);
	
	#por de gray para binario
#	or $t1,$t6,$0 # $t0=$t6 (num=gray)  
	# ou ori $t0,$t6,0
#	srl $t3,$t1,4 # bin >> 4
#	xor $t1,$t1,$t3 #num = num ^ (num>> 4);
#	xor $t1,$t1,$t3 #num = num ^ (num>> 2);
#	srl $t3,$t1,1 # bin >> 1
#	xor $t1,$t1,$t3 #num = bin ^ (bin >> 1);
#	or $t2,$t1,$0 # $t0=$t6  (bin = num)
	
jr $ra # fim do programa
