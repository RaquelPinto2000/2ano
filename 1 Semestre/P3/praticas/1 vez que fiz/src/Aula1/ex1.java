package Aula1;
import static java.lang.System.*;
import java.util.Scanner;
public class ex1 {
	
	public static void main ( String[] args) {
		Scanner sc = new Scanner(System.in);
		out.print("Introduza uma frase: ");
		String s = sc.nextLine();
		sc.close();
		int count=0; //conta os digitos que a string tiver
		int countmin=0, countmai=0; //verifica se sao todos em minusculas e maiusculas
		int ver=0; //numero de caracteres que a frase tem
		int k; //conta o numero de palavras
		String a[] = s.split(" ");
		for(k = 0; k<a.length;k++) {
			String nova = a[k];
			for(int i = 0; i<nova.length();i++) {
				char letra = nova.charAt(i);
				if(Character.isDigit(letra)) {
					count++;				
				}else if(Character.isLowerCase(letra)) {
					countmin++;
				}else if (Character.isUpperCase(letra)) {
					countmai++;
						
				}
				
			ver++;
			}
		}
		if(countmin==ver) {
			out.println("String so com letras minusculas");
		}else if(countmai==ver) {
			out.println("String so com letras maiusculas");
			
		}else {
			out.printf("Essa frase tem %2d digitos\n",count);
		}
				
		//indica as palavras que tem a frase
		out.println("A frase tem estas palavras: ");
		
		
		String aux=""; // para depois se trocar os caracteres 2 a 2
		
		for(int j=0;j<a.length;j++) {
			out.println(a[j] + " ");
			aux += a[j];

		}
		out.printf("Tem %2d palavras\n",k);
		
		
		
		//trocar os caracteres 2 a 2
		out.println("Frase com caracteres trocados 2 a 2: ");
		
		String nova = ""; // e igual ao array de strings todo junto
		
		for(int i = 0; i<aux.length()-1;i+=2) {
			nova += String.valueOf(aux.charAt(i+1)) + String.valueOf(aux.charAt(i));	
		}
		if(aux.length()%2!=0) {
			// se a frase tiver numero impar de caracteres, ele acrescenta no final o ultimo caracter
			nova += aux.charAt(aux.length()-1); 
		}
		out.print(nova);
	}
		
	
}