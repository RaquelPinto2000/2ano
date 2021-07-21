package Aula8.ex2;

import java.util.Arrays;

public class Pergunta {

	private String nameima;
	private String pergunta;
	private String[] opcao;
	private int dificuldade;

	public Pergunta(String nameima, String pergunta, String[] opcao, int dificuldade) {
		this.nameima = nameima;
		this.pergunta = pergunta;
		this.opcao = opcao;
		this.dificuldade = dificuldade;
	}

	public String nomeimagem() {
		return nameima;
	}
	
	public String pergunta() {
		return pergunta;
	}
	
	public String[] opcao() {
		return opcao;
	}
	
	public int dificuldade() {
		return dificuldade();
	}
	
	@Override
	public String toString() {
		return "Pergunta [nameima=" + nameima + ", pergunta=" + pergunta + ", opcao=" + Arrays.toString(opcao)
				+ ", dificuldade=" + dificuldade + "]";
	}

}
