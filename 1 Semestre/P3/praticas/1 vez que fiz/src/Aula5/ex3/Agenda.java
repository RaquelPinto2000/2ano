//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex3;

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Agenda {
	
	private List<Pessoa> agenda = new ArrayList<>(); 
	
	public void lerficheiro(String name) throws IOException{
		Scanner sc = new Scanner(new File(name));
		String f = sc.nextLine();
		sc.close();
		AgendaF agenda1 = null;
		if(f.equals("Nokia")) {
			agenda1 = new Nokia();
		}else if(f.equals("vCard")) {
			agenda1 = new vCard();
		}else if(f.equals("CSV")) {
			agenda1 = new CSV();
		}
		sc.close();
	}
	
	public void addcontacto (Pessoa[] p) {
		for(int i=0;i<agenda.size();i++){
			agenda.add(p[i]);
		}
	}
	
	public void addcontacto(Pessoa p) {
		agenda.add(p);
	}
	
	public void removecontacto(Pessoa p) {
		if(agenda.size()!=0 && agenda.contains(p)) {
			for(int i=0;i<agenda.size();i++) {
				agenda.remove(p);
			}
		}else {
			out.println("Nao existe essa pessoa na lista");
		}
	}
	
	public int numcontactos() {
		return agenda.size();
	}
	
	public String toString() {
		return agenda.toString(); //devolve a agenda em forma de string
	}

}
