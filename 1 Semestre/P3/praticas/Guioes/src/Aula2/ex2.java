package Aula2;

import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class ex2 {
	
	static Scanner sc = new Scanner(System.in);
	public static void main ( String[] args) throws IOException{
		out.print("Nome do ficheiro: ");
		String nome = sc.nextLine();
		Jogo j = new Jogo (nome);
		j.jogar();
		j.printjogo();
	}

}