
#include <stdio.h> // diretiva de c = pre-processador de c

int main(int argc, char **argv)
{
	char s[20]; 
	printf("Nome da pessoa: ");
	//scanf("%s",s);
	//gets(s); // foi retirado... e duvidoso nao tem limite para ler
	//fgets(s,20,stdin); //stdin ≃ standard input 
	printf("Hello %s !\n", s);
	return 0;
}

