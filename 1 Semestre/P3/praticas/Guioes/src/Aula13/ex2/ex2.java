package Aula13.ex2;

import java.io.FileWriter;
import java.io.IOException;

public class ex2 {
	public static void main(String[] args) throws IOException {
		String filepath = "guiao13_files/Policarpo.txt";
		Word counter = new Word(filepath);
		System.out.println(counter.toString());
		FileWriter fw = new FileWriter("guiao13_files/ex2_guiao13_resultado.txt");
		fw.write(counter.toString());
		fw.close();
	}
}
