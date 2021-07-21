package aula3.ex1;

public class Pessoa {
	private int cc;
	private String nome;
	private Data dataNasc;
	
	public Pessoa(String nome,int cc, Data dataNasc) {
		this.cc = cc;
		this.nome = nome;
		this.dataNasc = dataNasc;
	}
	public int cc() {
		return cc;
	}
	public String nome() {
		return nome;
	}
	public Data dataNasc() {
		return dataNasc;
	}
	@Override
	public String toString() {
		return nome + ", BI: "+ cc + ", Data: " + dataNasc;
	}

}
