
# include <assert.h>
#include <stdio.h>


static int ncopias = 0; // numero de copias -> numero de deslocamentos
static int ncomparacoes = 0; // numero de comparacoes

void RetiraRepetidos(int* a, int* n){ // vetor original e numero de elementos
	assert (*n>1);
	ncomparacoes=0; // numero de comparacoes
	ncopias=0; // numero de copias -> numero de deslocamentos

	for(int i = 1; i<*n;i++){
		for(int j=0;j<i;j++){
			ncomparaco7es++;
			if(a[i]==a[j]){
				for(int k = i;k<*n-1;k++){ // remover elementos repetidos do array (deslocamentos\copias)
					ncopias++;
					a[k] = a[k+1];
				}
				i--;
				(*n)--;
			}
		}
	}

}
	/*
	// meu no inicio -> nao se podia fazer assim, pq depois nos somatorios dava mal
	for(int i = 0;i<*n;i++){
		for(int j = i+1;j<*n;j++){
			ncomparacoes++;
			if(a[i]==a[j]){
				for(int k = j;k<*n-1;k++){
					ncopias++;
					a[k] = a[k+1];
				}
				j--;
				(*n)--;
			}
		}
	}
	 */

/*
// sofia
int sequence(int *pInt, int length) {
    assert(length>1);
    int numberOfComp = 0;
    int bestInd = 0;
    int mostSmaller = 0;
    for (int currentIndex = 1; currentIndex < length; ++currentIndex) {
        int currentSmaller = 0;
        for (int i = 0; i < currentIndex; ++i) {
            numberOfComp++;
            if(pInt[i] < pInt[currentIndex]){
                currentSmaller++;
            }
        }
        numberOfComp++;
        if(currentSmaller> mostSmaller){
            bestInd = currentIndex;
            mostSmaller= currentSmaller;
        }
    }
    printf("Tamanho: %d Number of comparisons: %d\n",length, numberOfComp);
    return(bestInd);
}

*/



int main(int argc, char **argv)
{
	int n=10;
	//int a[] = {1,2,2,2,3,3,4,5,8,8};
	//RetiraRepetidos(a,&n); // &n e o endereco da variavel n (assim ele vai buscar o valor que esta no endereço)
	//int a[] = {1,2,2,2,3,3,3,3,8,8};
	//int a[] ={1,2,5,4,7,0,3,9,6,8};
	//int a[] = {1,2,3,2,1,3,4,4,2,1};
	//int a[]={1,1,1,1,1,1,1,1,1,1};
	//int a[] = {3,8,5,4,7,5,4,7,2,8};
	//int a[] ={10,5,8,4,7,5,4,10,9,8};
	//int a[] ={9,4,8,4,8,4,8,2,5,2};
	//int a[] ={4,5,5,5,6,6,6,8,8,8};




	//int a[] = {1,1,1,1,1,1,1,1,1};
	//n=9;
	//int r = sequence(a,10);



	int a[] ={1,2,3,2,1,3,4};
	n=7;
	RetiraRepetidos(a,&n);

	for(int i =0;i<n;i++){
		printf("Array final: %d\t", a[i]);
	}
	printf("Numero de comparacoes: %d\t Numero de copias: %d\n",ncomparacoes,ncopias);
	//printf("%d\n", r);
	return 0;
}
