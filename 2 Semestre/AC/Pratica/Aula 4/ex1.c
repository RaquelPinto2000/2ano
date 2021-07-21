

# include <assert.h>
#include <stdio.h>

static int count = 0; // numero de operacoes

int isArithProg(int a[] , int n){
	assert (n>1);
	count =0; // numero de operacoes (adicoes/subtracoes) - neste caso subtracoes
	for(int i = 0;i<n-1;i++){
		count++;
		if(a[i+1]-a[i]!=1){
			return 0;
		}
	}
	return 1; // se nao e progressao aritmetica de razao 1 - (ja nao me lembro se o stor escreveu assim)
}


int main(int argc, char **argv) {
	//int a[] = {1, 3, 4, 5, 5, 6, 7, 7, 8, 9};
	//int a[] = {1, 2, 4, 5, 5, 6, 7, 8, 8, 9};
	//int a[] = {1, 2, 3, 6, 8, 8, 8, 9, 9, 9};
	//int a[] = {1, 2, 3, 4, 6, 7, 7, 8, 8, 9};
	//int a[] = {1, 2, 3, 4, 5, 7, 7, 8, 8, 9};
//	int a[] = {1, 2, 3, 4, 5, 6, 8, 8, 9, 9};
	//int a[] = {1, 2, 3, 4, 5, 6, 7, 9, 9, 9};
	//int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 8, 9};
	//int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
	int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int c = isArithProg(a,10);
	printf("Resultado: %d\tNumero de comparacoes: %d\n",c,count);
	return 0;
}

