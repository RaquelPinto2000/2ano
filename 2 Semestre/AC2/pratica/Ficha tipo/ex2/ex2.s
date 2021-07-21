    .equ SFR_BASE_HI, 0xBF88
    .equ TRISE, 0x6100 
    .equ PORTE, 0x6110
    .equ LATE, 0x6120

    .equ READ_CODE_TIME,11
    .equ RESET_CODE_TIME,12
   
    .equ READ_CHAR,2

    .data
    .text
    .globl main

main:   lui $t1,SFR_BASE_HI
        lw $t2,TRISE($t1)
        andi $t2,$t2,0xFFF0
        sw $t2,TRISE($t1)

while:  la $v0, READ_CHAR
        syscall

if0:    bne  $v0,'0',if1  #if(s=0){
        lw   $t2,LATE($t1) # ler o porto de saida
        andi $t2,$t2,0xFFFE # queres modificar o ultimo bit que era de saida
        ori  $t2,$t1,0x0001 # e modificas o ultimo bit de entrada
        sw   $t2,LATE($t1)  # write no porto de saida
        j end

if1:    bne  $v0,'1',if2  #if(s=1){
        lw   $t2,LATE($t1) # ler o porto de saida
        andi $t2,$t2,0xFFFD # queres modificar o penultimo bit que era de saida
        ori  $t2,$t1,0x0002 # e modificas o penultimo bit de entrada
        sw   $t2,LATE($t1)  # write no porto de saida
        j end

if2:    bne  $v0,'2',if3  #if(s=2){
        lw   $t2,LATE($t1) # ler o porto de saida
        andi $t2,$t2,0xFFFB # queres modificar o antepenultimo bit que era de saida
        ori  $t2,$t1,0x0004 # e modificas o antepenultimo bit de entrada
        sw   $t2,LATE($t1)  # write no porto de saida
        j end

if3:    bne  $v0,'3',else  #if(s=2){
        lw   $t2,LATE($t1) # ler o porto de saida
        andi $t2,$t2,0xFFF7 # queres modificar o bit antes do antepenultimo bit que era de saida
        ori  $t2,$t1,0x0008 # e modificas o bit antes do antepenultimo bit de entrada
        sw   $t2,LATE($t1)  # write no porto de saida
        j end

else:   # noutra tecla qualquer deve acender os leds todos durante 1 segundo
        lw   $t2,LATE($t1)
        andi $t2,$t2,0xFFF0
        ori  $t2,$t2,0x000F
        sw   $t2,LATE($t1)
        li   $t3, 1000 # 1s = 1000 ms
# delay
for:    ble $t3,0,end1
        sub $t3,$t3,1
        li  $v0, RESET_CODE_TIME
        syscall

while1: li $v0, READ_CODE_TIME
        syscall
        bge $v0, 20000 ,endWhile
        j while1
endWhile: j for
#quando acabar o 1 s ele mete a 0
end1:    lw   $t2,LATE($t1) # ler o valor
         andi $t2,$t2, 0xFFF0 # mudificar para 0
         ori  $t2,$t2,0x0000
         sw   $t2,LATE($t1) # escrever
end:     j while
        jr $ra