//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula9.ex2;

import static java.lang.System.*;

public class Topping extends GeladoDecorator{

	private String ingrediente=null;
	public Topping(Gelado g) {
		super(g);
	}
	public Topping(Gelado g, String ingrediente) {
		super(g);
		this.ingrediente=ingrediente;
	}
	
	public void base(int n) {
		g.base(n);
		out.print(" com " + ingrediente);
	}
}
