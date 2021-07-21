// Raquel Resende Milheiro Pinto -> nMec: 92948
#include <stdio.h>
static int countMul=0; // numero de multiplicacoes (versao recursiva)
static int countIterativoMul=0; // numero de multiplicacoes (versao iterativa)

// Versao recursiva
int Motzkin(int n){
	int result=0;
	if(n==0 || n==1){
		result = 1;
	}else if(n>1){
		int aux = 0;
		for(int k = 0 ;k<=n-2;k++){
			countMul++;
			aux += Motzkin(k) * Motzkin(n-2-k);

		}
		result =  Motzkin(n-1)+ aux;
	}
	return result;
}

// Versao iterativa
int MotzkinIterativo (int n){
	int num[n+1]; // array de tamanho n + 1 pq tem posicao 0
	num[0] = 1;
	num[1] = 1;
	for(int k = 2;k<=n; k++){ // da posicao 2 ate ao final do array
		int aux=0;
		for(int l = 0;l<=k-2;l++){ // fazer as contas de 0 ate a posicao do array-2
			countIterativoMul++;
			aux += num[l] * num[k-2-l];
		}

		num[k] = num [k-1]+ aux;
	}
	return num[n];
}

int main (void){
	printf("\n  n\tMotzkinRec\tNmulRec\t\tMotzkinIter\tNmulIter\n");
	for(int i = 0;i<16;i++){
		int r = Motzkin(i);
		int res = MotzkinIterativo(i);
		printf("%3d\t%6d\t\t%6d\t\t%6d\t\t%6d \n",i,r,countMul,res,countIterativoMul );
		countMul=0;
		countIterativoMul=0;
	}
	return 0;
}
