package aula9.ex2;

public abstract class GeladoDecorator implements Gelado{
	protected Gelado g;
	
	public GeladoDecorator(Gelado g) {
		this.g = g;
	}
}
