//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula4.ex1;


public class People {
	private String nome;
	private int cc;
	private Data datanasc;
	
	
	public People(String nome, int cc, Data datanac) {
		this.nome = nome;
		this.cc=cc;
		this.datanasc=datanac;
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

	public String toString() {
		return nome + ", BI: " + cc + ", Nasc. Data: "+ datanasc;
	}
	
	
	public boolean equals(People a) {
		if(cc == a.cc()) {
			return true;
		}else {
			return false;
		}
	}
	
}
