package aula6.ex1;

public enum DiaSemana {
	segunda(0), terca(1),quarta(2), quinta(3), sexta(4), sabado(5), domingo(6);
	
	private int index;
	private DiaSemana(int i) {
		index=i;
	}

	private int getDay() {
		return this.index;
	}
	public static DiaSemana rand() {
		int rand = (int) (Math.random() *6); // vai de 0 a 6
		DiaSemana value = null;
		DiaSemana dia[] = DiaSemana.values();
		for (int i = 0; i<dia.length; i++) {
			DiaSemana day = dia[i];
			if(day.getDay() == rand) {
				value = day;
			}
		}
		return value;
	}
}
