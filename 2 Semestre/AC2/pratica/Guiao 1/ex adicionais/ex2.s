
#define STR_MAX_SIZE 20
#char *strcat(char *, char *);
#char *strcpy(char *, char *);
#int strlen(char *);
#int main(void)
#{
#	static char str1[STR_MAX_SIZE + 1];
#	static char str2[STR_MAX_SIZE + 1];
#	static char str3[2 * STR_MAX_SIZE + 1];
#	printStr("Introduza 2 strings: ");
#	readStr( str1, STR_MAX_SIZE );
#	readStr( str2, STR_MAX_SIZE );
#	printStr("Resultados:\n");
#	prinInt( strlen(str1), 10 );
#	prinInt( strlen(str2), 10 );
#	strcpy(str3, str1);
#	printStr( strcat(str3, str2) );
#	printInt10( strcmp(str1, str2) );
#	return 0;
#}


#Cálculo da dimensão de uma string.
#int strlen(char *s)
#{
#	int len;
#	for( len = 0; *s != '\0'; len++, s++ );
#		return len;
#}

#Cópia de uma string.
#char *strcpy(char *dst, char *src)
#{
#	char *p = dst;
#	for( ; ( *dst = *src ) != '\0'; dst++, src++ );
#		return p;
#}

#Concatenação de 2 strings.
#char *strcat(char *dst, char *src)
#{
#	char *p = dst;
#	for( ; *dst != '\0'; dst++ );
#		strcpy( dst, src );
#		return p;
#}

#Comparação alfabética de 2 strings.
#// Returned value is:
#	< 0 string "s1" is "less than" string "s2"
#	= 0 string "s1" is equal to string "s2"
#	> 0 string "s1" is "greater than" string "s2"

#int strcmp(char *s1, char *s2)
#{
#	for( ; (*s1 == *s2) && (*s1 != '\0'); s1++, s2++ );
#		return( *s1 - *s2 );
#}




      .equ printStr, 8
	.equ readStr,9
      .equ printInt10,7
      .equ prinInt,6
      .data
str0: .space 84 #21*4    #	static char str1[STR_MAX_SIZE + 1];
str1: .space 84  #	static char str2[STR_MAX_SIZE + 1];
str2: .space 164 #41*4 #	static char str3[2 * STR_MAX_SIZE + 1];
sentence1: .asciiz "Introduza 2 strings: "
sentence2: .asciiz "Resultados:\n"
      .text
      .globl main

main:   la $s0, str0 #str1
        la $s1, str1 #str2
        la $s2, str2 #str3

        la $a0, sentence1 #printStr("Introduza 2 strings: ");
        li $v0, printStr 
        syscall
        
        move $a0,$s0 #	readStr( str1, STR_MAX_SIZE );
        li $a1,20
        li $v0, readStr
        syscall

        move $a0,$s1 #	readStr( str2, STR_MAX_SIZE );
        li $a1,20
        li $v0, readStr
        syscall

        la $a0, sentence2 #printStr("Resultados:\n");
        li $v0, printStr 
        syscall

        #	prinInt( strlen(str1), 10 );
        addi $sp,$sp,-4 #stack
        sw $ra, 0($sp) 
        move $a0, $s0
        jal strlen
        lw	$ra, 0($sp)	
        addi $sp, $sp, 4 #liberta o espaco da stack
        move $a0,$v0
        li $a1, 10
        li $v0, prinInt
        syscall

        #prinInt( strlen(str2), 10 );
        addi $sp,$sp,-4 #stack
        sw $ra, 0($sp) 
        move $a0, $s1
        jal strlen
        lw	$ra, 0($sp)	
        addi $sp, $sp, 4 #liberta o espaco da stack
        move $a0,$v0
        li $a1, 10
        li $v0, prinInt
        syscall

        #	strcpy(str3, str1);
        la $a0, str2
        la $a1, str0
        addi $sp, $sp, -4
        sw $ra, 0($sp)
        jal strcpy
        lw $ra, 0($sp)
        addi $sp, $sp, 4

        #	printStr( strcat(str3, str2) );
        la $a0, str2
        la $a1, str1
        addi $sp, $sp, -4
        sw $ra, 0($sp)
        jal strcat
        lw $ra, 0($sp)
        addi $sp, $sp, 4
        move $a0, $v0
        li $v0, printStr
        syscall
        
        #	printInt10( strcmp(str1, str2) );
        la $a0, str0
        la $a1, str1
        addi $sp, $sp, -4
        sw $ra, 0($sp)
        jal strcmp
        lw $ra, 0($sp)
        addi $sp, $sp, 4
        move $a0, $v0
        li $v0, printInt10
        syscall 
        
        #return 0
        li $v0,0
        jr	$ra 
        
strlen: #$t0 = len
        #$t1 = *s
        li $t0,0;
for:    lw $t1, 0($a0)		# 

        beq $t0, '/0' , end	#for( len = 0; *s != '\0'; len++, s++ );
        addi $t0,$t0,1
        addi $t1,$t1,4
        j for
end:    move $v0, $t0
        jr $ra		# jump to $ra


strcpy: move $t0, $a0		# *p = *dst
        move $a0, $a1 #( *dst = *src )
for1:   lw $t1, 0($a0) # conteudo de dst
        beq +$a0, '/0', end1  #for( ; ( *dst = *src ) != '\0'; dst++, src++ );
        lw $t2, 0($a1)
        sw $t2, 0($a0)
        addi $a0,$a0,4
        addi $a1,$a1,4
        j for1
end1:   move $v0,$t0


strcat: move $t0, $a0		# *p = *dst
        lw $t1, 0($a0) # conteudo de dst
for2:   beq $t1,'/0', end2 #for( ; *dst != '\0'; dst++ );
        addi $a0, $a0, 4
        j for2
end2:   addi $sp,$sp,-4 #stack
        sw $ra, 0($sp) 
        jal strcpy
        lw	$ra, 0($sp)	
        addi $sp, $sp, 4 #liberta o espaco da stack
        move $v0, $t0		#$v0,=$t01
        jr $ra					# jump t $ra
         

strcmp: lw $t0,0($a0) #s1=$t0
        lw $t1,0($a1) #s2 =$t1
for3: bne $t0,$t1,end3 # for( ; (*s1 == *s2) && (*s1 != '\0'); s1++, s2++ );
      beq $t0,'/0',end3
      addi $a0, $a0, 4
      addi $a1, $a1, 4
      j for3
end3: sub $v0 ,$a0,$a1 #return( *s1 - *s2 );
      jr $ra   
      
