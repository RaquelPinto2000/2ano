//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex2;

public class MotoPolicia extends moto implements Policia{

	public MotoPolicia (Cor cor, int potencia, int c, int combustivel,String matricula, boolean m) {
		super(cor,potencia,c,combustivel,matricula,m);
	}
	
	public ServicoUrgencia getTipo() {
		return ServicoUrgencia.PSP;
	}
	
	public String toString() {
		return "Moto da Policia";
	}
}
