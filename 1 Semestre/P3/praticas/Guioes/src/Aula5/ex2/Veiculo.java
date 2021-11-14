//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex2;

public class Veiculo {
	
	private static int idvaiculo=1;
	private int ID;
	private int numRodas;
	private Cor cor;
	
	public Veiculo (int numRodas, Cor cor) {
		this.numRodas = numRodas;
		this.cor=cor;
		ID = idvaiculo++;
	}
	
	public int ID() {
		return ID;
	}
	
	public int numRodas() {
		return numRodas;
	}
	
	public Cor cor() {
		return cor;
	}
	

	public String toString() {
		return "Veiculo";
	}
	
}
