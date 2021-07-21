//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula9.ex1;
import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class ScannerAbeirense implements Iterator<String>, Closeable{

	private Scanner sc;
	
	public ScannerAbeirense(File fich) {
		try{
			sc = new Scanner(fich);
		}catch(IOException e) {
			out.println("Ficheiro nao foi lido com sucesso");
		}
	}
	
	
	public ScannerAbeirense(String s) {
		sc = new Scanner (s);
	}
		
	@Override
	public boolean hasNext() {
		return sc.hasNext();
	}
	
	@Override
	public String next() {
		String aux = sc.next();
		aux=aux.replaceAll("v","b"); //toca os v por b
		aux=aux.replaceAll("V", "B");//toca os V por B
		return aux;
	}
	
	@Override
	public void close() {
		sc.close();
	}
	
}
