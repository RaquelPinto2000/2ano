import java.util.*;
import java.io.*;
public class ex6 {
	static Map<String,String> map = new HashMap<>();
	public static void main (String[] args) {
		armazenar();
		Scanner sc = new Scanner(System.in);
		System.out.print("Palavra a traduzir: ");
		String palavra = sc.nextLine();
		String palavras[] = palavra.split(" ");
		for(int i = 0;i<palavras.length;i++){
			if(map.get(palavras[i]) == null){
					System.out.print(palavras[i] + " ");
			}else{
				System.out.print(map.get(palavras[i]) + " ");
			}
		}
	}
	
	
	
	public static void armazenar (){
		try{
			Scanner ler = new Scanner(new File("dic1.txt"));
			while(ler.hasNextLine()){
				String s = ler.nextLine();
				String ver[] = s.split(" ");
				String traducao="";
				for(int i = 1 ; i<ver.length;i++){
					traducao += (ver[i] + " ");
				}
				map.put(ver[0],traducao);
			}
			ler.close();
			
		}catch(FileNotFoundException e){
			System.err.println("File not found");
			System.exit(1);
		}
			
		
	}
}

