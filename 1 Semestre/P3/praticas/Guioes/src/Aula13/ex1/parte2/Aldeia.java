package Aula13.ex1.parte2;

public class Aldeia extends Localidade{

	public Aldeia(String nome, int populacao) {
		super(nome, populacao);
	}

	@Override
	public String toString() {
		return "Aldeia " + super.toString();
	}
	
	
}
