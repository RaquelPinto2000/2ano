package Aula1;

public class Retangulo {
	private double comp;
	private double lar;
	private Ponto centro;
	private double area;
	private double perimetro;
	
	
	public Retangulo (double comp, double lar, double x, double y) {
		this.comp = comp;
		this.lar=lar;
		centro = new Ponto(x,y);
		area = comp*lar; //calculo da area
		perimetro = (comp*2) + (lar * 2); //calculo do perimetro
	}
	
	public double comp() {
		return comp;
	}
	public double lar() {
		return lar;
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
		return "Retangulo\n" +  "Comprimento:" + comp + "\n" + "Largura: " + lar + "\n" + "centro: " + centro; 
	}
}
