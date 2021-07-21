//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula3.ex3;
import static java.lang.System.*;

public class Carta {
	private String tipo;
	
	public Carta(String tipo) {
		if(cartavalida(tipo)) {
			this.tipo=tipo;
		}else {
			out.println("Carta nao e valida");
			return;
		}
	}
	public String carta() {
		return tipo;
	}
	
	public String toString() {
		return "carta do tipo " + tipo;
	}
	
	public boolean equals(String t) {
		if(t == tipo) {
			return true;
		}else {
			return false;
		}
	}
	public boolean equals(Carta c) {
		if(tipo.equals(c.tipo)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	private boolean cartavalida(String s) {
		if(s.equals("A") || s.equals("B") || s.equals("C") ||s.equals("D")) {
			return true;
		}else {
			return false;
		}
		
	}
}
