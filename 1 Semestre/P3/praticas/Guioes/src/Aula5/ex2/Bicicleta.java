//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex2;

public class Bicicleta extends Veiculo{
	
	private double as; //altura do selim
	
	public Bicicleta(Cor cor, double alturaselim) {
		super(2,cor);
		as=alturaselim;
	}
	
	public double alturaSelim() {
		return as;
	}
	
	public String toString() {
		return "Bicicleta";
	}
}
