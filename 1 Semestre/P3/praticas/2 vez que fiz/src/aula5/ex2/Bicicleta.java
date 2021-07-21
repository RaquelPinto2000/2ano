package aula5.ex2;

public class Bicicleta extends Veiculo{

	public Bicicleta(int nrodas, cor cor,String matricula) {
		super(nrodas, cor,matricula);
		// TODO Auto-generated constructor stub
	}
	
	public int ID() {
		return super.ID();
	}
	public cor cor() {
		return super.cor();
	}

	@Override
	public String toString() {
		return "Bicicleta";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
}
