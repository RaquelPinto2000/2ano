//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula11.ex3;

public enum DiaSemana {
	SEGUNDA(0), TERÇA(1), QUARTA(2), QUINTA(3), SEXTA(4), SÁBADO(5), DOMINGO(6);
	
	private int dia;
	
	private DiaSemana(int i){
		dia = i;
	}
	
	public int getDay()	{
		return this.dia;
	}
	

	public static DiaSemana rand() {
		int rand = (int)(Math.random()*6);
		DiaSemana value = null;
		for(DiaSemana dia : DiaSemana.values()) {
			if(dia.getDay() == rand) value = dia;
		}
		return value;
	}
	
	public static DiaSemana enumDay(int n) {
		DiaSemana var = null;
		for(DiaSemana v : DiaSemana.values()) {
			if(v.getDay() == n) {
				return v;
			}
		}
		return var;
}
}
