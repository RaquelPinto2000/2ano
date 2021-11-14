//Raquel Resende Milheiro Pinto nºMEC = 92948

package Aula4.ex3;
import java.util.*;

import static java.lang.System.*;

public class ex4 {

static Scanner sc = new Scanner(System.in);
static ArrayList<Pessoa> people = new ArrayList<>();
static ArrayList<Video> videos = new ArrayList<>();
static int videosutilizar = 3;
static int nsocio=0; // numero de socio
static int id =0;//id dos videos
static int requesitar=0;//contador de videos requisitados
	public static void main(String[] args) {
		int opcao=0;
		do {
			out.println("          VideoClube     ");
			out.println("----------------------------------");
			out.println("1 - Clientes");
			out.println("2 - Videos");
			out.println("3 - Requisitos/Devoluções");
			out.println("4 - Terminar");
			out.println("----------------------------------");
			out.print("Opção: ");
			opcao = sc.nextInt();
			switch (opcao) {
				case 1:
					clientes();
					break;
				case 2:
					videos();
					break;
				case 3:
					reqdevolve();
					break;
				case 4:
					break;
			}
			
		}while(opcao!=4);
		
	}
	
	//verifica se as pessoas ja estao inscritas
	public static boolean equals(int cc) {
		for(int i = 0;i<people.size();i++) {
			if(people.get(i).cc() == cc) {
				return true;
			}
		}
		return false;
	}
	
	public static void clientes() {
		int op = 0;
		
		do {
			out.println();
			out.println("Lista de Clientes");
			out.println("----------------------------------");
			out.println("1 - Adicionar pessoa");
			out.println("2 - Remover pessoas");
			out.println("3 - Listar pessoas");
			out.println("4 - Procurar pessoa");
			out.println("5 - Voltar");
			out.println("----------------------------------");
			out.print("Opção: ");
			op = sc.nextInt();
			switch (op) {
				case 1:
					int op1=0;
					boolean b =false;
					int num=0;	
					Data nasc=null;
					Data dinsc=null;
					out.print("Nome: ");
					String name = sc.next();
					out.print("Numero do cc: ");
					int cc = sc.nextInt();
					
					if(equals(cc)) {
						out.println("Essa pessoa ja existe");
						break;
					}else {
					
						while(b==false && num!=3) {//verificar se a data e valida
							out.print("Data de nascimento(dd-mm-aa): ");
							String datat= sc.next();
							String data[] = datat.split("-");
							num=data.length;
							nasc = new Data(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
							if(Data.validadata(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]))) {
								 dinsc = new Data();
								
							}else {
								b=false;
								num=0;
							}
						}
						
						out.println("1-Estudante");
						out.println("2-Funcionario");
						out.print("Opcao: ");
						op1 = sc.nextInt();
						//Estudantes
						if(op1==1) {
							out.print("Curso:");
							String curso = sc.next();
							out.print("NºMEC: ");
							int nmec=sc.nextInt();
							nsocio++;
							Pessoa estu = new Estudante(name,nmec,cc,curso,nasc,nsocio,dinsc,requesitar);
							people.add(estu);
							out.println("Pessoa foi adicionada");
							
							
						//Funcionarios
						}else if(op1==2) {
							out.print("Numero de funcionario: ");
							int nfunc= sc.nextInt();
							out.print("Numero fiscal: ");
							int nfisc=sc.nextInt();
							nsocio++;	
							Pessoa f = new Funcionario(name,cc,nasc,nfunc,nfisc,nsocio,dinsc,requesitar);
							people.add(f);
							out.println("Pessoa foi adicionada");
						}
						break;
				}
				case 2:
					boolean verificar=false;
					Pessoa temp2;
					out.print("Número de sócio da pessoa a procurar: ");
					int n2 = sc.nextInt();
					for (int i = 0; i < people.size(); i++) {
						temp2 = people.get(i);
						if (temp2.nsocio() == n2) {
							people.remove(i);
							out.println("Removida com sucesso");
							verificar=true;
						}
					}
					if(verificar==false) {
						out.println("Nao existe essa pessoa");
					}
					
					break;
				
				case 3:
					if(people.size()!=0) {
						out.println("---------------Lista de pessoas---------------");
						out.println("----------------------------------------------");
						out.println("NOME       CC      DATA DE NASCIMENTO        NSOCIO       DATA DE INSCRICAO");
						for(int i=0;i<people.size();i++) {
							out.println(people.get(i).nome() + "          " + people.get(i).cc() + "            " + people.get(i).datanasc().toString()
									+ "           " + people.get(i).nsocio() + "          " + people.get(i).datainsc().toString());
						}
					}else {
						out.println("Nao existe ninguem na lista");
					}
					break;
				case 4:
					boolean verificar1=false;
					Pessoa temp;
					out.print("Número de sócio da pessoa: ");
					int n = sc.nextInt();
					
					for (int i = 0; i < people.size(); i++) {
						temp = people.get(i);
						if (temp.nsocio() == n) {
							out.println("Informacoes dessa pessoa");
							out.println("------------------------");
							out.println("NOME         |     CC      |DATA NASCIMENTO");
							out.println(temp);
							verificar1=true;
						}
						
					}
					if(verificar1==false) {
						out.println("Nao foi encontrada nenhuma pessoa com esse numero de socio");
					}
						break;
				case 5:
					return;
			}
		}while(op != 5);
	}
	

	//
	public static void videos() {
		int op3=0;
		
		do {
			out.println();
			out.println("         Catalogo          ");
			out.println("----------------------------");
			out.println("1-Indroducao de videos");
			out.println("2-Remocao de videos");
			out.println("3-Listar videos");
			out.println("4-Procurar videos no catalogo");
			out.println("5-Voltar");
			out.print("Opcao: ");
			op3 = sc.nextInt();
			switch(op3) {
				case 1:
					out.print("Titulo: ");
					String t = sc.next();
					out.print("Categoria: ");
					String c = sc.next();
					out.print("Idade: ");
					String idade = sc.next();
					id++;
					videos.add(new Video(id,t,c,idade));
					break;
				case 2:
					out.print("ID para remover: ");
					int rid = sc.nextInt();
					for(int i = 0 ; i<videos.size();i++) {
						if(rid==videos.get(i).id()) {
							videos.remove(i);
							out.println("Removido com sucesso");
						}
					}
					break;
				case 3:
					out.println("---------------Lista de videos atual-------------------");
					out.println("ID           TITULO            CATEGORIA         IDADE ");
					for(int i=0;i<videos.size();i++) {
						out.println("-------------------------------------------------------");
						out.println(videos.get(i).id() +  "              " + videos.get(i).titulo() + "            " + videos.get(i).categoria()+"              " + videos.get(i).idade() );
					}
					break;
				case 4:
					out.print("ID do video a procurar: ");
					int ID = sc.nextInt();
					for(int i = 0;i<videos.size();i++) {
						if(ID==videos.get(i).id()) {
							out.println("ID           TITULO            CATEGORIA         IDADE ");
							out.println(videos.get(i).id() +  "             " + videos.get(i).titulo() + "              " + videos.get(i).categoria()+"                 " + videos.get(i).idade() );
						}
					}
					break;
				case 5:
					return;
			}
		}while(op3 !=5);
	}
	
	public static void reqdevolve() {
		int op4 = 0;
		do {
			out.println();
			out.println("         Operacoes         ");
			out.println("----------------------------");
			out.println("1-Requisitar");
			out.println("2-Devolver");
			out.println("3-Lista videos requisitados");
			out.println("4-Lista videos disponiveis na loja");
			out.println("5-Lista videos por rating");
			out.println("6-Lista videos emprestados a determinado cliente");
			out.println("7-Voltar");
			out.print("Opcao: ");
			op4=sc.nextInt();
			switch(op4) {
				case 1:
					requisitar();
					break;
				case 2:
					out.print("ID do video a devolver: ");
					int id1 = sc.nextInt();
					for (int i = 0; i < videos.size(); i++) {
						if (videos.get(i).id()==id1) {
							out.print("Classifique o video de 1 a 10: ");
							int classificacao = sc.nextInt();//ranking do video
							out.println("ID     TITULO     CATEGORIA      IDADE      DISPONIBILIDADE");
							out.println(videos.get(i).toString(videos.get(i)));
							videos.get(i).devolver(videos.get(i));
							out.println("Video devolvido com sucesso!");
							out.println();
							Video v = new Video (videos.get(i).id(),videos.get(i).titulo(),videos.get(i).categoria(),videos.get(i).idade(), classificacao);
							videos.remove(i);
							videos.add(v);
							break;
						}
					}					
					break;
				case 3:
					out.println("           Videos requesitados          ");
					out.println("--------------------------------------");
					out.println("ID     TITULO     CATEGORIA      IDADE      DISPONIBILIDADE");
					for (int i = 0; i < videos.size(); i++) {
						if (videos.get(i).requisitado()==true) {
							out.println("--------------------------------------");
							out.println(videos.get(i).toString(videos.get(i)));
						}
					}
					
					break;
				case 4:
					out.println("  Lista de videos disponiveis na loja  ");
					out.println("--------------------------------------");
					out.println("ID     TITULO     CATEGORIA      IDADE      DISPONIBILIDADE");
					for (int i = 0; i < videos.size(); i++) {
						if (videos.get(i).requisitado() == false) {
							out.println("--------------------------------------");
							out.println(videos.get(i).toString(videos.get(i)));
						}
					}
					break;
				case 5:
					Video aux1;
					out.println("   Lista de videos por ranking    ");
					out.println("-----------------------------------");
					out.println("ID    TITULO     CATEGORIA      IDADE      RATING");
					for(int i =0;i<videos.size();i++) {
						for(int j = i+1;j<videos.size();j++) {
							if(videos.get(i).rating()<videos.get(j).rating()) {
								aux1= videos.get(i);
								videos.set(i, videos.get(j));
								videos.set(j,aux1);	
							}						
						}
						out.println(videos.get(i).id() + "      " + videos.get(i).titulo()+ "        " + videos.get(i).categoria() + "          " + videos.get(i).idade() + "        " + videos.get(i).rating());				
					}
					break;
				case 6:
					out.print("Numero de socio da pessoa para ver a lista: ");
					int number = sc.nextInt();
					out.println();
					out.println("   Lista de videos emprestados por pessoa    ");
					out.println("------------------------------------------");
					out.println("PESSSOA          VIDEOS EMPRESTADOS");
					
					for (int i = 0; i < people.size(); i++) {
						if(people.get(i).nsocio()==number && people.get(i).requesitou()>=1) {
							out.println("--------------------------------------");
							out.println(people.get(i).nome() + "             " + videos.get(i).titulo());
						}
					}
					break;
				case 7:
					return;
			}
		}while(op4!=7);
	}
	
	public static void requisitar() {
		out.print("Numero de socio da pessoa: ");
		int n = sc.nextInt();
		
		for(int k = 0 ;k<people.size();k++) {
				int number = people.get(k).requesitou();
				if(n==k || number<3) {
					requesitar++; //contador de videos requesitados
					Pessoa p = new Pessoa (people.get(k).nome(),people.get(k).cc(),people.get(k).datanasc(),people.get(k).nsocio(),people.get(k).datainsc(),requesitar);
					people.remove(k);
					people.add(p);
					out.print("ID do video a requisitar: ");
					int id = sc.nextInt();
					for (int i = 0; i < videos.size(); i++) {
						if (videos.get(i).id()==id) {
							if (videos.get(i).requisitado()==true) {
								out.println("Video ja requisitado");
								return;
							}else {
								out.println("ID     TITULO     CATEGORIA      IDADE      DISPONIBILIDADE");
								out.println(videos.get(i).toString(videos.get(i)));
								videos.get(i).requisitar(videos.get(i));
								out.println("Video requisitado com sucesso!");
								out.println();
								return;
							}
						}
					}
				}else if(number>=3){
					out.println("Nao pode requisitar se nao devolver os outros videos");
					out.println();
					return;
				}
		}						
	}
	
	
}
