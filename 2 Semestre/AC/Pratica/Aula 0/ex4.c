
#include <stdio.h>
#include <math.h> // para o quadrado - pow e para a raiz - sqrt
#define PI 3.14159265
int main(int argc, char **argv)
{
	int am, aM, inter;
	float seno, coss;
	printf("Angulo menor: ");
	scanf("%d",&am);
	printf("Angulo maior: ");
	scanf("%d",&aM);
	printf("Intervalo: ");
	scanf("%d",&inter);
	printf("ang | sin(ang) | cos(ang) \n");
	printf("----------------------------\n");
	double val = PI/180; // graus - converte para grau
	FILE *file;
	file = fopen("ex4_file.txt","w"); //open file 
	
	if(file == NULL){
		//file not creat hence exit
		printf("Ficheiro nao existe\n");
	}
	
	fprintf(file,"ang | sin(ang) | cos(ang) \n");
	fprintf(file,"----------------------------\n");
	
	for(int i=am;i<=aM;i+=inter){
		seno=sin(i*val); // i elevado ao quadrado(2) = java menos com o Math.pow(...,...);
		coss = cos(i*val);
		printf("%d  |  %.11f   |  %.11f\n",i,seno, coss);
		fprintf(file,"%d  |  %.11f   |  %.11f\n",i,seno, coss);
	}
	
	
	fclose(file);
	
	
	return 0;
}


// que erro e este compilando normal?  ex4.c:(.text+0Xbf): referencia indefinida a 'sin' e ex4.c:(.text+0Xd2): referencia indefinida a 'cos'
// pq que as instrucoes ao compilar e executar tem que ser 
// cc ex4.c -o ex4 -lm (compilar)   // -o ex4 - o output passa a ser o ex4 e nao o ./a.out
//./ex4 (exucutar)
