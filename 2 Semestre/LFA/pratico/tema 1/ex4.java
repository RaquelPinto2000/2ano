import java.util.*;
import java.io.*;

public class ex4 {
	public static void main (String[] args) {
		int numero=0;
		String s ="";
		Map<String,Integer> mapa = new HashMap<>();
		try{
			Scanner lerfich = new Scanner(new File("numbers_ex3.txt"));
			while(lerfich.hasNextLine()){				
				numero = lerfich.nextInt();
				lerfich.next();
				s = lerfich.next();
				lerfich.nextLine();
				mapa.put(s,numero);
			}
			lerfich.close();
		}catch(FileNotFoundException e){
			System.err.println("File not found");
			System.exit(1);
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Frase: ");
		int nb = 0;
		int res=0;
		if(!sc.hasNext()){
			System.err.println("Operacao invalida");
			System.exit(1);
		}else{
			String aux = sc.nextLine();
			String frase [] =aux.split(" ");
			for(int i =0;i<frase.length;i++){
				//System.out.print(frase[i]);
				if(mapa.get(frase[i]) == null){
					System.out.println("Frase errada");
					System.exit(1);
				}else{
					int n = mapa.get(frase[i]);
					if(Math.log10(n) == (int) Math.log10(n)){
						nb *= n;
					}else{
						if(nb!= 0){
							res +=nb;
						}
						nb=n;
					}
				}
			}
			res+=nb;
		System.out.println(" " + res);
				
		}
		
		
		sc.close();
	}
}
