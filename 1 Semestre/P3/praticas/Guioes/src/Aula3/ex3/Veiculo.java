//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula3.ex3;

public class Veiculo {
	private Condutor con; //condutor
	private double cilin; //cilindrada
	private double P; //potencia
	private int lo; //lotacao
	private double peso; 
	private Carta c; //carta
	
	public Veiculo (Condutor con, double cilin, double P, int lo, double peso, Carta c) {
		this.con = con;
		this.cilin= cilin;
		this.P=P;
		this.lo=lo;
		this.peso=peso;
		this.c=c;
	}
	
	public Condutor condutor() {
		return con;
	}
	public double cilindrada() {
		return cilin;
	}
	public double potencia() {
		return P;
	}
	public int lotacao() {
		return lo;
	}
	public double peso() {
		return peso;
	}
	public Carta carta() {
		return c;
	}
	public String toString() {
		return "Veiculos com condutor " + con +  " de lotacao " + lo + " de cilindrada " + cilin + 
				" com peso bruto de " + peso + " de potencia de " + P;
	}
}
