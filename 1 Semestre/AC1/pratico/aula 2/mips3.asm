#ex3

	.data
str1: .asciiz "Uma string qualquer"
str2: .asciiz "AC1 – P"
	.text
	.globl main
main: jr $ra

#.data
#str1: .asciiz "So para chatear"
#str2: .asciiz "AC1 – P"
#.eqv print_string,4
#.text
#.globl main
#main: la $a0,str2 # instrução virtual, decomposta pelo assembler em 2 instruções nativas
#ori $v0,$0,print_string # $v0 = 4
#syscall # print_string(str2);

#jr $ra # fim do programa


#.data
#str1: .asciiz "Introduza 2 numeros\n"
#str2: .asciiz "A soma dos dois numeros e':"
#     .eqv    print_string,4
#    .eqv    read_int,5   #introduz um valor aqui
#   .eqv    print_int10,1      # e o outro aqui
     
# .text
# .globl  main
#main: la  $a0,str1
#      ori $v0,$0,print_string
#     syscall                     # print_string(str1)
  	
#	ori $v0,$0,read_int
#      syscall                     # valor lido e' retornado em $v0
#      or $t0,$v0,$0              #$t0=read_int()
     
     
#     ori $v0,$0,read_int
#      syscall                     # valor lido e' retornado em $v0
#      or $t1,$v0,$0              #$t1=read_int()
     
#      add $t2,$t1,$t0
     
     
#     la $a0,str2
#     ori $v0,$0,print_string
#     syscall
       
       
#       add $t2,$t1,$t0
#    	or $a0,$t2,$0
#     ori $v0,$0,print_int10
     
#     syscall
   
#   jr $ra
         
