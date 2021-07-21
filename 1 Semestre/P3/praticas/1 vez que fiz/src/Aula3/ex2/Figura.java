//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula3.ex2;

public class Figura {
	private Ponto c; //centro da figura
	
	public Figura(Ponto c) {
		this.c=c;
	}
	public Ponto centro() {
		return c;
	}
	public String toString() {
		return "Centro: " + c;
	}
}
