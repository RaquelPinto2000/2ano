//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula7.ex1;

public class Companhia {
	
	private final String companhia;
	private final String sigla;
	
	public Companhia(String sigla, String companhia) {
		this.companhia=companhia;
		this.sigla=sigla;
	}
	
	public String companhia() {
		return companhia;
	}
	
	public String sigla() {
		return sigla;
	}

	@Override
	public String toString() {
		return sigla +" " + companhia;
	}
	
	
}
