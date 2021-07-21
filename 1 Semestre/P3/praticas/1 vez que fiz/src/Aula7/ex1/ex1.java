//Raquel Resende Milheiro Pinto nºMEC = 92948  (definitiva->sem erros)
package Aula7.ex1;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.lang.System.*;

public class ex1 {
	
	static List<voo> voo = new ArrayList<>();
	static HashMap<String,Companhia> comp = new HashMap<>(); //(Sigla, Companhia)
	
	public static void main(String[] args) throws IOException{
	
		List <String> imCompanhias=Files.readAllLines(Paths.get("companhias.txt"));
		List <String> voos = Files.readAllLines(Paths.get("voos.txt"));
		
		//adiciona as companhias
		for(int i=0;i<imCompanhias.size();i++) {
			String s[] = imCompanhias.get(i).split("\t");
			comp.put(s[0],new Companhia(s[0],s[1]));
		}
		
		//adiciona os voos
		for(int i=0;i<voos.size();i++) {
			String s[] = voos.get(i).split("\t");
			Companhia companhia =comp.get(s[1].substring(0,2)); 
			
			if(companhia==null) {
				continue;
			}
			
			// se s.length<4, nao existe atraso, se nao, tem atraso e, s[3]
			Hora atraso = s.length < 4 ? new Hora() : new Hora(s[3]); 
			voo.add(new voo(new Hora(s[0]),atraso,s[1],s[2],companhia));
		}
		
		out.println("----------------Lista de voos----------------");
		out.println();
		vertabela();
		out.println();
		printFich();
		out.println();
		out.println("----------------Media de atrasos por companhia----------------");
		out.println();
		mediaAtraso();
		out.println();
		out.println("----------------Chegadas a cada cidade----------------");
		out.println();
		cidades();
		out.println();
		printFichBin();
		out.println();
		out.println("----------------Lista de voos do ficheiro bin----------------");
		out.println();
		readFichBin();
	}
	
	//imprimir tabela 
	public static void vertabela() {
		out.println("Hora\tVoo\t\tCompanhia\t\tOrigem\t\t\tAtraso\tObservacao");
		for(int i=0;i<voo.size();i++) {
			out.println(voo.get(i));
		}
	}
	
	//guardar os dados no ficheiro
	public static void printFich() throws IOException{
		PrintWriter printfich = new PrintWriter(new File("Infopublico.txt"));
		printfich.println("Hora\tVoo\t\tCompanhia\t\tOrigem\t\t\tAtraso\tObservacao");
		for(int i=0;i<voo.size();i++) {
			printfich.println(voo.get(i));
		}
		out.println("Tabela guardada com sucesso(Infopublico.txt)");
		printfich.close();
	}
	
	//media dos atrasos por companhia
	public static void mediaAtraso() {
		HashMap<Companhia,Integer> tabAtraso = new HashMap<>();
		out.println("Companhia\t\tAtraso Medio");
		
		// percorres as companhias e os voos. Se alguma das companhias do voo for igual as companhias ele soma
		for(Companhia compaux :comp.values().toArray(new Companhia[0])) {  // values()= método para retorna todos os valores do hashmap
			int soma=0; //soma para a conta da media
			int count=0;//contar o numero para dividir na media
			for(voo vooaux : voo.toArray(new voo[0])) {
				if(vooaux.companhia()==compaux) {
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
	
	//total de chegadas de cada cidade origem
	public static void cidades() throws IOException{
		PrintWriter printfich = new PrintWriter(new File("cidades.txt"));
		printfich.println("Origem\tVoos");
		HashMap<String,Integer> cidades = new HashMap<>();
		int count=0;
		String s="";
		for(int i=0;i<voo.size();i++) {
			count=1;
			if(cidades.get(voo.get(i).origem())!=null) {
				count = cidades.get(voo.get(i).origem())+1;
			}
			cidades.put(voo.get(i).origem(),count);
		}
        for(String c : cidades.keySet()){
           s+= c +"\t"+ cidades.get(c) +"\n";
           
        }
        printfich.println(s);
		printfich.close();	
		out.println("Tabela guardada com sucesso(cidades.txt)");
	}
	
	//guardar os dados no ficheiro binario
	public static void printFichBin() throws IOException{
		RandomAccessFile file = new RandomAccessFile("Infopublico.bin", "rw");
		file.write(String().getBytes());
		file.close();
		out.println("Tabela guardada com sucesso(Infopublico.bin)");
	}
	
	
	//ler o ficheiro binario e imprimir no ecra
	public static void readFichBin() throws IOException {
		RandomAccessFile file = new RandomAccessFile("Infopublico.bin", "rw");
		byte[] info = new byte[(int)file.length()];
		file.readFully(info);
		file.close();
		out.println(new String(info));
		
	}
	
	public static String String() {
		String str = "";
		for(voo voo : voo.toArray(new voo[0])) {
			str += voo + "\n";
		}
		return str;
	}
}