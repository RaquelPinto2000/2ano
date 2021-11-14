//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula11.ex1;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class lerfich {
	
	private Map<String,Integer> wordcount; //key==string
	private int worddiferentes;
	private int palavras;
	
	public lerfich(String nomefich) throws IOException{
		wordcount =new TreeMap<>();
		readword (nomefich);
		countword(nomefich);
	}
	
	public int worddiferentes() {
		return worddiferentes;
	}
	
	public int palavras() {
		return palavras;
	}
	
	public void readword(String name) throws IOException{
		List<String> lines = Files.readAllLines(Paths.get(name));
		for(int i= 0;i<lines.size();i++) {
			String []s = lines.get(i).split(" "); //ler as palavras
			for(int j=0;j<s.length;j++) {
				if(wordcount.containsKey(s[j])) {
					wordcount.put(s[j], wordcount.get(s[j])+1);
				}else {
					wordcount.put(s[j],1);
				}
				
			}
		}
	}
	
	
	public void countword(String name) throws IOException{	
		Set <String> differentWordsSet = new HashSet();
		List<String> lines = Files.readAllLines(Paths.get(name));
		for(int i=0;i<lines.size();i++) {
			String []s = lines.get(i).split(" "); //ler as palavras
			for(int j=0;j<s.length;j++) {
				differentWordsSet.add(s[j]);  // insere sempre paravras diferentes por ser um HashSet() / Set
				palavras++;
			}
			worddiferentes = differentWordsSet.size();
		}
	}
	
	public void printinfor(String name) throws IOException{
		PrintWriter print = new PrintWriter(new File(name));
		for(String key : wordcount.keySet()) {
			print.println(key+"\t"+wordcount.get(key));
		}
		print.close();
	}	
}
