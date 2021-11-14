//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex1;

public abstract class Figura implements Comparable<Figura> {
	private Ponto c; //centro da figura
	
	public Figura(Ponto c) {
		this.c=c;
	}
	public Ponto centro() {
		return c;
	}
	
	public abstract double area();
	public abstract double perimetro();
	
	// se this.area()<fig.area() retorna <0
	// se this.area()==fig.area() retorna 0
	// se this.area()>fig.area() retorna >0
	public int compareTo(Figura fig) {
		if(this.area()<fig.area()) {
			return -1;
		}else if(this.area()==fig.area()) {
			return 0;
		}else{
			return 1;
		}
	}
}
