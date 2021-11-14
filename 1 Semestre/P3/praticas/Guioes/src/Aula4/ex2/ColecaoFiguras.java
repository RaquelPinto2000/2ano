//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula4.ex2;

import java.util.ArrayList;
import java.util.List;

public class ColecaoFiguras {
	
	private List<Figura> fig=new ArrayList<>();;
	private double areamax;
	private double areatotal;
	
	public ColecaoFiguras(double areamax) {
		this.areamax=areamax; 
		areatotal=0;
	}
	
	public boolean addFigura(Figura f) {
		if((areatotal + f.area()) >areamax || exists(f)) {
			return false;
		}else {
			areatotal+=f.area();
			fig.add(f);
			return true;
		}
	}
	
	public boolean delFigura(Figura f) {
		if(exists(f)) {
			areatotal -= f.area();
			fig.remove(f);
			return true;
		}else {
			return false;
		}
	}
	
	public double areaTotal() {
		return areatotal;
	}
	
	public boolean exists(Figura f) {
		return fig.contains(f);
	}
	
	public String toString() {
		return "Area: " + areaTotal() + "\nNumero de figuras" + fig.size() ;
	}
	
	public Figura[] getFiguras() {
		return fig.toArray(new Figura[0]);
	}
	
	public Ponto[] getCentros() {
		List<Ponto> aux = new ArrayList<>();
		for(int i = 0;i<fig.size();i++) {
				aux.add(fig.get(i).centro());
		}
		return aux.toArray(new Ponto [0]);		
	}
	
	
}
