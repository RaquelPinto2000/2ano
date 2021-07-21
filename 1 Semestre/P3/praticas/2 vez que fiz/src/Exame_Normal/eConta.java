package Exame_Normal;

public class eConta extends Conta implements Eletronica{

	public eConta(Cliente c) {
		super(c);
		if(c.getTipo()!= TipoCliente.Online) {
			throw new RuntimeException("Uma eConta tem de ser online");
		}
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
