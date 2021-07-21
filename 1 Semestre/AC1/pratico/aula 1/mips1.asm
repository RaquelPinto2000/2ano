.data                     
                     # nada a colocar aqui, de momento        
.text             
.globl   main 
main:  
#ex 3
ori $v0,$0,5 # a system call read_int() é identificada com o número 5 (ver tabela de instruções)
syscall # a system call read_int() é chamada

or $t0,$0,$v0 # $t0 = $v0 = valor lido do teclado (valor de x pretendido)

#ex 1 e 2
#ori $t0,$0,3 # $t0 = x (substituir val_x pelo valor de x pretendido)  
#para por menos 8 podes subtrir a sumar -8 ou por sub em vez de add(subtrir por...) 8 
 ori $t2,$0,8    # $t2 = 8       
 add $t1,$t0,$t0  # $t1 = $t0 + $t0 = x + x = 2 * x        
 sub $t1,$t1,$t2  # $t1 = $t1 + $t2 = y = 2 * x - 8   ($t1 tem o valor calculado de y)        
 
   
or $a0,$0,$t1 # copia o registo $t5 para o registo $a0

ori $v0,$0,34 # a system call print_int16() é identificada com o número 34 (ver tabela de instruções)
syscall # a system call print_int16() é chamada

ori $v0,$0,36 # a system call print_intu10() é identificada com o número 36 (ver tabela de instruções)
syscall # a system call print_intu10() é chamada 

ori $v0,$0,1 # a system call print_int10() é identificada com o número 1 (ver tabela de instruções)
syscall # a system call print_int10() é chamada
 jr  $ra         # fim do programa 
 
 
 
