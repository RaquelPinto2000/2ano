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
       andi $t2,$t2,0xFFF0  #MODIFY (bit0=bit1=bit2=bit3=0 Output)
       sw   $t2,TRISE($t1)    #WRITE (write in TRISE register)

       lw   $t2,TRISB($t1)    #READ (Mem addr = 0xBF880000 + 0x6040)
       andi $t2,$t2,0x000F  #MODIFY (bit0=bit1=bit2=bit3=1 Output)
       sw   $t2,TRISB($t1)    #WRITE (write in TRISB register)

while:  lw   $t3,PORTB($t1)   # ler os valores do porto de entrada
        andi $t3,$t3,0x000F # tu queres os 4 bits menos significativos

        lw   $t4,LATE($t1)    # ler os valores do porto de saida
        andi $t4,$t4,0xFFF0 # querem modificar os 4 bits menos significativos da saida
        or   $t4,$t4,$t3      # e modificaste os valores dos 4 bits menos significativos
        sw   $t4,LATE($t1)   # escrever os valores modificados no porto de saida
        
        j while
        jr $ra