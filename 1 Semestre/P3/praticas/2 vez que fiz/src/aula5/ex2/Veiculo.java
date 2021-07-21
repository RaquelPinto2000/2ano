package aula5.ex2;

public class Veiculo {
	private static int idvaiculo=1;
	private int ID;
	private int nrodas;
	private cor cor;
	private String matricula;
	
	public Veiculo(int nrodas, cor cor, String matricula) {
		this.matricula=matricula;
		this.nrodas = nrodas;
		this.cor = cor;
		ID = idvaiculo++;
	}

	public String matricula() {
		return matricula;
	}
	public int numRodas () {
		return nrodas;
	}
	
	public cor cor() {
		return cor;
	}
	public int ID() {
		return ID;
	}


	@Override
	public String toString() {
		return "Veiculo [ID=" + ID + ", nrodas=" + nrodas + ", cor=" + cor + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + nrodas;
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
		Veiculo other = (Veiculo) obj;
		if (ID != other.ID)
			return false;
		if (cor != other.cor)
			return false;
		if (nrodas != other.nrodas)
			return false;
		return true;
	}
	
	
}
