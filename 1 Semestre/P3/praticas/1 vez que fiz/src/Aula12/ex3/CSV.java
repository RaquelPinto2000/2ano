//Raquel Resende Milheiro Pinto nºMEC = 92948

package Aula12.ex3;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSV implements AgendaP{
	

	public Pessoa[] lerformatof(String filenome) throws IOException{
		Scanner sc = new Scanner(new File(filenome));
		List<Pessoa> p= new ArrayList<>();
		
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			String aux[] = s.split("\t");
			String nomep = aux[0];
			int contacto = Integer.parseInt(aux[1]);
			String date= aux[2];
			String[] data = date.split("/");
			p.add(new Pessoa(nomep,contacto,new Data (Integer.parseInt(data[0]), Integer.parseInt(data[1]),Integer.parseInt(data[2]))));
		}
		sc.close();
		return p.toArray(new Pessoa[0]);
		
		
	}
	public void escreverfich(String filenome, Pessoa[] p) throws IOException{
		PrintWriter pw = new PrintWriter(new File(filenome));
		pw.println("CSV");
		for(int i=0;i<p.length;i++) {
			pw.print(p[i].toString());
			pw.println();
		}
		pw.close();
	}
	@Override
	public String toString() {
		return "CSV ";
	}
}
