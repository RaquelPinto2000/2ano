package Aula1;

public class Quadrado {
	private double comp;
	private Ponto centro;
	private double area;
	private double perimetro;
	
	public Quadrado(double comp, double x, double y) {
		this.comp = comp;
		centro = new Ponto(x,y);
		perimetro = comp*4; 	//calculo do perimetro
		area = comp*comp;       // calculo da area;
	}
	
	public double comp() {
		return comp;
	}
	public Ponto centro() {
		return centro;
	}
	
	public double area(){
		return area;	
	}
	
	public double perimetro() {
		return perimetro;
	}
	
	//Dados todos numa String
	public String toString() {
		return "Quadrado de comprimento " + comp + "e de centro " + centro; 
	}
	
}
