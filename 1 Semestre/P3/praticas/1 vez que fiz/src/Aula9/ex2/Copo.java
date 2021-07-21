//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula9.ex2;
import static java.lang.System.*;

public class Copo extends GeladoDecorator{
	
	private String ingrediente;
	public Copo(Gelado g) {
		super(g);
	}
	
	public void base(int n) {
		g.base(n);
		out.print(" em copo");
	}
	
}
