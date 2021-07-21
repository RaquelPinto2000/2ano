package aula3.ex3;

public class Motociclo extends Veiculo{
	private boolean reboque;
	// Carta A

	public Motociclo(Condutor condutor, double cilindrada, double potencia, double lotacao, double peso, boolean reboque) {
		super(condutor, cilindrada, potencia, lotacao, peso, new Carta("A"));
		this.reboque = reboque;
	}
	
	public boolean reboque() {
		return reboque;
	}

	@Override
	public String toString() {
		return "Motociclo [reboque=" + reboque + "]" + super.toString();
	}
	
}
