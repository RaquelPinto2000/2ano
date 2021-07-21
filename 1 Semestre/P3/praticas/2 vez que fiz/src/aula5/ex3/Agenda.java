package aula5.ex3;
import java.util.*;
import java.io.*;
public class Agenda {
	private List<Pessoa> agenda  = new ArrayList<>();
	
	public void lerficheiro(String nome) throws IOException {
		File fich = new File(nome);
		Scanner sc = new Scanner(fich);
		String f = sc.nextLine();
		AgendaFormat A = null;
		if(f.equals("Nokia")) {
			A = new Nokia();
		}else if(f.equals("vCard")) {
			A = new vCard();
		}else if(f.equals("CSV")){
			A = new CSV();
		}
		sc.close();
	}
	
	public void addcontacto(Pessoa p) {
		agenda.add(p);
	}
	public void addcontacto(Pessoa [] p) {
		for (int i = 0; i < agenda.size(); i++) {
				agenda.add(p[i]);
		}
		
	}
	public int numcontactos() {
		return agenda.size();
	}
	public void removecontacto(Pessoa p) {
		for (int i = 0; i < agenda.size(); i++) {
			if(agenda.get(i)==p) {
				agenda.remove(i);
				break;
			}
			System.out.println("Nao existe esse numero");
		}
	}


	public String toString() {
		return agenda.toString();
	}
}
