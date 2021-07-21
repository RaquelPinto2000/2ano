package aula3.ex3;

public class Carta {
	private String tipo;

	public Carta(String tipo) {
		this.tipo = tipo;
	}
	
	public String carta() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Carta [tipo=" + tipo + "]";
	}
	
	
}
