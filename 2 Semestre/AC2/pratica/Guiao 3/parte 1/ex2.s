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
      andi $t2,$t2,0xFFFE # MODIFICA o bit 0   E = 1110
      sw $t2,TRISE($t1) # WRITE (Write TRISE register)

      lw $t2,TRISB($t1) 
      andi $t2,$t2,0x0001 
      sw $t2,TRISB($t1) 

while: lw $t2,PORTB($t1) # le o valor do PORTB valor de entrada
       not $t2,$t2 # nega o valor do porto de entrada
       andi $t2, $t2, 0x0001  # extrai o bit 0 e o resto nao interesa
       lw $t3, LATE($t1) #READ (Read LATE register)
       andi $t3,$t3,0xFFFE #MODIFY (bit0 = 0) e todo o resto interesa (tens de manter por isso nao se pode negar) o E e nosso podes alterar mas o resto nao
       or $t4,$t2,$t3 # um ou o outro
       sw $t4,LATE($t1) # WRITE (Write LATE register)
       j while
      