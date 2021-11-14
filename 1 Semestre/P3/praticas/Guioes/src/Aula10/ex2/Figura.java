//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula10.ex2;

public abstract class Figura implements Comparable<Figura>{
	private Ponto c; //centro da figura
	
	public Figura(Ponto c) {
		this.c=c;
	}
	public Ponto centro() {
		return c;
	}
	
	public abstract double area();
	public abstract double perimetro();
	
	
	public int compareTo(Figura figura) {
		return (int)(this.area()-figura.area());
	}
}
