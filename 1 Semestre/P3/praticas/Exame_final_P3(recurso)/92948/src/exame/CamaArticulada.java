package exame;

public class CamaArticulada extends Cama{
	private TipoCama tipo;

	public CamaArticulada(String nome, int id, Tipo material, double comp, double lar, boolean colchao,
			boolean eletrica) {
		super(nome, id, material, comp, lar, colchao);
		if(eletrica) {
			tipo = TipoCama.eletrica;
		}else {
			tipo = TipoCama.manual;
		}
	}
	public TipoCama getTipo() {
		return tipo;
	}
	@Override
	public String toString() {
		return "Cama" + super.toString() + ", articulada do tipo " + tipo ;
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
		CamaArticulada other = (CamaArticulada) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	
	
	
}
