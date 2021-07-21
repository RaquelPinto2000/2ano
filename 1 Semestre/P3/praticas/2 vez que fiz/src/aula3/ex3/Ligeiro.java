package aula3.ex3;

public class Ligeiro extends Veiculo {
	private String cor;

	

	public Ligeiro(Condutor condutor, double cilindrada, double potencia, double lotacao, double peso,String cor) {
		super(condutor, cilindrada, potencia, lotacao, peso, new Carta("B"));
		this.cor = cor;
	}
	public String cor() {
		return cor;
	}

	@Override
	public String toString() {
		return "Ligeiro [cor=" + cor + "]" + super.toString();
	}
	
}
