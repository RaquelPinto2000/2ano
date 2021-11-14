//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula6.ex1;

public class PratoVegetariano extends Prato {

	public PratoVegetariano(String nome) {
		super(nome);
	}

	@Override
	public boolean addIngrediente(Alimento alimento) {
		if(alimento == null) return false;
		if(alimento instanceof AlimentoVegetariano) {
			return super.addIngrediente(alimento);
		}
		return false;
}

}
