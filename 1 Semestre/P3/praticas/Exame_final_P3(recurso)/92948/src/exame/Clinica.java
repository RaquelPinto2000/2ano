package exame;
import java.util.*;

public class Clinica {
	private String nome;
	private TreeSet <Mobiliario> mobiliario = new TreeSet<Mobiliario>();
	
	public Clinica(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public boolean addMobiliario(Mobiliario m) {
		return mobiliario.add(m);
	}
	
	public boolean removeMobiliario(Mobiliario m) {
		if(mobiliario.contains(m)) {
			mobiliario.remove(m);
			return true;
		}else {
			return false;
		}
	}
	public List listTransportes() {
		Mobiliario [] mov = mobiliario.toArray(new Mobiliario[0]);
		List <Mobiliario> list = new ArrayList<>();
		for (int i = 0; i < mov.length; i++) {
			list.add(mov[i]);
		}
		return list;
	}
	
	public Iterator rangeIterator(int i, int j) {
		return mobiliario.iterator();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mobiliario == null) ? 0 : mobiliario.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Clinica other = (Clinica) obj;
		if (mobiliario == null) {
			if (other.mobiliario != null)
				return false;
		} else if (!mobiliario.equals(other.mobiliario))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
