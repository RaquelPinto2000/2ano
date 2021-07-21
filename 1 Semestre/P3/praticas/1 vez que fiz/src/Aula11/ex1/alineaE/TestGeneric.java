//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula11.ex1.alineaE;

import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public abstract class TestGeneric {
	public static void main(String[] args) throws IOException{
		
		
		Set<String> differentWords = new HashSet<String>();
		String filename = "guiao11/ex11,1.txt";
		lerfich lf = new lerfich(filename);
		System.out.println("Numero total de palavras: " + lf.palavras());
		System.out.println("Numero de diferentes palavras: " + lf.worddiferentes());
		System.out.println(lf.ToString());
	}
			
}
