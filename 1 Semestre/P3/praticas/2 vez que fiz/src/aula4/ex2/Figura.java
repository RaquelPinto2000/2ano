package aula4.ex2;

public abstract class Figura {
	private Ponto centro;
	public Figura(Ponto centro) {
		this.centro=centro;
	}
	
	public Ponto centro() {
		return centro;
	}

	@Override
	public String toString() {
		return "Figura [centro=" + centro + "]";
	}
	public abstract double area();
	public abstract double perimetro();
	
}
