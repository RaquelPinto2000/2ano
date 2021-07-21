#ex adicionais (2)

# $t0 – res
# $t1 – i
# $t2 - mdor
# $t3 - mdo

      .data
str1: .asciiz "Introduza um numeros: "
str2: .asciiz "\nResultado: "
      .eqv print_string,4
      .eqv read_int,5
      .eqv print_intu10,36
      .text
      .globl main
      
main: move $t0, $0
      la $a0,str1
      ori $v0, $0,print_string
      syscall # print_string(str1);;
      
      ori $v0,$0,read_int
      syscall                     # valor lido e retornado em $t2
      move $t2,$v0 # mdor =read_int();
      andi $t2,$t2,0x0F
      
      la $a0,str1
      ori $v0, $0,print_string  # (instrução virtual -  li $v0,print_string)
      syscall # print_string(str1);
      
      ori $v0,$0,read_int
      syscall                     # valor lido e retornado em $t3
      move $t3,$v0 # mdo =read_int();
      andi $t3,$t3,0x0F
      
      	li $t1,0 
      	addi $t1,$t1,1 #i++   
while:  beqz $t2,endwhile # while(mdor!=0)   ou beq $t2,0,endwhile
	bge $t1,16,endwhile
	
	andi $t4, $t2,0x00000001
	beqz $t4,else  # if((mdor & 0x00000001) !=0)
	add $t0,$t0,$t3 # res=res+mdo
	
else:   sll $t3,$t3,1
        srl $t2,$t2,1
        j while	
	
endwhile:   
	# print_string(str2);
      	    la  $a0,str2
            ori $v0,$0,print_string 
            syscall 
            
            move $a0,$t0
            li $v0,36  # imprime o $t0 (resultado)
            syscall

	    jr $ra # fim do programa
