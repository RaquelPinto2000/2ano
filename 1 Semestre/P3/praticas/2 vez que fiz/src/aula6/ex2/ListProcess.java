package aula6.ex2;
import java.util.*;
import java.util.function.*;
public class ListProcess {

	public static <T>List<T> filter(List<T>lista, Predicate <T> test ) {
		List<T>aux = new ArrayList<T>();
		for (int i = 0; i < lista.size(); i++) {
			T t = lista.get(i);
			if(test.test(t)) {
				aux.add(lista.get(i));
			}
		}
		
		return aux;
	}
	
}
