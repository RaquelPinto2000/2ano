package aula3.ex2;

public class Retangulo extends Figura{
	private double lado;
	private double comprimento;
	
	public Retangulo( double xx,double yy, double lado, double comprimento) {
		super(new Ponto(xx,yy));
		this.lado = lado;
		this.comprimento = comprimento;
	}
	
	public Retangulo(Retangulo r) {
		this(r.centro().x(),r.centro().y(),r.lado(),r.comprimento());
	}
	
	public Retangulo(double lado, double comprimento) {
		this(0,0,lado,comprimento);
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
		return "Retangulo [lado=" + lado + ", comprimento=" + comprimento + ", area=" + area()
				+ ", perimetro=" + perimetro() + super.toString();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retangulo other = (Retangulo) obj;
		if (Double.doubleToLongBits(comprimento) != Double.doubleToLongBits(other.comprimento))
			return false;
		if (Double.doubleToLongBits(lado) != Double.doubleToLongBits(other.lado))
			return false;
		return true;
	}

	
}
