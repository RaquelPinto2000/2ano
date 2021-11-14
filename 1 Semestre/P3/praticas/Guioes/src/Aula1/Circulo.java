package Aula1;

public class Circulo {
	private double raio;
	private Ponto centro;
	private double perimetro;
	private double area;
	
	public Circulo(double x, double y, double r) {
		centro=new Ponto(x,y);
		raio=r;
		area = Math.PI * Math.pow(r, 2); //calculo da area
		perimetro = 2 * Math.PI * r;     //calculo do perimetro
	}
	public Circulo(Ponto centro, double r) {
		this.centro = centro;
		raio=r;
		area = Math.PI* Math.pow(r, 2); //calculo da area
		perimetro = 2* Math.PI * r;     //calculo do perimetro
		
	}
	
	public double raio() {
		return raio;
	}
	public Ponto centro() {
		return centro;
	}
	
	public Double perimetro() {
		return perimetro;
	}
	
	public Double area() {
		return area;
	}
	
	//Dados todos numa String
	public String toString() {
		return "circulo de " +  "raio: " + raio + " e de centro: " + centro; 
	}
	
	//verificar se 2 circulos sao iguais
	public boolean circurosiguais(Circulo c) {
		if(c.raio() == raio) {
			return true;
		}else {
			return false;
		}
	}
	
	//verificar se 2 circulos se intercetam
	public boolean circulosintercetam (Circulo c) {
		//Se a distancia entre os centros dos circulos for menos ou igual a soma dos dois raios, 
		//entao e porque se intercetaom
		double soma= raio + c.raio();
		if(centro.distTo(c.centro()) <= soma) {
			return true;
		}else {
			return false;
		}

	}
	
	
}
