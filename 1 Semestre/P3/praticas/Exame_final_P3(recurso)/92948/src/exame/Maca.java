package exame;

public class Maca extends Marquesa implements Transporte{
	private int grades;

	public Maca(String nome, int id, Tipo material, double comp, double lar, boolean colchao,
			int grades) {
		super(nome, id, material, comp, lar, colchao, false);
		this.grades = grades;
	}
	
	public TipoTransporte getTipo() {
		return TipoTransporte.Urgente;
	}
	public TipoTransporte setTipo(TipoTransporte tipo) {
		return tipo;
	}
}
