
#include <stdio.h>
# include <assert.h>
//static int count = 0;

static int ncomparacoes =0;

int diferencaArray(int a[],int n){ // array, tamanho do array
	assert (n>1);
	int count =0; // Resultado (numero de elementos diferentes no array)
	ncomparacoes=0; // Numero de comparacoes
	for(int i = 1;i<n;i++){
		ncomparacoes++;
		if(a[i]!= a[i-1]){
			count++;
		}
	}
	return count;
}


int main(int argc, char **argv)
{
	int a[] = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
	//int a[] = {4, 3, 3, 3, 3, 3, 3, 3, 3, 3};
	//int a[] = {4, 5, 3, 3, 3, 3, 3, 3, 3, 3};
	//int a[] = {4, 5, 1, 3, 3, 3, 3, 3, 3, 3};
	//int a[] = {4, 5, 1, 2, 3, 3, 3, 3, 3, 3};
	//int a[] = {4, 5, 1, 2, 6, 3, 3, 3, 3, 3};
	//int a[] = {4, 5, 1, 2, 6, 8, 3, 3, 3, 3};
	//int a[] = {4, 5, 1, 2, 6, 8, 7, 3, 3, 3};
	//int a[] = {4, 5, 1, 2, 6, 8, 7, 9, 3, 3};
	//int a[] = {4, 5, 1, 2, 6, 8, 7, 9, 3, 0};
	
	int count =diferencaArray(a,10);
	printf("Resultado: %d\t Nº de comparacoes: %d\n", count,ncomparacoes);
	return 0;
}

