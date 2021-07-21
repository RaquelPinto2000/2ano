# Mapa de registos:
# $t0 � soma
# $t1 � value
# $t2 - i
	.data
str1:   .asciiz "Introduza um numero: "
str2:   .asciiz "Valor ignorado\n"
str3:   .asciiz "A soma dos positivos e': "
	.eqv print_string,4
	.eqv print_int,1
	.eqv read_int,5
	.text
	.globl main
main: li $t0,0 # soma = 0;
      li $t2,0 # i = 0;
for: beq $t2,5,endfor # while(i < 5) {
     la  $a0,str1
     ori $v0,$0,print_string
     syscall  # print_string("Introduza um numero);
     
     ori $v0,$0,read_int
     syscall                     # valor lido e' retornado em $v0
     or $t1,$v0,$0              #$t1(value)=read_int()
  
     ble $t1,$0,else # if(value > 0)
     add $t0,$t0,$t1 # soma += value;
     j endif #
else:                # else
     la  $a0,str2
     ori $v0,$0,print_string
     syscall 
     # print_string("Valor ignorado);
endif: addi $t2,$t2,1 # i++;
       j for # }
endfor:
      la  $a0,str3
      ori $v0,$0,print_string
      syscall      
      # print_string("A soma dos positivos e': ");
      move $a0,$t0   # move o $t0 para o $a0
      li $v0,print_int   # imprime o $v0 
      syscall
     
      # print_int10(soma);
      jr $ra
