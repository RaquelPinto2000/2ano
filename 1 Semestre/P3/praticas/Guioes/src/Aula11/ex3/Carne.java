//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula11.ex3;

public class Carne extends Alimento{

	private VariedadeCarne variedade;
	public Carne(VariedadeCarne variedade, double proteina, double calorias, double peso) {
		super(proteina, calorias, peso);
		this.variedade=variedade;
	}
	
	public VariedadeCarne getVariedade() {
		return variedade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result= prime*result+ ((variedade==null) ? 0 : variedade.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(getClass() != obj.getClass()) { //getClass() determina a classe do objeto
			return false;
		}
		Carne other = (Carne) obj;
		
		if(variedade!=other.variedade) {
			return false;
		}
		return true;
	}
	
	
	@Override
	public String toString () {
		return "Carne " + variedade + " , " + super.toString();
	}
		
}
