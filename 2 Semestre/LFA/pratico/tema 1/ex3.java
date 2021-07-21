import java.util.*;
import java.io.*;
public class ex3 {
	
	public static void main (String[] args) {
		int numero=0;
		String s ="";
		String ver="";
		Map<String,Integer> mapa = new HashMap<>();
		try{
			Scanner lerfich = new Scanner(new File("numbers_ex3.txt"));
			while(lerfich.hasNextLine()){
				/*if(lerfich.hasNextInt()){
					System.out.print("ola");
					numero = lerfich.nextInt();
					ver = lerfich.next();
					if (ver.equals(" ")){
						ver = lerfich.next();
						if(ver.equals("-")){
							ver = lerfich.next();
							if(ver.equals(" ")){
								if(lerfich.hasNext()){
									s = lerfich.next();
								}else{
									System.err.println("Operacao invalida");
									System.exit(1);
								}
							}
						}
					
					}
				}else{
					System.err.println("Operacao invalida");
					System.exit(1);
				}
				*/
				
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
		if(!sc.hasNext()){
			System.err.println("Operacao invalida");
			System.exit(1);
		}else{
			String aux = sc.nextLine();
			String frase [] =aux.split(" ");
			for(int i =0;i<frase.length;i++){
				if(mapa.get(frase[i]) == null){
					System.out.println("Frase errada");
					System.exit(1);
				}else{
					System.out.print(mapa.get(frase[i]) + " ");
				}
			}	
		}
		sc.close();
	}
}

