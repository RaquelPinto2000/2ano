//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula3.ex3;

public class Ligeiro extends Veiculo{
	private String cor;

	public Ligeiro(Condutor con, double cilin, double P, int lo, double peso,String cor) {
		super(con,cilin,P, lo, peso, new Carta("B"));
		this.cor=cor;
	}
	
	public String cor() {
		return cor;
	}
	
	public void cornova(String nova) {
		cor = nova;
	}
	
	//verifica se pode ser mais passageiros
	public boolean addpassageiro(int a) {
		if(a>super.lotacao()) {
			return false;
		}else {
			return true;
		}
	}
	
	
	public String toString() {
		return "Veiculo ligeiro " + cor + " com condutor " + super.condutor().nome() + 
				" de lotacao " + super.lotacao() + " de cilindrada " + super.cilindrada() + 
				" com pesso bruto de " + super.peso() + " de potencia de " + super.potencia();
	}
	
	
	
	
}
