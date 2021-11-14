//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula3.ex2;

public class Quadrado extends Figura {
	private double comp;
	
	public Quadrado(double x, double y,double comp) {
		super(new Ponto(x,y));
		this.comp = comp;
	}
	public Quadrado(double comp) {
		super(new Ponto());
		this.comp = comp;
	}
	public Quadrado(Ponto p,double c) {
		super(p);
		comp = c;
	}
	public Quadrado(Quadrado q) {
		this (q.centro(),q.comp());
	}
	
	
	public double comp() {
		return comp;
	}
	public Ponto centro() {
		return super.centro();
	}
	public double area(){
		return comp*comp;
	}
	
	public double perimetro() {
		return comp*4;
	}
	
	//Dados todos numa String
	public String toString() {
		return "Quadrado de comprimento " + comp + " e de centro " + centro(); 
	}
	public boolean equals(Quadrado q) {
		if(comp == q.comp() && q.centro() == centro() && q.area()==area() && q.perimetro()==perimetro()) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
