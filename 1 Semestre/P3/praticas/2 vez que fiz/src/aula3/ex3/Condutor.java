package aula3.ex3;

public class Condutor {
	private String nome;
	private int number;
	private Data datanasc;
	private Carta carta;
	
	public Condutor(String nome, int number, Data datanasc, Carta carta) {
		this.nome = nome;
		this.number = number;
		this.datanasc = datanasc;
		this.carta = carta;
	}
	
	
	public String nome() {
		return nome;
	}
	public int numero() {
		return number;
	}
	public Data datanasc() {
		return datanasc;
	}
	public Carta tipocarta() {
		return carta;
	}

	@Override
	public String toString() {
		return "Condutor [nome=" + nome + ", number=" + number + ", datanasc=" + datanasc + ", carta=" + carta + "]";
	}
	
}
