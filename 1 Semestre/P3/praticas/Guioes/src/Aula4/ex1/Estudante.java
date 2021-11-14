//Raquel Resende Milheiro Pinto nºMEC = 92948

package Aula4.ex1;

public class Estudante extends People{
	static private int contadorNMEC = 100; //e da class
	
	private int nMec; //e do objeto
	private Data datainsc;
	
	public Estudante(String nome, int cc, Data datanasc) {
		super(nome, cc, datanasc);
		datainsc = new Data();
		nMec = contadorNMEC++;
	}
	
	public Estudante(String nome, int cc,Data datanasc, Data datainsc) {
		super(nome, cc, datanasc);
		this.datainsc = new Data (datainsc.dia(),datainsc.mes(),datainsc.ano());
		nMec = contadorNMEC++;
	}
	public Data datainsc() {
		return datainsc;
	}
	public Data data() {
		return datainsc;
	}
	public int nMec() {
		return nMec;
	}
	public String toString() {
		return super.toString() + ", NMec: " + nMec + ", inscrito em Data: " + datainsc;
	}
	


}
