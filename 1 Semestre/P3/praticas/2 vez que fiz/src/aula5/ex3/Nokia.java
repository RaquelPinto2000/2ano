package aula5.ex3;

import java.io.*;
import java.util.*;

public class Nokia implements AgendaFormat {
	
	public Pessoa[] lerinformacao (String nomefich) throws IOException{
		File fich = new File(nomefich);
		Scanner sc = new Scanner(fich);
		List <Pessoa> p = new ArrayList<>();
		while(sc.hasNextLine()) {
			String nome = sc.nextLine();
			int contacto = Integer.parseInt(sc.nextLine());
			String date = sc.nextLine();
			String data[] = date.split("/");
			Data d = new Data(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
			p.add(new Pessoa(nome,d,contacto));
		}
		sc.close();
		return p.toArray(new Pessoa[0]);   // retorna um array de p
	}
	public void escreverfich (String nome, Pessoa[] p) throws IOException{
		File fich = new File(nome);
		PrintWriter printfich = new PrintWriter(fich);
		for (int i = 0; i < p.length; i++) {
			printfich.println(p[i].nome());
			printfich.println(p[i].numero());
			printfich.println(p[i].datanasc());
			
		}
		printfich.close();
	}
}
