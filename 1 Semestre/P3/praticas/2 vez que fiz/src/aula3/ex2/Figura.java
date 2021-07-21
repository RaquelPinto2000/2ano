package aula3.ex2;

public class Figura {
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
	
	
}
