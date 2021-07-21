#ex adicionais (1)
# $t0 – gray
# $t1 – bin
# $t2 - mask

      .data
str1: .asciiz "Introduza um numero: "
str2: .asciiz "\n0 valorem codigo de gray: "
str3: .asciiz "\nO valor em binario e': "
      .eqv print_string,4
      .eqv read_int,5
      .eqv print_int,1
      .text
      .globl main
      
main: la $a0,str1
      li $v0,print_string # (instrução virtual)
      syscall # print_string(str1);
      
      ori $v0,$0,read_int
      syscall                     # valor lido e' retornado em $v0
      or $t0,$v0,$0 # gray=read_int();    ou  move $t0,$v0
    
      srl $t2,$t0,1 # mask = gray >> 1;
      
      move $t1,$t0
      
while:  beqz $t2,endwhile # while(mask!=0)   ou beq $t2,0,endfor
	xor $t1,$t1,$t2 #bit = bit ^ mask;
	srl $t2,$t2,1 # mask = mask >> 1;
	j while
	
	
endwhile:  # print_string(str2);
      	    la  $a0,str2
            ori $v0,$0,print_string 
            syscall 
            
            move $a0,$t0
            li $v0,print_int   # imprime o $t0 
      	    syscall
            
            # print_string(str3);
      	    la  $a0,str3
            ori $v0,$0,print_string 
            syscall 
            
            move $a0,$t1
            li $v0,print_int   # imprime o $t1 
            syscall
            
            jr $ra # fim do programa
             
	
