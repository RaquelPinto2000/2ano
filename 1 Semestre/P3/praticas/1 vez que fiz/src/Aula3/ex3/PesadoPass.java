//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula3.ex3;
import static java.lang.System.*;

public class PesadoPass extends Veiculo {
	static private int n;
	private String[] destinos = {"Aveiro", "Braganca", "Porto", "Algarve", "Lisboa", "Coimbra"};
	
	public PesadoPass(Condutor con, double cilin, double P, int lo, double peso) {
		super(con, cilin, P, lo,peso, new Carta("D"));
	}
	
	//numero de pessoas saindo uma
	public int saidapessoas(int np) {
		assert n>0;
		n = n- np;
		return n;
	}

	//numero de pessoas entrando uma
	public int entrapessoa(int np, People p) {
		n=n + np;
		return n;
	}
	
	public void nextparagem (String p) {
		for(int i =0;i<destinos.length;i++) {
			if(p==destinos[i]) {
				out.println("Proxima paragem: " + p);
				return;
			}
		}
		out.println("A paragem " + p + " nao existe");			
	}
	
	public String toString () {
		return "Pessado de passageiros com " + n + " passageiros de condutor " + super.condutor().nome() + 
				" de lotacao " + super.lotacao() + " de cilindrada " + super.cilindrada() + 
				" com pesso bruto de " + super.peso() + " de potencia de " + super.potencia();
	}
	
}
