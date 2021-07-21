# Mapa de registos:
# $t0 – value
# $t1 – bit
# $t2 - i
# $t3 - j
# $t4 - flag

      .data
str1: .asciiz "Introduza um numero: "
str2: .asciiz "\nO valor em binario e': "
      .eqv print_string,4
      .eqv read_int,5
      .eqv print_char,11
      .text
      .globl main
      
main: la $a0,str1
      li $v0,print_string # (instrução virtual)
      syscall # print_string(str1);
      ori $v0,$0,read_int
      syscall                     # valor lido e' retornado em $v0
      or $t0,$v0,$0 # value=read_int();
     # print_string(str2);
      la  $a0,str2
      ori $v0,$0,print_string
      syscall  
      li $t2,0 # i = 0
      li $t3,0 #j=0 (serve para por a divisao por 4, vai de 4 em 4
      li $t4,0 #flag =0
for: beq $t2,32,endfor # while(i < 32) {
    
      beq $t3,4,espaco #salta para a funcao e
     andi $t1,$t0,0x80000000 # (instrução virtual)
    
  #   srl $t0,$t0,0x1F # bit = value >> 31;     (ISTO)
    
 
     
 if:    beq $t1,$0,else # if(bit != 0)
   #   beq $t4,1,else        #(isto)
     
     
 #   sll $t0,$t0,0x1 # value = value << 1;     (ISTO)
      
  # print_char('1');  
     li $a0,0X31    # 0x31 ou '1'
     li $v0,print_char
     syscall 
     addi $t4,$t4,1
     
  
   #  li  $a0,0X30 # 0x30 ou '0'    (ISTO)
   #  ori $v0,$0,print_char #          (ISTO)
   #  syscall
     
     j endif
     
else: # else
     # print_char('0');
      li  $a0,0X30 # ox30 ou '0'
     ori $v0,$0,print_char
     syscall
 
endif:  sll $t0,$t0,1 # value = value << 1;
        addi $t2,$t2,1 # i++;
        addi $t3,$t3,1 #j++
        
     #   addi $t4,$t4,1 #flag++        (ISTO)
        
        j for # }
        
espaco :  li  $a0,0x20 #0x20  ou ' '
     ori $v0,$0,print_char
     syscall
     li $t3,0
     j for
        
        
endfor: #
   	 jr $ra # fim do programa
   	 
   	 
   	 
 # Nao fizeste a alinea e nem o f
