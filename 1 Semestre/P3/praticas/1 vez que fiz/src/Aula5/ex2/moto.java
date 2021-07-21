//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex2;

public class moto extends Motorizado {

	private boolean malote;
	
	public moto(Cor cor,int potencia, int c, int combustivel,String matricula, boolean m) {
		super(2, cor, potencia,c,combustivel,matricula);
		malote=m;
	}
	
	public boolean malote() {
		return malote;
	}
	
	public String toString () {
		return "Moto";
	}
}
