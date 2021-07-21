package exame;

public class Marquesa extends Cama {
	private boolean inclinacao;

	public Marquesa(String nome, int id, Tipo material, double comp, double lar, boolean colchao, boolean inclinacao) {
		super(nome, id, material, comp, lar, colchao);
		this.inclinacao = inclinacao;
	}
	
	public boolean getInclinacao() {
		return inclinacao;
	}
//ver
	@Override
	public String toString() {
		return "Marquesa [inclinacao=" + inclinacao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (inclinacao ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marquesa other = (Marquesa) obj;
		if (inclinacao != other.inclinacao)
			return false;
		return true;
	}
	
}
