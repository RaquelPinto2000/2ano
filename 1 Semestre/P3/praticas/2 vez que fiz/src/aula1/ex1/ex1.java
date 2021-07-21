package aula1.ex1;
import java.util.*;
public class ex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduza a frase: ");
		String s = sc.nextLine();
		sc.close();
		String a[] = s.split(" ");
		int count=0;
		int cont=0;
		int co=0;
		int ver=0;
		String aux ="";
		for (int i = 0; i < a.length; i++) {
			aux = a[i];
			for (int k = 0; k < aux.length(); k++) {
				if(Character.isDigit(aux.charAt(k))) { // se for um numero
					count++;
				}else if(Character.isLowerCase(aux.charAt(k))) { // se for minuscula
					cont++;
				}else if(Character.isUpperCase(aux.charAt(k))) { // se for maiuscula
					co++;
				}
			}
			ver++;
		}
		
		System.out.println("Numero de caracteres numericos: "+count);
		if(ver==cont) {
			System.out.println("so tem minusculas");
		}else if(ver==co) {
			System.out.println("Numero de caracteres maiusculas");
		}
	
		aux="";
		String nova = "";
		System.out.println("Foram lidas " + a.length + " palavras");
		for (int j = 0; j < a.length; j++) {
			System.out.println(a[j]);
			aux+=a[j];
		}
		
		
		for(int i=0;i<aux.length()-1;i+=2) {
			nova += String.valueOf(aux.charAt(i+1)) + String.valueOf(aux.charAt(i));
		}
		
		if(aux.length()%2!=0) {
			nova+=aux.charAt(aux.length()-1);
		}
		
		System.out.println(nova);
	}

}
