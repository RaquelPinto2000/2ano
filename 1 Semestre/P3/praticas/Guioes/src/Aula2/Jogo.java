package Aula2;
import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class Jogo {
	
	
	private char[][] carac; //caracteres da sopa de letras
	private List<String> words; //Palavras a procurar
	private List<String> resultado; //Palavras encontradas
	private int n; // numero de caracteres da 1 frase
	
	public Jogo(String nomejogo){
		carac = new char[80][80];
		Scanner sc = null;
		try {
			sc = new Scanner(new File(nomejogo));
			
		}catch(FileNotFoundException e) {
			out.println("O ficheiro "+nomejogo+ " nao existe");
			exit(1);
		}
		String fline = sc.nextLine(); //Dimensoes da sopa de letras
		n = fline.length();
		int y=0;
		for(int i =0 ;i<n;i++) {
			carac[y][i] = fline.charAt(i);
		}
		y++;
		words = new ArrayList<>(n);
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(!line.contains(",")) { //se nao tiver , a separar palavras e pq e uma linha da sopa de letras
				for(int i =0;i<n ;i++) {
					carac[y][i] = line.charAt(i);
					
				}
				y++;
			}else { // se tiver , a separar palavras, entao e pq e uma linha que esta a indicar as palavras a procurar
				String word[] = line.split(", ");
				for(int j = 0;j<word.length;j++) {
					words.add(word[j].toUpperCase()); // por tudo em maiuscula
				}
			}
		}
		resultado = new LinkedList<>();
		//sc.close();
	}
	
	
	//comecar o jogo
	public void jogar() {
		
		for(int y =0 ;y<n;y++) {
			for(int x = 0; x<n;x++) {
				for(int i =0;i<words.size();i++) {
					String word = words.get(i);
					//Se encontrar a 1 letra da palavra
					if(carac[y][x] == word.charAt(0)) {
						Posicao Pos = new Posicao(y,x);
						
						//Se a palavra estiver para a direita
						if(x+word.length()-1<n) { 
							String s = "right"; //indica a direcao
							if(procurarpalavra(word,s,Pos)) {
								resultado.add(word + "    " + Pos + "    "+ s) ;
							}
						} 
						
						//Se a palavra estiver para a esquerda
						if(x-word.length()+1>=0) {
							String s = "left"; //indica a direcao
							if(procurarpalavra(word,s,Pos)) {
								resultado.add(word + "    " + Pos + "    "+ s) ;
							}
						}
						
						//Se a palavra estiver para cima
						if(y-word.length()+1>=0) {
							String s = "up"; //indica a direcao
							if(procurarpalavra(word,s,Pos)) {
								resultado.add(word + "    " + Pos + "    "+ s) ;
							}
						}
						
						//Se a palavra estiver para baixo
						if(y+word.length()-1<n) { 
							String s = "down"; //indica a direcao
							if(procurarpalavra(word,s,Pos)) {
								resultado.add(word + "    " + Pos + "    "+ s) ;
							}
						} 
						
						
						//Se estiver na diagonal, para cima e para a esquerda
						if(y-word.length()+1>=0 && x-word.length()+1>=0) {
							String s = "upleft"; //indica a direcao
							if(procurarpalavra(word,s,Pos)) {
								resultado.add(word + "    " + Pos + "    "+ s) ;
							}
						}
						
						//Se estiver na diagonal, para cima e para a direita
						if(y-word.length()+1>=0 && x+word.length()-1<n) {
							String s = "uprigth"; //indica a direcao
							if(procurarpalavra(word,s,Pos)) {
								resultado.add(word + "    " + Pos + "    "+ s) ;
							}
						}
						
						
						//Se estiver na diagonal,para baixo e para a esquerda
						if(y+word.length()-1<n && x-word.length()+1>=0) { 
							String s = "downleft"; //indica a direcao
							if(procurarpalavra(word,s,Pos)) {
								resultado.add(word + "    " + Pos + "    "+ s) ;
							}
						} 
						
						//Se estiver na diagonal, para baixo e para a direita
						if(y+word.length()-1<n && x+word.length()-1<n) {
							String s = "downrigth"; //indica a direcao
							if(procurarpalavra(word,s,Pos)) {
								resultado.add(word + "    " + Pos + "    "+ s) ;
							}
						}
					}
				}
			}
		}
	}
	
	public boolean procurarpalavra(String word, String s, Posicao p) {
		int countx=0, county=0; //Posicao inicial da palavra
		//Posicao final da palavra
		int x = p.x();
		int y= p.y(); 
		boolean b = false;
		// Na vertical
		
		if(s.contains("up")) { 
			county = -1;
		}else if(s.contains("down")){
			county=1;
		
		}
		
		//Na horizontal
		if(s.contains("left")) {
			countx = -1;
		}else if(s.contains("rigth")){
			countx=1;
		}
		
		String aux = "";
		
		for(int i = 0;i<word.length();i++) { 
			aux +=carac[y][x];
			x +=countx;
			y += county;
		}
		
		if(aux.equals(word)) {
			b=true;
		}
		return b;
	}

	
	//imprimir o resultado
	public void printjogo() {	
		for(int i = 0;i<resultado.size();i++) {
			out.println(resultado.get(i));
		}
	}	
}