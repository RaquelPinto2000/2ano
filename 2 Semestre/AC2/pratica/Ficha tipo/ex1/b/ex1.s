    .equ SFR_BASE_HI, 0xBF88    #16 Msbits of SFR area
    .equ TRISE, 0x6100          #TRISE address is 0xBF886100
    .equ PORTE, 0x6110          #PORTE address is 0xBF886110
    .equ LATE, 0X6120           #LATE  address is 0xBF886120
	
  	.equ TRISB, 0X6040		#TRISB address is 0xBF886040
  	.equ PORTB, 0x6050		#PORTB address is 0xBF886050
  	.equ LATB,  0x6060		#LATB  address is 0xBF886060

    .data
    .text
    .globl main

main:  lui  $t1, SFR_BASE_HI
       lw   $t2, TRISE($t1)   #READ (Mem addr = 0xBF880000 + 0x6100)
       andi $t2,$t2,0xFFF0    #MODIFY (bit0=bit1=bit2=bit3=0 Output)
       sw   $t2,TRISE($t1)    #WRITE (write in TRISE register)

       lw   $t2,TRISB($t1)    #READ (Mem addr = 0xBF880000 + 0x6040)
       andi $t2,$t2,0x000F    #MODIFY (bit0=bit1=bit2=bit3=1 Output)
       sw   $t2,TRISB($t1)    #WRITE (write in TRISB register)

while:  lw   $t0, PORTB($t1) # ler os valores do porto do porto de entrada
       
        andi $t2,$t0,0x0001 # ler o valor do bit menos significativo (0001)
        sll  $t2,$t2,3     # o bit 1 fica a ser o bit 3

        andi $t3,$t0,0x0002 # ler o valor do 2 bit menos significativo (0010)
        sll $t3,$t3,1  # o bit 2 fica no bit 3
        or  $t2,$t2,$t3 # modificas o bit para por no porto de saida

        andi $t3,$t0,0x0004 # ler o valor do 3 bit (0100)
        srl  $t3,$t3,1  # o bit 3 passa a ser o 2
        or  $t2,$t2,$t3 # modificas o bit para por no porto de saida

        andi $t3,$t0,0x0008 # ler o 4 bit  (1000)
        srl $t3,$t3,3       # o bit 4 passa a ser o 1
        or  $t2,$t2,$t3     # modificas o bit para por no porto de saida

        lw   $t4,LATE($t1)    # ler os valores do porto de saida
        # modifica em cima
        sw   $t2,LATE($t1)   # escrever os valores modificados no porto de saida
        
        j while
        jr $ra