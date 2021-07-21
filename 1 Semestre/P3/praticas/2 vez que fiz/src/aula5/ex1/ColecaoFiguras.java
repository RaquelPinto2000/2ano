package aula5.ex1;
import java.util.*;
public class ColecaoFiguras {
	private List<Figura>fig=new ArrayList<>();
	private double areamax;
	private double areatotal;
	
	public ColecaoFiguras(double areamax) {
		this.areamax = areamax;
		areatotal=0;
	}
	public double areaTotal() {
		return areatotal;
	}
	public boolean addFigura(Figura f) {
		if(areatotal + f.area() >areamax ||exists(f)) {
			return false;
		}else {
			areatotal += f.area();
			fig.add(f);
			return true;
		}
	}
	public boolean delFigura(Figura f) {
		if(exists(f)) {
			areatotal-=f.area();
			fig.remove(f);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean exists(Figura f) {		
		return fig.contains(f);
	}
	
	public Figura[] getFiguras() {
		return fig.toArray(new Figura[0]);
	}
	public Ponto[] getCentros() {
		List<Ponto> point = new ArrayList<>();
		for (int i = 0; i < fig.size(); i++) {
			point.add(fig.get(i).centro());
		}
		return point.toArray(new Ponto[0]);
	}
	@Override
	public String toString() {
		return "Area: " + areaTotal() + "\nNumero de figuras" + fig.size() ;
	}
}
