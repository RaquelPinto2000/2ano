package aula5.ex1;

public class UtilCompare {

	public static Comparable findMax(Comparable[] c) {
		int max=0; // indice do valor maximo
		for (int i = 0; i < c.length; i++) {
			if(c[i]!=null && c[i].compareTo(c[max])>0) { // que dizer que o c[i] > c[max]
				max = i;
			}
		}
		
		return c[max];
	}
	
	//ordenar array
	public static void sortArray(Comparable[]c) {
		for (int i = 0; i < c.length; i++) {
			for (int j = i; j < c.length; j++) {
				if(c[i].compareTo(c[j])>0) { // se c[i]>c[j] eles trocam
					Comparable aux = c[i];
					c[i]=c[j];
					c[j] = aux;
				}
			}
		}		
	}
}
