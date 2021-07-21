package aula3.ex3;

public class Veiculo {
	private Condutor condutor;
	private double cilindrada;
	private double lotacao;
	private Carta tipo;
	private double peso;
	private double potencia;
		
	public Veiculo(Condutor condutor, double cilindrada, double potencia, double lotacao, double peso, Carta tipo) {
		this.condutor = condutor;
		this.cilindrada = cilindrada;
		this.lotacao = lotacao;
		this.tipo = tipo;
		this.peso = peso;
		this.potencia=potencia;
	}


	public Condutor condutor() {
		return condutor;
	}
	public double cilindrada() {
		return cilindrada;
	}
	public double lotacao() {
		return lotacao;
	}
	public Carta tipo() {
		return tipo;
	}
	public double peso() {
		return peso;
	}
	public double potencia() {
		return potencia;
	}
	@Override
	public String toString() {
		return "Veiculo [condutor=" + condutor + ", cilindrada=" + cilindrada + ", lotacao=" + lotacao + ", tipo="
				+ tipo + ", peso=" + peso + ", potencia=" + potencia + "]";
	}

	
	
}
