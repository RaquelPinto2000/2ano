package aula7.ex1;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ex1 {
	static List<Voo> voo = new ArrayList<>();
	static HashMap<String,Companhia> comp = new HashMap<>();
	public static void main(String[] args) throws IOException{
		
		// le todas as linhas dos ficheiros e cada linha fica numa posicao 
		List <String> imCompanhias=Files.readAllLines(Paths.get("Guiao7/ex1/companhias.txt"));
		List <String> voos = Files.readAllLines(Paths.get("Guiao7/ex1/voos.txt"));
		
		
		// companhias
		for (int i = 0; i < imCompanhias.size(); i++) {
			String s[] = imCompanhias.get(i).split("\t");
			comp.put(s[0], new Companhia(s[0],s[1]));
		}
		
		// voos
		for (int i = 0; i < voos.size(); i++) {
			String s[] = voos.get(i).split("\t");
			Companhia companhia = comp.get(s[1].substring(0, 2)); // danos a sigla, a string origiran seria por ex TP 1944 e ficamos so com TP
			
			if(companhia==null) { // existe algumas companhias no ficheiro voo que nao estao no ficheiro companhias
				continue;
			}
			
			Hora hat;
			if(s.length<4) {// se for vazia noa tem hora
				hat = new Hora();
			}else { 
				hat = new Hora(s[3]);
			}
		
			voo.add(new Voo(s[2],new Hora(s[0]),s[1],hat,companhia));
		}
		
		//resultados
		out.println("----------------Lista de voos----------------");
		out.println();
		vertabela();
		printInfo();
		out.println();
		out.println("----------------Media de atrasos por companhia----------------");
		out.println();
		mediaAtraso();
		out.println("----------------Chegadas a cada cidade----------------");
		out.println();
		cidades();
		out.println("Sucesso");
		out.println("----------------Lista de voos do ficheiro bin----------------");
		out.println();
		printBin();
		out.println("Sucesso");
		out.println("---------------- Lista do ficheiro em binario----------------");
		out.println();
		readBin();
		
		
	}
	
	public static void vertabela() {
		out.println("Hora\tVoo\t\tCompanhia\t\tOrigem\t\t\tAtraso\tObservacao");
	//	for (int i = 0; i < voo.size(); i++) {
	//		System.out.println(voo.get(i).toString());
	//	}
		voo.forEach((n) -> System.out.println(n)); // esta linha substitui o ciclo for todo. Pois o metodo forEach(...) devolve o que o arraylist tem
		// e o System.out.println(); imprime o voo.get(i).toString()
	}
	
	public static void printInfo() throws IOException{ // num ficheiro
		String s="";
		for(int i = 0;i<voo.size();i++) {
			s += voo.get(i).toString() + "\n";
		}
		Files.write(Paths.get("Guiao7/ex1/Infopublico.txt"),s.getBytes());
		//voo.forEach((n) -> Files.write(n));
	//	Charset charset = Charset.forName(s);
	//	Files.newBufferedWriter(Paths.get("Guiao7/ex1/Infopublico.txt"), s);
		
	}
	
	
	public static void mediaAtraso() {
		HashMap<Companhia,Integer> tabAtraso = new HashMap<>();
		out.println("Companhia\t\tAtraso Medio");
		
		// percorres as companhias e os voos. Se alguma das companhias do voo for igual as companhias ele soma
		for(Companhia compaux :comp.values().toArray(new Companhia[0])) {  // values()= método para retorna todos os valores do hashmap
			int soma=0; //soma para a conta da media
			int count=0;//contar o numero para dividir na media
			for(Voo vooaux : voo.toArray(new Voo[0])) {
				if(vooaux.comp()==compaux) {
					soma += vooaux.atrasomin();
					count++;
				}
				int intaux = ((int) ((float)soma/(float)count));
			tabAtraso.put(compaux,intaux);
			}
		}
		Companhia[] sortedCompanhias = tabAtraso.keySet().toArray(new Companhia[0]); //ketset()=retorna as chaves do dicionario
		Arrays.sort(sortedCompanhias, new Comparator<Companhia>() {

			@Override
			public int compare(Companhia o1, Companhia o2) {
				return tabAtraso.get(o1)-tabAtraso.get(o2);
			}
			
		});
		for(Companhia companhia : sortedCompanhias) {
			out.printf(String.format("%-18s\t%s\n", companhia, new Hora(tabAtraso.get(companhia))));
		}
	}	
	
	
	public static void cidades()throws IOException {
		HashMap<String,Integer> aux = new HashMap<>();
		int count =0;
		for(int i=0;i<voo.size();i++) {
			count=1;
			if(aux.get(voo.get(i).origem())!=null) {
				count = aux.get(voo.get(i).origem())+1;
			}
			aux.put(voo.get(i).origem(),count);
		}
		
		//falta ordenar por ordem das key?????????????????????????????????????????
		for(int i =0;i<aux.size();i++) {
			for (int j = i; j < aux.size(); j++) {
		//		if() {
					
			//	}
			}
		}
		
		
		
		PrintWriter printfich = new PrintWriter(new File("Guiao7/ex1/cidades.txt"));
		printfich.println("Origem\tVoos");
		String s="";
		for(String c : aux.keySet()){
	          s+= c +"\t"+ aux.get(c) +"\n";      
	    }
	    printfich.println(s);
		
		printfich.close();
		
		
	}
	
	public static void printBin() throws IOException {
		String s="";
		for(int i = 0;i<voo.size();i++) {
			s += voo.get(i).toString() + "\n";
		}
		RandomAccessFile file = new RandomAccessFile("Guiao7/ex1/Infopublico.bin", "rw");
		file.write(s.getBytes());
		file.close();
		
	}
	
	public static void readBin() throws IOException{
		RandomAccessFile file = new RandomAccessFile("Guiao7/ex1/Infopublico.bin", "rw");
		byte[] info = new byte[(int)file.length()];
		file.read(info);
		file.close();
		System.out.println(new String(info));
	}
	
}
