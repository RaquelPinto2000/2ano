//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex1;

public class UtilCompare {
	
	@SuppressWarnings("unchecked")
	public static Comparable findMax(Comparable[] c) {
		int max = 0;
		for(int i=0;i<c.length;i++) {
			if(c[i] != null && (c[i].compareTo(c[max])>0)) {
				max=i;
			}
		}
		return c[max];
	}
	
	
	@SuppressWarnings("unchecked")
	public static void sortArray(Comparable[] c) {
		for(int i =0;i<c.length;i++) {
			for(int j=0;j<c.length-1;j++) {
				if(c[j].compareTo(c[j+1])>0) {
					Comparable aux = c[j];
					c[j]=c[j+1];
					c[j+1]=aux;
				}
			}
		}
	}
}