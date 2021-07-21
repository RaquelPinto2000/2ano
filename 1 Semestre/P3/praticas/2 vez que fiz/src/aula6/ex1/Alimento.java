package aula6.ex1;

public abstract class Alimento implements Comparable<Alimento> {  // o Comparable e para termos o compareTo
	private double calorias;
	private double proteinas;
	private double peso;
	
	public Alimento(double proteinas, double calorias, double peso) {
		this.calorias = calorias;
		this.proteinas = proteinas;
		this.peso = peso;
	}

	public double calorias() {
		return calorias;
	}
	
	public double proteinas() {
		return proteinas;
	}
	public double peso() {
		return peso;
	}
	
	//se calorias<a.calorias() -> -1
	// se calorias > a.calorias() -> 1
	// se calorias = a.calorias() -> 0
	public int compareTo(Alimento a) {
		if(calorias<a.calorias()) {
			return -1;
		}else if(calorias>a.calorias()) {
			return 1;
		}else {
			return 0;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(proteinas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		if (Double.doubleToLongBits(calorias) != Double.doubleToLongBits(other.calorias))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (Double.doubleToLongBits(proteinas) != Double.doubleToLongBits(other.proteinas))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Alimento [calorias=" + calorias + ", proteinas=" + proteinas + ", peso=" + peso + "]";
	}

	
}