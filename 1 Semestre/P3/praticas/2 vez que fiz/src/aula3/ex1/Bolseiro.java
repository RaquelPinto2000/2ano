package aula3.ex1;

public class Bolseiro extends Estudante{
	private int montante =0;

	public Bolseiro(String nome,int cc, Data dataNasc) {
		super(nome, cc, dataNasc);
	}
	public void setBolsa(int valor) {
		montante = valor;
	}
	
	public int getBolsa() {
		return montante;
	}
	
	@Override
	public String toString() {
		return super.toString()+", Bolsa: " + montante;
	}
	
	
}