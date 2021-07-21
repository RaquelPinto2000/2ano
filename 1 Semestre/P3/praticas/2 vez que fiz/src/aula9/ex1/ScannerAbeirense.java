package aula9.ex1;
import java.io.*;
import java.util.*;
public class ScannerAbeirense implements Iterator<String>, Closeable {
	private Scanner sc ;
	
	public ScannerAbeirense(String s) {
		sc = new Scanner(s);
	}
	public ScannerAbeirense(File fich) {
		try{
			sc = new Scanner (fich);
		}catch(IOException e){
			System.out.println("Ficheiro nao encontrado");
		}
	}
	
	public String next() { // retorna a frase a abeirense
		String aux = sc.nextLine();
		aux = aux.replace("v", "b");
		aux = aux.replace("V", "B");
		return aux;
	}

	public boolean hasNext() {
		return sc.hasNext();
	}
	
	public void close() {
		sc.close();
	}
}
