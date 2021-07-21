//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula3.ex3;

public class Motociclo extends Veiculo{
	private boolean reboque; //se tem ou nao reboque ou malinhas (=1->nao tem, =2->tem)
	
	public Motociclo(Condutor con, double cilin, double P, int lo, double peso, boolean r) {
		super(con,cilin, P, lo,peso, new Carta("A"));
		reboque=r;
	}
		
	public boolean reboque() {
		return reboque;
	}
	
	public String toString() {
		return "Motociclo com reboque/malinhas: " + reboque + ". de condutor " + super.condutor().nome() + 
				" de lotacao " + super.lotacao() + " de cilindrada " + super.cilindrada() + 
				" com pesso bruto de " + super.peso() + " de potencia de " + super.potencia();
	}
	
}
