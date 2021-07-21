package aula3.ex2;

public class Quadrado extends Figura{
	private double lado;
	
	public Quadrado(double lado,double xx, double yy) {
		super(new Ponto(xx,yy));
		this.lado=lado;
	}
	public Quadrado(double lado) {
		this(lado,0,0);
	}
	public Quadrado(Quadrado q) {
		this(q.lado,q.centro().x(),q.centro().y());
	}
	public double lado() {
		return lado;
	}
	public double area() {
		return lado*lado;
	}
	public double perimetro() {
		return 4*lado ;
	}
	@Override
	public String toString() {
		return "Quadrado: lado=" + lado + " area=" + area() + ", perimetro=" + perimetro() + super.toString();
	}

	
}
