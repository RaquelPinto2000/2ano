package aula6.ex2;

public abstract class Figura implements Comparable<Figura>{
	private Ponto centro;
	public Figura(Ponto centro) {
		this.centro=centro;
	}
	
	public Ponto centro() {
		return centro;
	}

	@Override
	public String toString() {
		return "Figura [centro=" + centro + "]";
	}
	public abstract double area();
	public abstract double perimetro();
	
	// se area da figura f < area da nossa figura (this) return >0
	// se area da figura f > area da nossa figura (this) return <0
	// se area da figura f = area da nossa figura (this) return =0
	public int compareTo(Figura f) {
		if(this.area()>f.area()) {
			return 1;
		}else if(this.area()<f.area()) {
			return -1;
		}else {
			return 0;
		}
	}
}
