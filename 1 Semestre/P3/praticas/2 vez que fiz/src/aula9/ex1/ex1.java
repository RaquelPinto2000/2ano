package aula9.ex1;
import java.util.*;
import java.io.*;
public class ex1 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ScannerAbeirense ab =null;
		System.out.println("Frase: ");
		String s = sc.nextLine();
		if(s.isEmpty()) {;
			File fich = new File ("Guiao9/ex1/frases.txt");
			ab= new ScannerAbeirense(fich);
		}else {
			ab = new ScannerAbeirense(s);
		}
		
		while(ab.hasNext()) {
			System.out.println(ab.next());
		}
		
		sc.close();
	}
}
