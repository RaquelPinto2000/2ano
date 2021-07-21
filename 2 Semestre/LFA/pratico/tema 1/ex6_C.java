import java.util.*;
import java.io.*;
public class ex6_C {
	static Map<String,String> map = new HashMap<>();
	public static void main (String[] args) {
		armazenar();
		Scanner sc = new Scanner(System.in);
		System.out.print("Palavra a traduzir: ");
		String palavra = sc.nextLine();
		String palavras[] = palavra.split(" ");
		String resultado="";
		for(int i = 0;i<palavras.length;i++){
			if(map.get(palavras[i]) == null){
				resultado += palavras[i] + " ";
			}else{
				String aux[] = map.get(palavras[i]).split(" ");
				for(int j = 0;j<aux.length;j++){ 
					if(map.get(aux[j])==null){
						resultado += aux[j] + " ";
					}else{
						String aux1[] = map.get(aux[j]).split(" ");
						for(int k = 0; k<aux1.length;k++){
							//System.out.print(aux1[k]);
							if(map.get(aux1[k])==null){
								resultado += aux1[k] + " ";
							}else{
								resultado += map.get(aux1[k]) + " ";
							}
						}
							
					}
				}
			}
		}
		System.out.println(resultado);
	}
	
	
	public static void armazenar (){
		try{
			Scanner ler = new Scanner(new File("dic2.txt"));
			while(ler.hasNextLine()){
				String s = ler.nextLine();
				String ver[] = s.split(" ");
				String traducao="";
				for(int i = 1 ; i<ver.length;i++){
					if(!ver[i].equals(" ")){
						traducao += (ver[i] + " ");
					}
				}
				traducao = traducao.trim();
				map.put(ver[0],traducao);
			}
			ler.close();
			
		}catch(FileNotFoundException e){
			System.err.println("File not found");
			System.exit(1);
		}
	}
}
