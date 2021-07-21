package aula6.ex1;

public class PratoVegetariano extends Prato{

	public PratoVegetariano(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "PratoVegetariano ";
	}
	
	
}
