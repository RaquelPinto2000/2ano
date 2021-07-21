//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula12.ex3;

public class Pessoa {
	private String nome;
	private Data datanasc;
	private int cc;
	private int n; //numero de telefone da pessoa
	
	public Pessoa (String nome,int cc, Data datanasc,int n) {
		this.nome= nome;
		this.datanasc= datanasc;
		this.cc=cc;
		this.n=n;
	}
	
	public Pessoa (String nome, int n, Data datanasc) {
		this.nome= nome;
		this.datanasc= datanasc;
		this.n=n;
	}
	
	public String nome() {
		return nome;
	}

	public Data datanasc() {
		return datanasc;
	}
	public int numero() {
		return n;
	}
	public int cc() {
		return cc;
	}

	public boolean equals(Pessoa p) {
		return cc == p.cc;
	}
	
	@Override
	public String toString() {
		return toString(" ");
	}
	
	public String toString(String mid){
		return nome + mid +  n + mid + datanasc;
	}
}
