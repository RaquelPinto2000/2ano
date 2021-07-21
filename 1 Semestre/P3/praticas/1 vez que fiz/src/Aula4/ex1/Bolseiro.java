//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula4.ex1;

public class Bolseiro extends Estudante{
	private int bolsa = 0;
	public Bolseiro(String nome, int cc , Data datanasc) {
		super(nome,cc,datanasc);
	
	}
	
	public Bolseiro(String nome, int cc , Data datanasc, Data datainsc) {
		super(nome,cc,datanasc,datainsc);
	}
	
	public void setBolsa(int b) {
		bolsa = b;
	}
	public int bolsa() {
		return bolsa;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Bolseiro com bolsa de " + bolsa;
	}
}

