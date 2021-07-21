package aula1.ex2;
import static java.lang.System.out;

import java.util.*;
public class ex2 {
	static List <Pessoa> pessoas = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int opcao=0;
		do {
			System.out.println("1 - Adicionar pessoas");
			System.out.println("2 - Remover pessoas");
			System.out.println("3 - Mostrar lista de pessoas");
			out.println("4 - Ordenar lista por Nome");
			out.println("5 - Ordenar lista por numero de cc");
			System.out.println("6 - Terminar");
			System.out.println("Opcao: ");
			opcao = sc.nextInt();
			switch(opcao){
			case 1:
				newpeople();
				break;
			case 2:
				deletepeople();
				break;
			case 3:
				printpeople();
				break;
			case 4:
				ordenarnome();
				break;
			case 5:
				ordenarcc();
				break;
			case 6:
				break;
			}
		}while(opcao!=6);
	}
	
	public static void newpeople() {
		int num=0;
		boolean b=false;
		System.out.println("Nome: ");
		String nome = sc.next();
		sc.nextLine();
		System.out.println("CC: ");
		int cc = sc.nextInt();
		
		while(b==false && num!=3) {
			out.print("Data de nascimento(dd-mm-aa): ");
			String datat= sc.next();
			String data[] = datat.split("-");
			num=data.length;
			Data date = new Data(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
			if(Data.validadata(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]))) {
				pessoas.add(new Pessoa(nome, cc, date));
				out.println("Pessoa foi adicionada");
			}else {
				b=false;
				num=0;
			}
		}		
	}
	public static void deletepeople() {
		System.out.println("CC: ");
		int cc = sc.nextInt();
		for (int i = 0; i < pessoas.size(); i++) {
			if(pessoas.get(i).cc()==cc) {
				pessoas.remove(pessoas.get(i));
				System.out.println("Pessoa removida");
				break;
			}
		}
	}
	public static void printpeople() {
		if(pessoas.size()!=0) {
			out.println("|Nome       CC        DATA     |");
			out.println("|------------------------------|");
			
			for(int i = 0; i<pessoas.size();i++) {
				out.println("|" + pessoas.get(i).nome()+"       " + pessoas.get(i).cc() +"         " +pessoas.get(i).dataNasc() + "|") ;
				out.println("|------------------------------|");
			}
		}else {
			out.println("Nao existe ninguem na lista");
		}
	}
	
	
	public static void ordenarnome() {
		Pessoa aux;
		for (int i = 0; i < pessoas.size(); i++) {
			for (int j = i+1; j < pessoas.size(); j++) {
				if(pessoas.get(i).nome().compareTo(pessoas.get(j).nome())>0) {
					aux=pessoas.get(i);
					pessoas.set(i, pessoas.get(j));
					pessoas.set(j, aux);
				}
			}
		}
	}
	
	public static void 	ordenarcc() {
		Pessoa aux;
		for (int i = 0; i < pessoas.size(); i++) {
			for (int j = i+1; j < pessoas.size(); j++) {
				if(pessoas.get(i).cc()>pessoas.get(j).cc()) {
					aux=pessoas.get(i);
					pessoas.set(i, pessoas.get(j));
					pessoas.set(j, aux);
				}
			}
		}
	}
}
