//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula9.ex2;

import static java.lang.System.*;
public class GeladoSimples implements Gelado {
	
	private String ingrediente;

	public GeladoSimples(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	@Override
	public void base(int n) {
		out.print(n+" bolas de gelado de "+ ingrediente);
	}
	
	
	
}
