package aula6.ex1;
import java.util.*;
public class Prato implements Comparable<Prato> {
	private final String nome;
	private double ncalorias = 0;
	private final LinkedList<Alimento> prato;
	
	
	public Prato(String nome) {
		this.nome = nome;
		prato = new LinkedList<>();
	}
	
	public double numcalorias() {
		return ncalorias;
	}
	
	public boolean addIngrediente(Alimento a) {
		if(a==null) {
			return false;
		}else {
			prato.insert(a);
			ncalorias+=a.calorias();
			return true;
		}
	}
	
	//ncalorias > p.numcalorias() -> 1
	//ncalorias<p.numcalorias() -> -1
	//ncalorias = p.numcalorias() -> 0
	public int compareTo(Prato p) {
		if(ncalorias > p.numcalorias()) {
			return 1;
		}else if(ncalorias<p.numcalorias()) {
			return -1;
		}else {
			return 0;
		}
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(ncalorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((prato == null) ? 0 : prato.hashCode());
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
		Prato other = (Prato) obj;
		if (Double.doubleToLongBits(ncalorias) != Double.doubleToLongBits(other.ncalorias))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (prato == null) {
			if (other.prato != null)
				return false;
		} else if (!prato.equals(other.prato))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prato [nome=" + nome + ", ncalorias=" + ncalorias + ", prato=" + prato + "]";
	}

	
	
}
