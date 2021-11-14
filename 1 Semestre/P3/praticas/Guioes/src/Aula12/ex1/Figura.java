//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula12.ex1;

public abstract class Figura {
	private Ponto c; //centro da figura
	
	public Figura(Ponto c) {
		this.c=c;
	}
	public Ponto centro() {
		return c;
	}
	
	public abstract double area();
	public abstract double perimetro();
	
	public int compareTo(Figura f) {
		int n=0;
		if(this.area()>f.area()) {
			n = 1;
		}else if(this.area()<f.area()) {
			n=-1;
		}
		return n;
	}
}
