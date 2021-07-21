
#include <stdio.h>
#include <math.h> // para o quadrado - pow e para a raiz - sqrt

int main(int argc, char **argv)
{
	int n;
	float quadrado, raiz;
	printf("Quantas linas da tabela: ");
	scanf("%d",&n);
	printf("Numero | Quadrado | Raiz \n");
	for(int i=1;i<=n;i++){
		quadrado=pow(i,2); // i elevado ao quadrado(2) = java menos com o Math.pow(...,...);
		raiz = sqrt(i);
		printf("%d  |  %.2f   |  %.2f\n",i,quadrado, raiz);
	}
	return 0;
}

// pq que as instrucoes ao compilar e executar tem que ser 
// que erro e este?  ex3.c:(.text+0X6a): referencia indefinida a 'pow' e ex3.c:(.text+0X7d): referencia indefinida a 'sqrt'
// cc ex3.c -o ex3 -lm (compilar)
//./ex3 (exucutar)

// tem haver com os includes e as bibliotecas, pq o programa nao conhece isso
