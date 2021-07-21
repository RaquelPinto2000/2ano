package aula9.ex2;

public class Topping extends GeladoDecorator{
	private String nome;
	public Topping(Gelado g) {
		super(g);
	}
	public Topping(Gelado g,String s) {
		super(g);
		nome=s;
	}	
	public void base(int n) {
		g.base(n);
		System.out.print(" com " + nome);
	}
}
