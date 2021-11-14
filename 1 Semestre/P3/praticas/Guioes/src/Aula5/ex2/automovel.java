//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex2;

public class automovel extends Motorizado{
	
	private boolean trancado;
	
	public automovel(int numRodas, Cor cor, int potencia, int c, int combustivel,String matricula, boolean trancado) {
		super(numRodas, cor, potencia, c, combustivel, matricula);
		this.trancado=trancado;
	}
	
	public boolean Trancado() {
		return trancado;
	}
	
	public String toString () {
		return "Automovel";
	}
	
}
