package aula5.ex2;

public class BicicletaPolicia extends Bicicleta implements Policia{
	private associacao tipo;
	
	public BicicletaPolicia(int nrodas, cor cor, associacao tipo, String matricula) {
		super(nrodas, cor, matricula);
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
		BicicletaPolicia other = (BicicletaPolicia) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	
}
