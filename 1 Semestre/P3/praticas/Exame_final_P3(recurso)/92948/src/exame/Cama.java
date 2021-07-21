package exame;

public class Cama extends Mobiliario{
	private double comp;
	private double lar;
	private boolean colchao;
	
	public Cama(String nome, int id, Tipo material, double comp, double lar, boolean colchao) {
		super(nome, id, material);
		this.comp = comp;
		this.lar = lar;
		this.colchao = colchao;
	}
	public boolean Colchao() {
		return colchao;
	}
	
	public double getComprimento() {
		return comp;
	}
	public double getLargura() {
		return lar;
	}
	
	@Override
	public String toString() {
		return "Cama [comp=" + comp + ", lar=" + lar + ", colchao=" + colchao + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (colchao ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(comp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lar);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Cama other = (Cama) obj;
		if (colchao != other.colchao)
			return false;
		if (Double.doubleToLongBits(comp) != Double.doubleToLongBits(other.comp))
			return false;
		if (Double.doubleToLongBits(lar) != Double.doubleToLongBits(other.lar))
			return false;
		return true;
	}
	
	
}
