package aula1.ex3;

public class Quadrado {
	private double lado;
	private Ponto centro;
	private double area;
	private double perimetro;
	
	public Quadrado(double lado,double xx, double yy) {
		this.lado = lado;
		this.centro = new Ponto(xx,yy);
		area = lado*lado;
		perimetro = (lado*4);
	}
	public double lado() {
		return lado;
	}
	public double area() {
		return area;
	}
	public double perimetro() {
		return perimetro;
	}
	public Ponto centro() {
		return centro;
	}
	@Override
	public String toString() {
		return "Quadrado [lado=" + lado + ", centro=" + centro + ", area=" + area + ", perimetro=" + perimetro + "]";
	}

	
}
