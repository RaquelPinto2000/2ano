//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex2;

public class CarroPolicia extends automovel implements Policia{

	private boolean sirene;
	
	public CarroPolicia(int numRodas, Cor cor, int potencia, int c, int combustivel,String matricula, boolean trancado, boolean sirene) {
		super(numRodas,cor, potencia,c,combustivel,matricula,trancado);
		this.sirene=sirene;
	}
	
	public ServicoUrgencia getTipo() {
		return ServicoUrgencia.PJ;
	}
	public String toString() {
		return "Carro da Policia";
	}
	
	public boolean sirene() {
		return sirene;
	}
	
	//liga e desliga a sirene
	public void controlesirene() {
		sirene=!sirene;
	}
}
