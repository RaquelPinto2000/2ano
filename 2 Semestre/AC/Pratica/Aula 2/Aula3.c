
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "elapsed_time.h"

static int count =0;

int recursiva(int n){
	if(n==0){
		return 0;
	}else if(n==1){
		return 1;
	}else{ //n>=2
		count+=2;
		return 3 * recursiva(n-1) + 2*recursiva(n-2);
	}
	/*if(n<=1){
	 * 	return n;
	 * }else{
	 * 	return 3 * recursiva(n-1) + 2*recursiva(n-2);
	 * }
	 * */
}

int iterativaV1(int n){  //o que esta escrito
	int r0=0,r1=1,r2=0; //i-2 =r2 i-1=r1  r0 = queremos;
	if(n==0){
		return 0;
	}else if(n==1){
		return 1;
	}else{
		for(int i = 2;i<=n;i++){
			count+=2;
			r0 = 3*r1+2*r2;
			r2=r1;
			r1=r0;	
		}
		return r0;
	}
}

int iterativaV2(int n){ //Equação de recorrência
	if(n==0){
		return 0;
	}else if(n==1){
		return 1;
	}else{
		count+=2;
		double a = (0.5)*(3+sqrt(17));
		//printf("a = %f",a);
		double b = (0.5)*(3-sqrt(17));
		double resultado = pow(a,n) - pow(b,n);
		//printf("resul=%f",resultado);
		return (resultado/sqrt(17));
	}
}



int iterativaV3(int n){ // Termo mais importante da equação de recorrência
	if(n==0){
		return 0;
	}else if(n==1){
		return 1;
	}else{
		count+=2;
		double aux = 0.5*(3+((sqrt(17))));
		double p =(1/sqrt(17)*pow((aux),n));
		return (round(p));
	}
	
}

int iterativaV4(int n){ //Fórmula fechada usando a função exponencial
	if(n==0){
		return 0;
	}else if(n==1){
		return 1;
	}else{	//F(n) = round(c1 × e^(c2 ×n)
		count+=2;
		double c1 = 0.24253562503633297352;
		double c2 = 1.27019663313689157536;
		double result = c1*exp(c2*n);
		return round(result);
	}
}

int main(int argc, char **argv) //int main(int argc, char argv[]) // tamanho do array e o array
{
	printf("I\tP(n)\tMultiplicacoes\tTempo\t\tVerificacao\n"); // verificacao aquilo que o stor disse que parecia uma funcao geometrica...tende para uma constante
	printf("-------------------------------------------------------\n");
	for(int i=0;i<40;i++){ // acontece overflow quando diminui de uma posicao inferior para a posterior (ou valores negativos)
	    count =0;
		elapsed_time();
		int result=iterativaV1(i);
		//double ver = count/i; // ver e = a^n , verifica se e uma funcao geometrica tende para 16,81 -> faz numa folha de calculo (nao tem haver com o codigo)
		printf("%d\t%d\t\t%d\t%f\t%s\n",i,result,count,elapsed_time(),"Fazer numa folha de calculo vai tenter para 16,81");
		
		// contar as multiplicacoes so faz sentido no iterativaV1. Para as outras o ^n e as divisoes tm contam como multiplicacoes
	}
	
	return 0;
}

