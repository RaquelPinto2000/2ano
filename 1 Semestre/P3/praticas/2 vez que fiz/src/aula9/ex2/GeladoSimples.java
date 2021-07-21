package aula9.ex2;

public class GeladoSimples implements Gelado{
	private String nome;

	public GeladoSimples(String nome) {
		this.nome = nome;
	}
	
	public void base(int n) {
		System.out.print(n + " bolas de gelado de " + nome );
	}
}
