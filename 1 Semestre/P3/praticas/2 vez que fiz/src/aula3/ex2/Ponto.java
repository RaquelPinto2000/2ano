package aula3.ex2;

public class Ponto {
	private double x;
	private double y;
	
	
	public Ponto( double x, double y) {
		this.x=x;
		this.y=y;
	}

	public double x() {
		return x;
	}
	public double y() {
		return y;
	}
	  
	//calcula distancia entre 2 pontos
	public double distTo(Ponto p) {
	    return Math.sqrt(Math.pow(this.x-p.x,2)+Math.pow(this.y-p.y,2));
	 }
	
	//Dados todos numa String
	public String toString(){ 
		return "("+x+","+y+")"; 
	}
}
