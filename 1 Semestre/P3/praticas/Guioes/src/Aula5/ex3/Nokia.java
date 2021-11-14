//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex3;

import java.util.*;
import java.io.*;

public class Nokia implements AgendaF {
	
	
	public Pessoa[] lerformatof(String filenome) throws IOException{
		Scanner sc = new Scanner(new File(filenome));
		List<Pessoa> p= new ArrayList<>();
		while(sc.hasNextLine()) {
			String nomep = sc.nextLine();
			int contacto = Integer.parseInt(sc.nextLine());
			String date= sc.nextLine();
			String[] data = date.split("/");
			p.add(new Pessoa(nomep,contacto,new Data (Integer.parseInt(data[0]), Integer.parseInt(data[1]),Integer.parseInt(data[2]))));
		}
		sc.close();
		return p.toArray(new Pessoa[0]);
		
		
	}
	public void escreverich(String filenome, Pessoa[] p) throws IOException{
		PrintWriter pw = new PrintWriter(new File(filenome));
		pw.print("Nokia");
		for(int i=0;i<p.length;i++) {
			pw.print(p[i].nome());
			pw.print(p[i].numero());
			pw.print(p[i].datanasc());
			pw.println();
		}
		pw.close();
	}
}
