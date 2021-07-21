#int main(void)
#{
#int value;
#while(1) // loop infinito em c se for while(0) nunca entra la
#{
#	printStr("\nIntroduza um numero (sinal e modulo): ")
#	value = readInt10();
#	printStr("\nValor lido, em base 2: ")
#	printInt(value, 2);
#	printStr("\nValor lido, em base 16: ")
#	printInt(value, 16);
#	printStr("\nValor lido, em base 10 (unsigned): ")
#	printInt(value, 10);
#	printStr("\nValor lido, em base 10 (signed): ")
# 	printInt10(value);
#}
#return 0;

	   .equ printstr,8
	   .equ readInt,5
	   .equ printInt,6
	   .equ printInt10,7
	   .data
srt:   .asciiz "\nIntroduza um numero (sinal e modulo): "
srt1:   .asciiz "\nValor lido, em base 2: "
srt2:   .asciiz "\nValor lido, em base 16: "
srt3:   .asciiz "\nValor lido, em base 10 (unsigned): "
srt4:   .asciiz "\nValor lido, em base 10 (signed): "
	   .text
	   .globl main
main: nop #pode dar erro se nao tiver nenhuma instrucao a frente do main
while:
		la $a0, srt       # String "Introduza um numero (sinal e modulo)")
		li $v0 , printstr
		syscall
		
		la $v0 , readInt	 #value = readInt10();
		syscall
		move $t0,$v0
		
		la $a0, srt1 # String printStr("\nValor lido, em base 2")
		li $v0 , printstr
		syscall
		
		move $a0, $t0 #	printInt(value, 2);
		li $a1,2
		li $v0 ,printInt
		syscall
		
		la $a0, srt2 # String "Valor lido, em base 16")
		li $v0 , printstr
		syscall
		
		move $a0, $t0 #	printInt(value, 16);
		li $a1,16
		li $v0 ,printInt
		syscall

		la $a0, srt3 # String "Valor lido, em base 10 (unsigned)")
		li $v0 , printstr
		syscall
		
		move $a0, $t0 #	printInt(value, 10);
		li $a1,10
		li $v0 ,printInt
		syscall
		
		la $a0, srt4 # String "Valor lido, em base 10 (signed)")
		li $v0 , printstr
		syscall
		
		move $a0, $t0 #	printInt(value);
		li $v0 ,printInt10
		syscall
		
		j while # loop infinito
endwhile: jr $ra # nao chega aqui e so uma questao de principio ter isto
