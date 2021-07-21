
#include <stdio.h>
static int countT1 =0; // numero de chamadas recursivas em T1
static int countT2 =0; // numero de chamadas recursivas em T2
static int countT3 =0; // numero de chamadas recursivas em T3

int T1(int n) {
	int resultado=0;
	if(n==0){
		resultado = 0;
	}else if(n>0){
		countT1++; // acrecenta-se uma chamada recursiva
		resultado = T1(n/3) + n;
	}
	return resultado;
}

int T2(int n) {
	int resultado = 0;
	if(n==0||n==1||n==2){
		resultado = n;
	}
	if(n>2){
		countT2 +=2; // acrecenta-se duas chamadas recursivas
		resultado = T2(n/3) + T2((n+2)/3) + n;
	}
	return resultado;	
}

int T3(int n) {
	int resultado = 0;
	if(n<=2){
		resultado = n;
	}else if(n%3==0){
		countT3++; // acrecenta-se uma chamadas recursivas
		resultado = 2*T3(n/3)+n;
	}else{
		countT3 +=2; // acrecenta-se duas chamadas recursiva
		resultado = T3(n/3) + T3((n+2)/3) + n;
	}
	return resultado;
}

int main(int argc, char **argv)
{
	for(int i =0;i<= 28;i++){
		countT1=0;
		int t1 = T1(i);
		countT2=0;
		int t2 = T2(i);
		countT3=0;
		int t3 = T3(i);
		printf("------------------n = %d------------------\n\n",i);
		printf("T1 = %d\t\t\t Nº de chamadas recursivas = %d\n",t1,countT1);
		printf("T2 = %d\t\t\t Nº de chamadas recursivas = %d\n",t2,countT2);
		printf("T3 = %d\t\t\t Nº de chamadas recursivas = %d\n",t3,countT3);
	}
	return 0;
}

