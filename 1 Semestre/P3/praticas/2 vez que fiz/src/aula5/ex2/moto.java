package aula5.ex2;

public class moto extends Motorizado{

	public moto(int nrodas, cor cor, int potencia, int c, int vmax, String matricula) {
		super(nrodas, cor, potencia, c, vmax, matricula);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "moto ";
	}
	public int ID() {
		return super.ID();
	}
	public cor cor() {
		return super.cor();
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
