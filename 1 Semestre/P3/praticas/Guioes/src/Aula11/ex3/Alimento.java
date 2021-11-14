//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula11.ex3;
public abstract class Alimento implements Comparable<Alimento> {
	
	private double proteina;
	private double calorias;
	private double peso;
	
	public Alimento(double proteina, double calorias, double peso) {
		this.peso=peso;
		this.calorias=calorias;
		this.proteina=proteina;
	}
	
	public double getProteina() {
		return proteina;
	}
	public double getCalorias() {
		return calorias;
	}
	public double getPeso() {
		return peso;
	}
	
	
	//se for <0 calorias<a.calorias
	//se for 0 calorias==a.caloris
	//se for >0 calorias>a.calorias
	@Override
	public int compareTo(Alimento a) {
		return (int) (calorias-a.calorias);
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
		temp = Double.doubleToLongBits(proteina);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(getClass() != obj.getClass()) { //getClass() determina a classe do objeto
			return false;
		}
		Alimento other = (Alimento) obj;
		
		if (Double.doubleToLongBits(calorias) != Double.doubleToLongBits(other.calorias))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (Double.doubleToLongBits(proteina) != Double.doubleToLongBits(other.proteina))
			return false;
		return true;
	}
	
	
	@Override
	public String toString () {
		return "Proteina: " + proteina+ " , Calorias: " + calorias + " , Peso: " + peso;
	}
	

}
