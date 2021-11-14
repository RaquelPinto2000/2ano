package Aula13.ex1.parte2;

public class Provincia extends Regiao{
	public String governador;

	public Provincia(String nome, int populacao, String governador) {
		super(nome, populacao);
		this.governador = governador;
	}
	
	public String getGovernador() {
		return governador;
	}
}
