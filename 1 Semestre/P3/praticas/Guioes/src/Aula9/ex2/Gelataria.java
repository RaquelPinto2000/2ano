//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula9.ex2;
import static java.lang.System.*;
public class Gelataria {
	public static void main(String args[]) {
		Gelado ice;
		ice = new GeladoSimples("Baunilha");
		ice.base(2);
		out.println();
		new Copo(ice).base(3);
		out.println();
		new Cone(ice).base(1);
		out.println();
		new Topping(ice, "Canela").base(2);
		out.println();
		ice = new Topping(ice, "Nozes");
		ice.base(1);
		ice = new Topping(new Cone(new GeladoSimples("Morango")), "Fruta");
		out.println();
		ice.base(2);
		out.println();
		ice = new Topping(new Topping(new Copo(new GeladoSimples("Manga")), "Chocolate"), "Natas");
		ice.base(4);
		out.println();
		ice = new Topping(ice, "Pepitas");
		ice.base(3);
}
}