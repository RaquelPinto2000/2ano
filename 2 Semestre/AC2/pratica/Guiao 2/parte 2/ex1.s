# void main(void)
#{
#    int counter = 0;
#   while(1)
#   {
       # while(readCoreTimer() < 200000);
       #resetCoreTimer();
       #printInt(++counter, 10);
       #putChar(' '); // space
    #}
#}  
    

# para onde e que vai o whilw???????????????? para o end?

    .equ READ_CORE_TIMER,11
    .equ RESET_CORE_TIMER,12
    .equ PUT_CHAR,3
    .equ PRINT_INT,6
    .data
    .text
    .globl main
main:  li $t0,0
while: li $v0, READ_CORE_TIMER  #   while(1){
       syscall
       #bge $v0, 200000, while	        #	while(readCoreTimer() < 200000);   --100Hz
       #bge $v0, 2000000, while			#	while(readCoreTimer() < 2000000);  --10Hz
       #bge $v0, 4000000, while			#	while(readCoreTimer() < 4000000);  --5Hz
       bge $v0,200000,end # while(readCoreTimer() < 200000); -1Hz
       li $v0,RESET_CORE_TIMER
       syscall #resetCoreTimer();
       li $a0,' '
       li $v0,PUT_CHAR
end:   syscall   #putChar(' '); // space
       addi	$t0, $t0, 1
       move $a0,$t0
       li $a1,10
       li $v0,PRINT_INT
       syscall #printInt(++counter, 10);
       j while
       jr $ra