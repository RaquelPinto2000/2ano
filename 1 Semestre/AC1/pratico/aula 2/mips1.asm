#ex1

.data
.text
.globl main
main:# ori $t0,$0,0x5C1B # substituir val_1 e val_2 pelos
#	ori $t1,$0,0xA3E4 # valores de entrada desejados
#	and $t2,$t0,$t1 # $t2 = $t0 & $t1 (and bit a bit)
#	or $t3,$t0,$t1 # $t3 = $t0 | $t1 (or bit a bit)
#	nor $t4,$t1,$0 #$t4 = not $t1 
	# xori $t4,$t2,-1 # $t4 = not $t2
	#xor $t5, $t0,$t1 
	
	
	ori $t0,$0,0xE543 #
	nor $t1,$t0,$0  # ou not $t1,$t0

jr $ra # fim do programa
