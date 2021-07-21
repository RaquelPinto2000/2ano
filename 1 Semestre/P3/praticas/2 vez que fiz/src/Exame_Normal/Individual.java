package Exame_Normal;

public class Individual extends Cliente{
	
	private String number; //numero de telefone

	public Individual(String nome, String bI, TipoCliente tipo, String number) {
		super(nome, bI, tipo);
		this.number = number;
	}
	public Individual(String nome, String bI, TipoCliente tipo) {
		super(nome, bI, tipo);
		number = "0" ;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String n) {
		number = n;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		Individual other = (Individual) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	
	
}
