// com ponteiros

//Crie um programa em C equivalente a este em Java.
//public class ProgA {
//	public static void main(String[] args) {
	//	int[] a = {31,28,31,30,31,30,31,31,30,31,30,31};
	//	printArray("a", a);
	//	int[] b = new int[12];
	//	cumSum(a, b);
//		printArray("b", b);
//	}
//	public static void printArray(String s, int[] a) {
		//System.out.println(s + ":");
		//for (int i=0; i<a.length; i++) {
		//System.out.print(a[i]+" ");
		//}
		//System.out.println();
	//}
	//public static void cumSum(int[] a, int[] b) {
		//int c = 0;
		//for (int i=0; i<a.length; i++) {
			//c += a[i];
			//b[i] = c;
		//}
	//}


#include <stdio.h>
void printArray(char *s, int *a, int length){ //int *a = int a[]
	
	printf("%s : ",s);
	//for (int i =0 ; i<length;i++){
	for (int* p = a ; p<a+length;p++){ //a+length = a 1 possicao que ja nao e do array
	//	printf("%p %d ", p, *p); // %p = endereco do ponteiro
		printf("%d ",  *p); // %p = endereco do ponteiro
	}
	printf("\n");
}

void cumSum(int a[],int b[],int lengthA){
	int c =0;
	int* B = b;
	//for(int i=0;i<lengthA;i++){
	for(int* p=a;p<a+lengthA;p++, B++){
		c+=*p;
		*B=c;
	}
}


int main(int argc, char **argv)
{
	int a[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	printArray("a",a,12); //a = endereco
	int b[12];
	cumSum(a,b,12);
	printArray("b",b,12);
	return 0;
}

