//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex2;

public class Motorizado extends Veiculo {
	
	private int potencia;
	private int c; //cilindrada
	private int combustivel; //velocidade maxima
	private String matricula;
	
	public Motorizado(int numRodas, Cor cor, int potencia, int c, int combustivel,String matricula) {
		super(numRodas,cor);
		this.potencia=potencia;
		this.c=c;
		this.combustivel=combustivel;
		this.matricula=matricula;
	}
	
	public int getPotencia() {
		return potencia;
	}
	
	public int getCilindrada() {
		return c;
	}
	
	public int getCombustivel() {
		return combustivel;
	}
	public String matricula() {
		return matricula;
	}
}
