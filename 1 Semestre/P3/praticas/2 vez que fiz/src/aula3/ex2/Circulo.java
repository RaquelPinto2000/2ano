package aula3.ex2;



public class Circulo extends Figura {
	private double raio;
	
	public Circulo(double x, double y, double r) {
		super(new Ponto(x,y));
		raio=r;
	}
	public Circulo(Ponto centro, double r) {
		this(centro.x(),centro.y(),r);
	}
	public Circulo(Circulo c) {
		this(c.centro().x(),c.centro().y(),c.raio());
	}
	public Circulo(double r) {
		this(0,0,r);
	}
	public double raio() {
		return raio;
	}
	public double area() {
		return Math.PI *Math.pow(raio, 2);
	}
	public double perimetro() {
		return  2*Math.PI * raio;
	}
	
	@Override
	public String toString() {
		return "circulo de " +  "raio: " + raio + " e de centro: " + super.centro(); 
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circulo other = (Circulo) obj;
		if (Double.doubleToLongBits(raio) != Double.doubleToLongBits(other.raio))
			return false;
		return true;
	}
	public boolean circulosintercetam (Circulo c) {
		//Se a distancia entre os centros dos circulos for menos ou igual a soma dos dois raios, 
		//entao e porque se intercetaom
		double soma= raio + c.raio();
		if(super.centro().distTo(c.centro()) <= soma) {
			return true;
		}else {
			return false;
		}

	}
	
}
