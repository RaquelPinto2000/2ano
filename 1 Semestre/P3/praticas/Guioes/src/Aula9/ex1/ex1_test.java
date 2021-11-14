//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula9.ex1;
import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class ex1_test {
	public static void main(String[] args){
		Scanner read = new Scanner(System.in);
		ScannerAbeirense s =null;
		out.print("String: ");
		String aux= read.nextLine();
		if(aux.equals("")) {
			try{
				File fich = new File("guiao9_ex1.txt");
				s= new ScannerAbeirense(fich);
			}catch(Exception c) {
				out.println("Ficheiro nao foi lido com sucesso");
			}
		}else {
			s = new ScannerAbeirense(aux);
		}
		
		while(s.hasNext()) {
			out.print(s.next()+ "\t");
		}
		
		s.close();
	}
	
	
	
}
