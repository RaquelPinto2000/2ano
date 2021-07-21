    .equ SFR_BASE_HI, 0xBF88  # 16 MSbits of SFR area
    .equ TRISE, 0x6100 #TRISE address is 0xBF886100
    .equ PORTE, 0x6110 #PORTE address is 0xBF886110
    .equ LATE, 0x6120  #LATE address is 0xBF886120

    .equ PORTB, 0x6050
    .equ TRISB, 0x6040
    .equ LATB, 0x6060
    .data
    .text
    .globl main

# $t1 = endereco base
#configuracao do porto para entrada ou saida
main: lui $t1, SFR_BASE_HI 
      lw $t2,TRISE($t1) # READ (Mem_addr = 0xBF880000 + 0x6100)
      andi $t2,$t2,0xFFF0 # MODIFY os bits todos para 0 -> mete a 0 os bits que queremos como queremos todos tens FFF0
      sw $t2,TRISE($t1) # WRITE (Write TRISE register)

      lw $t2,TRISB($t1) 
      andi $t2,$t2,0x000F 
      sw $t2,TRISB($t1) 

while: lw $t2,PORTB($t1) # le o valor do PORTB valor de entrada
       andi $t2, $t2, 0x000F  # extrai todos os bits e enteresanos todos
       xor $t2,$t2, 0x0009 #0000000000001001 
       lw $t3, LATE($t1) #READ (Read LATE register)
       andi $t3,$t3,0xFFF0 # Guardar todos os bits
       or $t4,$t2,$t3 # um ou o outro
       sw $t4,LATE($t1) # WRITE (Write LATE register)
       j while
      