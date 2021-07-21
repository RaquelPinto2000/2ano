package aula7.ex1;

public class Companhia {
	private String nome;
	private String sigla;

	public Companhia(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public String nome() {
		return nome;
	}
	
	public String sigla() {
		return sigla;
	}

	@Override
	public String toString() {
		return sigla + " " + nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
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
		Companhia other = (Companhia) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}
}
