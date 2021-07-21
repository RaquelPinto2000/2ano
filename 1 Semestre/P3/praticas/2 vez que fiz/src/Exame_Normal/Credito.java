package Exame_Normal;

public class Credito extends Movimento{

	public Credito(double valor, String data) {
		super(valor,data);
	}

	@Override
	public String toString() {
		return "Credito >[amount="+ super.getMontante() + ",data=" + super.getData()+"]";
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
