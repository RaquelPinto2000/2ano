//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula11.ex1;

import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public abstract class TestGeneric {
	public static void main(String[] args) throws IOException{
		List <Pessoa> vp = new ArrayList<Pessoa>();
		for (int i=0; i<10; i++) {
			vp.add(new Pessoa("Bebé no Vector "+i,1000+i, Data.today()));
		}
		Iterator<Pessoa> vec = vp.iterator();
		printSet(vp.iterator());
		List<Pessoa> lp = new LinkedList<Pessoa>();
		while (vec.hasNext()) {
			lp.add(vec.next());
		}
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() ) {
			System.out.println( lista.next() );
		}
		List <Figura> figList = new LinkedList<Figura>();
		figList.add(new Circulo (1,3, 1));
		figList.add(new Quadrado(3,4, 2));
		figList.add(new Rectangulo(1,2, 2,5));
		printSet(figList.iterator());
		System.out.println("Soma da Area de Lista de Figuras: " +sumArea(figList));
		// Partindo do principio que Quadrado extends Rectangulo:
		List< Rectangulo > quadList =new LinkedList<Rectangulo>();
		quadList.add(new Quadrado(3,4, 2));
		quadList.add(new Rectangulo(1,2, 2,5));
		System.out.println("Soma da Area de Lista de Quadrados: " +	sumArea(quadList));
		
		Set<String> differentWords = new HashSet<String>();
		String filename = "guiao11/ex11,1.txt";
		lerfich lf = new lerfich(filename);
		System.out.println("Numero total de palavras: " + lf.palavras());
		System.out.println("Numero de diferentes palavras: " + lf.worddiferentes());
		lf.printinfor("guiao11/ex1-guiao11");
	}
	
	// Deve aceitar uma Lista de (sub)tipos Figura e retornar o	somatório das suas áreas
	public static double sumArea (List<? extends Figura> list) {
		double total = 0;
		Iterator it = list.iterator();
		while(it.hasNext())
			total += ((Figura)it.next()).area();
		return total;
	}
	
	// Deve aceitar um iterador (MyIterator) e imprimir todos	os elementos
	public static void printSet (Iterator iterator) {
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
		
}
