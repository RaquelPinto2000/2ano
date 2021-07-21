

#include <stdio.h>

int main(int argc, char **argv)
{
	printf("Numeros de Armstrong entre 100 e 999:\n");
	int a, b,c,d;
	int count=0;
	for(int i=100;i<=999;i++){
		a=i/100;
		b = (i-a*100)/10;
		c = (i-a*100-b*10);
		d = a*a*a+b*b*b+c*c*c;
		count += 9;
		if(i==d){
			printf("%d\n",i);
		}
	}
	printf("numero de multiplicacoes = %d\n",count);
	
	return 0;
}

