//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula11.ex1;

public class Quadrado extends Rectangulo {
		
	public Quadrado(double x, double y,double comp) {
		super(new Ponto(x,y),comp,comp);
	}
	public Quadrado(double comp) {
		super(new Ponto(),comp,comp);
	}
	public Quadrado(Ponto p,double c) {
		super(p,c,c);
	}
	public Quadrado(Quadrado q) {
		this (q.centro(),q.comp());
	}
	
	
	public double comp() {
		return super.comp();
	}
	public double lado() {
		return super.comp();
	}
	
	public double area(){
		return comp()*comp();
	}
	
	public double perimetro() {
		return comp()*4;
	}
	
	//Dados todos numa String
	public String toString() {
		return "Quadrado de lado " + comp() + " e de centro " + centro(); 
	}
	public boolean equals(Quadrado q) {
		if(comp() == q.comp() && q.centro() == centro()) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
