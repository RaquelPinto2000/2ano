#include <stdio.h>
# include <assert.h>

static int ncomparacoes = 0;
int countelemtmaiores(int a[], int n){ // array e tamanho do array
	assert (n>1);
	int max = 0;
	int posicao = -1; // posicao do elemento com mais elementos anteriores inferiores a ele
	// comecou em -1 porque assim quando nenhum elemento é maior do que qualquer um dos seus predecessores, devolve -1
	ncomparacoes=0; // Numero de comparacoes
	for(int i = 1; i<n;i++){
		int count= 0; //numero maximo de numeros inferiores a um determinado elemento do array
		for(int j = 0;j<i;j++){
			ncomparacoes++;
			if(a[j]<a[i]){
				count++; // conta o numeros menores que determinado elemento do array
			}
		}
		if(count>max){
			max = count; // atualiza o valor maximo de numeros menores
			posicao =i;
		}
	}
	//	printf("Indice do numero: %d \t %d\n", posicao, max);
	return posicao;
}
// so se conta as comparacoes que tenham o indice do array

int main(int argc, char **argv)
{
	//int a[] = {1,  9,  2,  8,  3,  4,  5,  3,  7,  2}; // da 8
	//int a[] = {1,  7,  4,  6,  5,  2,  3,  2,  1,  0}; // da 3
	//int a[] = {2,  2,  2,  2,  2,  2,  2,  2,  2,  2}; // da -1
	// exemplos que criei
	//int a[] = {4, 5, 1, 2, 6, 8, 7, 9, 3, 0}; // da 7
	//int a[]={9, 5, 8, 4, 7, 1, 2, 5, 8, 4}; // da 8
	//int a[] = {1, 2, 2, 2, 2, 2, 2, 2, 5, 6}; // da 9
	//int a[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}; // da -1
	//int a[] = {5, 8, 4, 2, 1, 3, 0, 8, 5, 6}; // da 9
	//int a[]={8, 0, 9, 7, 5, 4, 4, 5, 4, 1}; // da 7
	int a[]= {0, 9, 8, 7, 7, 5, 4, 3, 2, 1}; // da 1
	int indice =countelemtmaiores(a,10);
	printf("Indice do numero: %d\t Numero de comparacoes: %d\n", indice, ncomparacoes);
	return 0;
}
