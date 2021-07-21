package aula6.ex2;

public class Quadrado extends Retangulo{
	
	public Quadrado(double xx, double yy,double lado) {
		super(new Ponto(xx,yy),lado,lado);
	}
	public Quadrado(double lado) {
		this(0,0,lado);
	}
	public Quadrado (Ponto p,double lado) {
		super(p,lado,lado);
	}
	public Quadrado(Quadrado q) {
		this(q.centro(),q.lado());
	}
	public double lado() {
		return super.lado();
	}
	public double area() {
		return lado()*lado();
	}
	public double perimetro() {
		return 4*lado() ;
	}
	@Override
	//Dados todos numa String
	public String toString() {
		return "Quadrado de lado " + lado() + " e de centro " + centro(); 
	}

	
}
