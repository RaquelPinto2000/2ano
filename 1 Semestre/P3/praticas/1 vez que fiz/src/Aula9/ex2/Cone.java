//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula9.ex2;
import static java.lang.System.*;
public class Cone extends GeladoDecorator{

	public Cone(Gelado g) {
		super(g);
	}
	
	public void base(int n) {
		g.base(n);
		out.print(" em cone");
	}
}
