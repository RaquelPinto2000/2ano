package aula7.ex1;

public class Voo {
	private String nome;
	private String origem;
	private Hora hpartida;
	private Hora atraso;
	private Companhia comp;
	
	public Voo(String origem, Hora hora, String nome, Hora atraso, Companhia comp) {
		this.origem = origem;
		hpartida = hora;
		this.nome=nome;
		this.atraso = atraso;
		this.comp = comp;
	}
	
	public String origem() {
		return origem;
	}
	
	public Hora hora() {
		return hpartida;
	}
	
	public Hora Atraso() {
		return atraso;
	}
	public int atrasomin() {
		return atraso.getTotalMinutos();
	}
	public Companhia comp() {
		return comp;
	}
	
	public String nome() {
		return nome;
	}
	
	public String toString() {
		return String.format("%s\t%-10s\t%-18s\t%-20s\t%-5s\t%s",  hpartida.toString(), nome.toString(),
				comp.toString(), origem.toString(),	Hora.isHourZero(atraso) ? "" : atraso.toString(),
				Hora.isHourZero(atraso) ? "" : "Previsto: "+Hora.horaPrevista(hpartida,atraso).toString());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atraso == null) ? 0 : atraso.hashCode());
		result = prime * result + ((comp == null) ? 0 : comp.hashCode());
		result = prime * result + ((hpartida == null) ? 0 : hpartida.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
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
		Voo other = (Voo) obj;
		if (atraso == null) {
			if (other.atraso != null)
				return false;
		} else if (!atraso.equals(other.atraso))
			return false;
		if (comp == null) {
			if (other.comp != null)
				return false;
		} else if (!comp.equals(other.comp))
			return false;
		if (hpartida == null) {
			if (other.hpartida != null)
				return false;
		} else if (!hpartida.equals(other.hpartida))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		return true;
	}
}
