
#include <stdio.h>
#include <math.h> // para o quadrado - pow e para a raiz - sqrt

double fatorial(int n){
    if ( n <= 1 )
        return (1);
    else{
       return n * fatorial(n - 1);
    }
}

int main(int argc, char **argv)
{
	printf("Fatoriao menores que 10^6:\n");
	int a, b,c,d;
	for(int i=100;i<999;i--){ //for(int i=1; i< pow(10,2); i++){
		a=i/100;
		b = (i-a*100)/10;
		c = (i-a*100-b*10);
		d = fatorial(a)+fatorial(b)+fatorial(c);
		if(i==d){
			printf("%d\n",i);
		}
	}
	return 0;
}

