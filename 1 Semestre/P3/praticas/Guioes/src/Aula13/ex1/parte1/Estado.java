package Aula13.ex1.parte1;

public class Estado extends Regiao{
	private Localidade capital;

	public Estado(String nome, int populacao, Localidade capital) {
		super(nome, populacao);
		this.capital = capital;
	}
	
	public Localidade getCapital() {
		return capital;
	}
}
	
