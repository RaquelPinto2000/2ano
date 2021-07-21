package aula1.ex3;

import static java.lang.System.out;

import java.util.Scanner;

public class ex3 {

	static Circulo circle = null;
	static Quadrado qua = null;
	static Retangulo ret = null;
	public static void main ( String[] args) {
		int opcao;
		Scanner sc = new Scanner (System.in);
		do {
			out.println("1-Circulo");
			out.println("2-Quadrado");
			out.println("3-Retangulo");
			out.println("4 -Terminar programa");
			out.print("Escolha: ");
			opcao=sc.nextInt();
			switch(opcao){
				case 1:
					out.print("Raio: ");
					double raio = sc.nextDouble();
					out.print("Centro x: ");
					double xxx = sc.nextInt();
					out.print("Centro y: ");
					double yyy = sc.nextInt();
					circle = new Circulo (xxx,yyy,raio);
					out.println("Area: " + circle.area());
					out.println("Perimetro: " + circle.perimetro());
					verificarigual();
					verificarintercecao();
					break;
				case 2:
					out.print("Comprimento: ");
					double comp = sc.nextDouble();
					out.print("Centro x: ");
					double xx = sc.nextDouble();
					out.print("Centro y: ");
					double yy = sc.nextDouble();
					qua = new Quadrado(comp,xx,yy);
					out.println("Area: " + qua.area());
					out.println("Perimetro: " + qua.perimetro());
					break;
				case 3:
					out.print("Comprimento: ");
					double com = sc.nextDouble();
					out.print("Largula: ");
					double lar = sc.nextDouble();
					out.print("Centro x: ");
					double x = sc.nextDouble();
					out.print("Centro y: ");
					double y = sc.nextDouble();
					ret = new Retangulo (com,lar,x,y);
					out.println("Area: " + ret.area());
					out.println("Perimetro: " + ret.perimetro());
					break;
				case 4:
					break;		
			}
		}while(opcao !=4);
		sc.close();
		
	}
	
	//verificar se os circulos sao iguais
	public static void verificarigual() {
		out.println("Verificacao se os circulos sao iguais: ");
		Circulo ci = new Circulo (5,5,9); 
		Circulo ci1 = new Circulo (9,2,6);
		Circulo ci2 = new Circulo (5,7,14);
		Circulo ci3 = new Circulo (8,7,42);
		if(circle.circulosiguais(ci) == true) {
			out.println("E igual a um " + ci.toString());
		}else if(circle.circulosiguais(ci1) == true) {
			out.println("E igual a um " + ci1.toString());
		}else if(circle.circulosiguais(ci2) == true) {
			out.println("E igual a um " + ci2.toString());
		}else if(circle.circulosiguais(ci3) == true) {
			out.println("E igual a um " + ci3.toString());
		}else {
			out.println("Nao e igual a nenhum circulo");
		}
	}
	
	
	public static void verificarintercecao() {
		//verificar se os circulos se intercetam
		out.println("Verificacao de intercecoes de circulos: ");
		Circulo c = new Circulo (5,5,9); 
		Circulo c1 = new Circulo (9,2,6);
		Circulo c2 = new Circulo (5,7,14);
		Circulo c3 = new Circulo (8,7,42);
		if(circle.circulosintercetam(c) == true) {
			out.println("interceta com um " + c.toString());
		}else if(circle.circulosintercetam(c1) == true) {
			out.println("interceta com um " + c1.toString());
		}else if(circle.circulosintercetam(c2) == true) {
			out.println("interceta com um " + c2.toString());
		}else if(circle.circulosintercetam(c3) == true) {
			out.println("interceta com um " + c3.toString());
		}else {
			out.println("Nao interseta com nenhum circulo");
		}
	}	

}
