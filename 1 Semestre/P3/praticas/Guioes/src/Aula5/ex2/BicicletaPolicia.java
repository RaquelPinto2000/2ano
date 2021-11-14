//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex2;

public class BicicletaPolicia extends Bicicleta implements Policia{

	
	public BicicletaPolicia (Cor cor, double alturaselim) {
		super(cor,alturaselim);
	}
	
	public String toString() {
		return "Bicicleta da policia";
	}
	
	public ServicoUrgencia getTipo() {
		return ServicoUrgencia.GNR;
	}
}
