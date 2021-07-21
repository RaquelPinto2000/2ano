//Raquel Resende Milheiro Pinto nºMEC = 92948
package aula5.ex3;

public class Pessoa {
	private String nome;
	private int cc;
	private Data datanasc;
	private int num;
	
	public Pessoa(String nome, int cc, Data datanasc,int num) {
		this.nome= nome;
		this.cc = cc;
		this.num=num;
		this.datanasc= datanasc;

	}
	public Pessoa(String nome,Data datanasc,int num) {
		this.nome= nome;
		this.num=num;
		this.datanasc= datanasc;

	}
	public String nome() {
		return nome;
	}
	public int cc() {
		return cc;
	}
	public Data datanasc() {
		return datanasc;
	}
	public int numero() {
		return num;
	}
	
	public String toString() {
		return String.format("%1$"+12+"s", nome) + " | " + String.format("%1$"+11+"s", cc)+" | "+String.format("%1$"+8+ "s", datanasc) + " | " + String.format("%1$"+11+"s", num);
	}	
}