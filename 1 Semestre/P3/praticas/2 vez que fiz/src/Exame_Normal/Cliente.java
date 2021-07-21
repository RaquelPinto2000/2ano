package Exame_Normal;

public class Cliente {
	private String nome;
	private String BI;
	private TipoCliente tipo;
	
	public Cliente(String nome, String bI, TipoCliente tipo) {
		this.nome = nome;
		BI = bI;
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getBI() {
		return BI;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BI == null) ? 0 : BI.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Cliente other = (Cliente) obj;
		if (BI == null) {
			if (other.BI != null)
				return false;
		} else if (!BI.equals(other.BI))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	
	
}
