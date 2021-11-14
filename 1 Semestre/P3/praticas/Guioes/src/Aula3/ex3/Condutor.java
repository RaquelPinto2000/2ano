//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula3.ex3;

public class Condutor extends People {
	private Carta carta;
	public Condutor(String nome, int cc, Data datanac,Carta c) {
		super(nome,cc,datanac);
		carta=c;
	}
	public Carta carta() {
		return carta;
	}
	public String toString() {
		return super.toString() + ", Carta: " + carta;
	}
}
