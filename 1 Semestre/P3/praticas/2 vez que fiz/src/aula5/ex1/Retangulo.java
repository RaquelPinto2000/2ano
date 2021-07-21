package aula5.ex1;


public class Retangulo extends Figura{
	private double lado;
	private double comprimento;
	
	public Retangulo( double xx,double yy,double comprimento, double lado) {
		super(new Ponto(xx,yy));
		this.lado = lado;
		this.comprimento = comprimento;
	}
	public Retangulo (Ponto centro , double comprimento, double lado) {
		super(centro);
		this.lado = lado;
		this.comprimento = comprimento;
	}
	public Retangulo(Retangulo r) {
		this(r.centro(),r.comprimento(),r.lado());
	}
	
	public Retangulo(double comprimento, double lado) {
		this(0,0,comprimento,lado);
	}
	public double lado() {
		return lado;
	}
	public double comprimento() {
		return comprimento;
	}
	public double area() {
		return lado*comprimento;
	}
	public double perimetro() {
		return (lado*2)+(comprimento*2);
	}

	@Override
	public String toString() {
		return "Retangulo de comprimento " + comprimento + " de altura " + lado + " e de centro " + centro(); 
	}

	public boolean equals(Retangulo r) {
		if(comprimento == r.comprimento() && lado==r.lado()) {
			return true;
		}else {
			return false;
		}
	}
	
}
