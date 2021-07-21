package aula5.ex2;

public class CarroPolicia extends automovel implements Policia{
	private associacao tipo;

	public CarroPolicia(int nrodas, cor cor, int potencia, int c, int vmax, String matricula, associacao tipo) {
		super(nrodas, cor, potencia, c, vmax, matricula);
		this.tipo=tipo;
		// TODO Auto-generated constructor stub
	}
	
	public int ID() {
		return super.ID();
	}
	public cor cor() {
		return super.cor();
	}
	public associacao getTipo() {
		return tipo;
	}
	
	public String getId() {
		return "" + super.ID();
	}

	@Override
	public String toString() {
		return "CarroPolicia";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		CarroPolicia other = (CarroPolicia) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
}
