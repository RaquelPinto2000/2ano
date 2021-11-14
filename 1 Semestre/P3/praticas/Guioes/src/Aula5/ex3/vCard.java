//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex3;

import java.io.*;
import java.util.*;

public class vCard implements AgendaF {
	
	
	public Pessoa[] lerformatof(String filenome) throws IOException{
		Scanner sc = new Scanner(new File(filenome));
		List<Pessoa> p= new ArrayList<>();
		
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			String aux[] = s.split("#");
			String nomep = aux[0];
			int contacto = Integer.parseInt(aux[1]);
			String date= aux[2];
			String[] data = date.split("/");
			p.add(new Pessoa(nomep,contacto,new Data (Integer.parseInt(data[0]), Integer.parseInt(data[1]),Integer.parseInt(data[2]))));
		}
		sc.close();
		return p.toArray(new Pessoa[0]);
		
		
	}
	public void escreverich(String filenome, Pessoa[] p) throws IOException{
		PrintWriter pw = new PrintWriter(new File(filenome));
		pw.print("vCard");
		for(int i=0;i<p.length;i++) {
			pw.print(p[i].toString());
			pw.println();
		}
		pw.close();
	}
}
