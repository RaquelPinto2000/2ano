package exame;

public class Mobiliario implements Comparable<Mobiliario>{
	private String nome;
	private int id;
	private Tipo material;
	
	public Mobiliario(String nome, int id, Tipo material) {
		this.nome = nome;
		this.id = id;
		this.material = material;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getID() {
		return id;
	}
	public Tipo getMaterial() {
		return material;
	}

	@Override
	public String toString() {
		return "mobiliario = [>>Mobiliario: " + nome + ", com ID=" + id + " feito em " + material + "]";
	}
	
	public int compareTo(Mobiliario b) {
		if(id<b.getID()) {
			return -1;
		}else if(id>b.getID()) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((material == null) ? 0 : material.hashCode());
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
		Mobiliario other = (Mobiliario) obj;
		if (id != other.id)
			return false;
		if (material != other.material)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}	
}
