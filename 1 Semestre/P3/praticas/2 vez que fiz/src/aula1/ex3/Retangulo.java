package aula1.ex3;

public class Retangulo {
	private double lado;
	private double comprimento;
	private Ponto centro;
	private double area;
	private double perimetro;
	
	public Retangulo( double comprimento,double lado, double xx, double yy) {
		this.lado = lado;
		this.comprimento = comprimento;
		this.centro = new Ponto(xx,yy);
		area = lado*comprimento;
		perimetro = (lado*2)+(comprimento*2);
	}
	public double lado() {
		return lado;
	}
	public double comprimento() {
		return comprimento;
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
		return "Retangulo [lado=" + lado + ", comprimento=" + comprimento + ", centro=" + centro + ", area=" + area
				+ ", perimetro=" + perimetro + "]";
	}

	
}
