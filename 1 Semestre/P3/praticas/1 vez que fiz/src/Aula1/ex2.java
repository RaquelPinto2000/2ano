package Aula1;

import static java.lang.System.*;
import java.util.*;


public class ex2 {
static Scanner sc = new Scanner(System.in);

static List<People> people = new ArrayList<>();

	public static void main ( String[] args) {
		
		int opcao;
		do {
			out.println("1-Introducao de novas pessoas");
			out.println("2-Remocao de pessoas");
			out.println("3-Lista completa de pessoas");
			out.println("4-Ordenar lista por Nome");
			out.println("5-Ordenar lista por numero de cc");
			out.println("6 -Terminar programa");
			out.print("Escolha: ");
			opcao=sc.nextInt();
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
		}while(opcao !=6);
	}
	
	//acrescenta uma pessoa
	public static void newpeople() {
		String name="";
		boolean vali = false; //verifica se o nome e o numero de cc sao validos
		
		while(vali==false) {
			out.print("Nome: ");
			name = sc.next();
			for(int i = 0; i<name.length();i++) {
				char c = name.charAt(i);
				if(Character.isDigit(c)) {
					vali=false;
					break;
				}else {
					vali = true;
				}
			}
		}
		vali=false;
		String cc1 = "";
		while(vali==false) {
			out.print("numero do cc: ");
			cc1 = sc.next();
			for(int i = 0; i<cc1.length();i++) {
				char c = cc1.charAt(i);
				if(Character.isDigit(c)) {
					vali=true;
				}else {
					vali=false;
					break;
				}
			}
		}

		int cc=Integer.parseInt(cc1);
		int num=0;
		boolean b=false;
		
		while(b==false && num!=3) {
			out.print("Data de nascimento(dd-mm-aa): ");
			String datat= sc.next();
			String data[] = datat.split("-");
			num=data.length;
			Data date = new Data(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
			if(Data.validadata(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]))) {
				people.add(new People(name, cc, date));
				out.println("Pessoa foi adicionada");
			}else {
				b=false;
				num=0;
			}
		}		
	}
	
	//retira pessoas a lista
	public static void deletepeople() {
		if(people.size()!=0) {
			out.print("Pessoa a remover: ");
			String name = sc.next();
			List <People> aux = new ArrayList<>(); //auxilia a remover pessoas da lista original
			
			for(int i = 0;i< people.size();i++) {
				
				if(!people.get(i).name().equals(name)) {
					aux.add(people.get(i));
				}
				
			}
			
			if(aux.size()==people.size()) {
				out.print("Nome nao encontrado\n");
				
			}else {
				out.print("Pessoa removida\n");
			}
			
			people = aux;
			
		}else {
			out.print("Nao e possivel remover pessoas, porque nao esta nenhuma inserida");
		}
		
	}
	
	//imprime a lista de pessoas
	public static void printpeople() {
		
		if(people.size()!=0) {
			out.println("|Nome       CC        DATA     |");
			out.println("|------------------------------|");
			
			for(int i = 0; i<people.size();i++) {
				out.println("|" + people.get(i).name()+"       " + people.get(i).cc() +"         " + people.get(i).datanac() + "|") ;
				out.println("|------------------------------|");
			}
		}else {
			out.println("Nao existe ninguem na lista");
		}
	}
	
	//ordenar por nome
	public static void ordenarnome() {
		People aux;
		for(int i = 0 ; i<people.size();i++) {
			for(int j = i+1 ; j<people.size();j++) {
				if(people.get(i).name().compareTo(people.get(j).name())>0) {
					aux = people.get(i);
					people.set(i, people.get(j));
					people.set(j, aux);
				}
			}
			
		}
		out.println("Ordenacao com sucesso");
	}
	
	
	//ordenar por numeros de cc
	public static void ordenarcc() {
		People aux;
		for(int i =0;i<people.size();i++) {
			for(int j =i+1;j<people.size();j++) {
				if(people.get(i).cc()>people.get(j).cc()) {
					aux = people.get(i);
					people.set(i, people.get(j));
					people.set(j,aux);	
				}
			}
		}
		out.println("Ordenacao com sucesso");
	}
	
}
