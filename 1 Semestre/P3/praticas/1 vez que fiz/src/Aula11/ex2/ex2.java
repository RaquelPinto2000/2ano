//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula11.ex2;
import java.util.*;
import java.io.*;
public class ex2 {

	public static void main(String[] args) throws IOException{
		
		List<Figura> list = new ArrayList<>();
		list.add(new Quadrado(2));
		list.add(new Quadrado(3));
		list.add(new Quadrado(9));	//Maior figura
		list.add(new Rectangulo(1,81));
		list.add(new Rectangulo(5,1));
		list.add(new Quadrado(1));
		list.add(new Quadrado(2));
		list.add(new Quadrado(2));	//Maior figura
		list.add(new Rectangulo(1,1));
		list.add(new Rectangulo(1,1));
		System.out.println("Maior figura: "+maiorFiguraJ7(list));
		System.out.println("Maior perimetro: "+maiorPerimetroJ7(list));
		System.out.println("Soma total das areas: "+areaTotalJ8(list));
		System.out.println("Soma total das areas dos quadrados: "+areaTotalJ8(list,"Quadrado"));
		
		
	
	}
	
	private static Figura maiorFiguraJ7(List<Figura> figs) {
		//Figura maior = figs.get(0);
		//for (Figura f : figs) {
		//if (f.compareTo(maior) >= 1)
		//maior = f;
		//}
		//return maior;
		return (Figura)figs.stream().max(new Comparator <Figura>() {
			@Override
			public int compare(Figura args0, Figura args1) {
				return args0.compareTo(args1);
			}
		}).get();
	}
	
	private static Figura maiorPerimetroJ7(List<Figura> figs) {
		return (Figura)figs.stream().max(new Comparator <Figura>() {
			@Override
			public int compare(Figura args0, Figura args1) {
				
				double perimetro= args0.perimetro()-args1.perimetro();
				if(perimetro>0) {
					return 1;
				}else if(perimetro<0) {
					return -1;
				}else {
					return 0;
				}
			}
		}).get();
	}
	
	
	private static double areaTotalJ8(List<Figura> figs) {
		return figs.stream().mapToDouble(x -> x.area()).sum();
		
	}
	
	private static double areaTotalJ8(List<Figura> figs, String s) throws IOException{
		return figs.stream().filter(x->x.getClass().getSimpleName().equals(s)).mapToDouble(x->x.area()).sum();
		
	}

}
