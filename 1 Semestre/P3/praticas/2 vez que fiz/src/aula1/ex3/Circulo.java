package aula1.ex3;

public class Circulo {
	private double raio;
	private Ponto centro;
	private double area;
	private double perimetro;
	
	public Circulo(double x, double y, double r) {
		centro = new Ponto(x,y);
		raio=r;
		area = Math.PI *Math.pow(r, 2);
		perimetro = 2*Math.PI * r;
	}
	public Circulo(Ponto centro, double r) {
		this.centro=centro;
		raio=r;
		area = Math.PI *Math.pow(r, 2);
		perimetro = 2*Math.PI * r;
	}
	public double raio() {
		return raio;
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
		return "Circulo [raio=" + raio + ", centro=" + centro + ", area=" + area + ", perimetro=" + perimetro + "]";
	}
	
	public boolean circulosiguais(Circulo c) {
		if(c.raio()==raio) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean circulosintercetam(Circulo c) {
		double soma = c.raio()+raio;
		if(centro.distTo(c.centro())>=soma) {
			return false;
		}else {
			return true;
		}
	}
	
}
