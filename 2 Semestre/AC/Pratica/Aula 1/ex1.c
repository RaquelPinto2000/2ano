
#include <stdio.h>

static unsigned int niter =0; // variavel global

unsigned int f1 (unsigned int n){
	unsigned int i,j,r=0;
	for(i =1; i<= n; i++){
		for(j=1; j<=n;j++){
			r+=1;
			niter++;
		}
	}
	return r;
}

unsigned int f2 (unsigned int n){
	unsigned int i,j,r=0;
	for(i =1; i<= n; i++){
		for(j=1; j<=i;j++){
			r+=1;
			niter++;
		}
	}
	return r;
}

unsigned int f3 (unsigned int n){
	unsigned int i,j,r=0;
	for(i =1; i<= n; i++){
		for(j=i; j<=n;j++){
			r+=j;
			niter++;
		}
	}
	return r;
}

unsigned int f4 (unsigned int n){
	unsigned int i,j,r=0;
	for(i =1; i<= n; i++){
		for(j=i; j>=1;j/=10){
			r+=i;
			niter++;
		}
	}
	return r;
}


int main(int argc, char **argv)
{
	unsigned int r;
	for(unsigned int i =0;i<=15;i++){
		niter =0;
	//	r = f1(i);
	//	r = f2(i);
		r = f3(i);
	//	r = f4(i);
		printf("%4d\t%7u\t%7u\n", i,r,niter);
	}
	
	return 0;
}

