//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula6.ex2;

import java.util.*;
import java.util.function.*;

public class ListsProcess {
	
	public static <T>List <T> filter (List<T>lista, Predicate<T> tester){
		List<T> aux = new ArrayList<T>();
		
		for (T t : lista) {
			if (tester.test(t)) {
				aux.add(t);
			}
		}
		return aux;
	}
}
