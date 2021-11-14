package Aula13.ex1.parte2;

public class Localidade {
	private final String nome;
	private final int populacao;
	
	public Localidade(String nome, int populacao) {
		this.nome = nome;
		this.populacao = populacao;
	}

	@Override
	public String toString() {
		return String.format("%s %s, População: %d",nome,populacao);
	}	
}
