package aula5.ex2;

public class Motorizado extends Veiculo{
	private int potencia;
	private int c; //cilindrada
	private int vmax; //velocidade maxima
	private String matricula;
	
	
	
	public Motorizado(int nrodas, cor cor, int potencia, int c, int vmax, String matricula) {
		super(nrodas, cor,matricula);
		this.potencia = potencia;
		this.c = c;
		this.vmax = vmax;
		this.matricula = matricula;
	}


	public int getCilindrada() {
		return c;
	}
	public int vMax() {
		return vmax;
	}
	public int getPotencia() {
		return potencia;
	}


	@Override
	public String toString() {
		return "Motorizado [potencia=" + potencia + ", c=" + c + ", vmax=" + vmax + ", matricula=" + matricula + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + c;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + potencia;
		result = prime * result + vmax;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motorizado other = (Motorizado) obj;
		if (c != other.c)
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (potencia != other.potencia)
			return false;
		if (vmax != other.vmax)
			return false;
		return true;
	}
	
	
}
