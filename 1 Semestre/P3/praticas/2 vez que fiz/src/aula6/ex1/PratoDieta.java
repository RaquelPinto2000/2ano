package aula6.ex1;

public class PratoDieta extends Prato{
	private final double maxcalorias;

	public PratoDieta(String nome, double maxcalorias) {
		super(nome);
		this.maxcalorias = maxcalorias;
	}

	public double maxcaloria() {
		return maxcalorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(maxcalorias);
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
		PratoDieta other = (PratoDieta) obj;
		if (Double.doubleToLongBits(maxcalorias) != Double.doubleToLongBits(other.maxcalorias))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PratoDieta [maxcalorias=" + maxcalorias + "]";
	}
	
	
	
}
