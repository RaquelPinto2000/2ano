//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula4.ex3;

public class Pessoa {
	private String nome;
	private int cc;
	private Data datanasc;
	private int nsocio;
	private Data datainsc;
	private int requesitou; // numero de livros que cara pessoa requesita
	
	public Pessoa(String nome, int cc, Data datanasc, int nsocio, Data datainsc, int requesitou) {
		this.nome= nome;
		this.cc = cc;
		this.datanasc= datanasc;
		this.nsocio = nsocio;
		this.datainsc=datainsc;
		this.requesitou = requesitou; 
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
	public int nsocio() {
		return nsocio;
	}
	public Data datainsc() {
		return datainsc;
	}
	public int requesitou() {
		return requesitou;
	}
	public String toString() {
		return String.format("%1$"+12+"s", nome) + " | " + String.format("%1$"+11+"s", cc)+" | "+String.format("%1$"+8+ "s", datanasc);
	}	
}