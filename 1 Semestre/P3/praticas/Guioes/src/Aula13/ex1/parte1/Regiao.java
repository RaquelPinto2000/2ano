package Aula13.ex1.parte1;

public abstract class Regiao {
	private String nome;
	private int populacao;
	public Regiao(String nome, int populacao) {
		super();
		this.nome = nome;
		this.populacao = populacao;
	}
	public String getNome() {
		return nome;
	}
	
	public int populacao() {
		return populacao;
	}
}
