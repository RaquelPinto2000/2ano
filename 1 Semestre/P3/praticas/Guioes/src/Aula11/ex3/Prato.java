//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula11.ex3;
import java.util.LinkedList;
public class Prato implements Comparable<Prato>{
	
	private final String nome;
	private double ncaloria=0; //total das calorias
	private final LinkedList<Alimento> composicao;
	
	public Prato(String nome) {
		this.nome=nome;
		composicao = new LinkedList<>();
	}
	
	//insere um alimento
	//retorna true se inseriu e false se nao
	public boolean addIngrediente(Alimento a) {
		if(a==null) {
			return false;
		}
		composicao.add(a);
		ncaloria += a.getCalorias();
		return true;
	}
	
	
	public boolean exists(Alimento a) {
		return composicao.contains(a);
	}
	
	public String getNome() {
		return nome;
	}
	
	public Alimento[] getAlimentos() {
		return composicao.toArray(new Alimento[0]);
	}
	public double getTotalCalorias() {
		return ncaloria;
	}
	
	public int getNumIngredientes() {
		return composicao.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(ncaloria);
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
		Prato other = (Prato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(ncaloria) != Double.doubleToLongBits(other.ncaloria))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Prato de nome:  " + nome + "composto por " + getNumIngredientes();
	}
	
	
	@Override
	public int compareTo(Prato prato2) {
		return (int)(ncaloria-prato2.ncaloria);
}
		
	
	
}
