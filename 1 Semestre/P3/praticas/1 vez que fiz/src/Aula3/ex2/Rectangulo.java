//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula3.ex2;

public class Rectangulo extends Figura{
	private double comp;
	private double lar;

	public Rectangulo (double x, double y, double lar, double comp) {
		super(new Ponto(x,y));
		this.comp = comp;
		this.lar=lar;
	}
	
	public Rectangulo (double lar,double comp) {
		super(new Ponto());
		this.comp = comp;
		this.lar=lar;
	}
	
	public Rectangulo(Ponto p, double c,double l) {
		super(p);
		comp=c;
		lar=l;
	}
	
	public Rectangulo (Rectangulo r) {
		this(r.centro(),r.comp(),r.lar());
		
	}
	
	public double comp() {
		return comp;
	}
	public double lar() {
		return lar;
	}
	public Ponto centro() {
		return super.centro();
	}
	
	public double area(){
		return comp*lar;	
	}
	
	public double perimetro() {
		return (comp*2) + (lar * 2);
	}
	
	//Dados todos numa String
	public String toString() {
		return "Retangulo de comprimento " + comp + " de largura " + lar + " e de centro " + centro(); 
	}
	
	public boolean equals(Rectangulo r) {
		if(comp == r.comp() && lar==r.lar() && r.centro() == centro() && r.area()==area() && r.perimetro()==perimetro()) {
			return true;
		}else {
			return false;
		}
	}
}
