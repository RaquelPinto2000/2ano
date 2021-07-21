package exame;
// adicionar o que falta....

import java.util.*;
import java.io.*;
import java.lang.Iterable.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class P3_19 {


	public static void main(String[] args) throws IOException {
		// ********* Alínea 1 *********
		
		Cadeira cad1 = new Cadeira("Elite-2", 2034, Tipo.Sintetico, TipoCadeira.Atendimento, 0.9, 1);
		CadeiraRodas cad2 = new CadeiraRodas("Mobileplus", 3211, Tipo.Metal, TipoCadeira.Escritorio, 
				      0.8, 4, 6, false);
		cad2.setTipo(TipoTransporte.MobilidadeReduzida);
		Cama cama1 = new Cama("Fofinha", 4323, Tipo.Madeira, 1.90, 1.10, true);
		CamaArticulada cart1 = new CamaArticulada("MaxFlex2000", 4124, Tipo.Metal, 1.90, 1.20, true, true); // true=manual 
		Marquesa marq1 = new Marquesa("Zx20", 1234, Tipo.Metal, 1.80, 0.9, true, false);
		Maca maca1 = new Maca("SpeedX2", 9232, Tipo.Metal, 2.00, 0.8, false, 2);
		maca1.setTipo(TipoTransporte.Urgente);
		
		Clinica cl = new Clinica("Boa Saúde");
		
		System.out.println("Alínea 1) ----------------------------------");
		System.out.println("\n----- Insercao Mobiliario -----");
		System.out.print(cl.addMobiliario(cad1) + ", ");  	// true
		System.out.print(cl.addMobiliario(cad1) + ", ");  	// false
		System.out.print(cl.addMobiliario(cad2) + ", ");  	// true
		System.out.print(cl.addMobiliario(cama1) + ", ");  	// true
		System.out.print(cl.addMobiliario(cart1) + ", ");  	// true
		System.out.print(cl.addMobiliario(marq1) + ", ");  	// true
		System.out.println(cl.addMobiliario(maca1) + ", ");  // true
		
		
		System.out.println("\n----- Listagem de todo o Mobiliario #Alinea 1 -----");
		System.out.println(cl);
		
		
		// ********* Alínea 2 *********
		// a)
		alinea2a(cl, cad1);
		
		// b)
		alinea2b(cl);
		
		// c)
		alinea2c();
		
	}
	
	// Nota: Não pode alterar o corpo do método alinea2a
	private static void alinea2a(Clinica cl, Cadeira cad1){
		System.out.println("\n----- #Alínea 2 a)");
		System.out.println("\n--- Listagem de todo o Mobiliario  -----");
		for (Mobiliario mob : cl) 
			System.out.println(mob);
		
		cl.removeMobiliario(cad1);

		System.out.println("\n--- Lista das duas primeiras peças de Mobiliario -----");
		for (Iterator<Mobiliario> ri = cl.rangeIterator(0,1); ri.hasNext();)
			System.out.println(ri.next());
	}
	
	
	// Nota: Não pode alterar o corpo do método alinea2a
	private static void alinea2b(Clinica cl){
		System.out.println("\n----- #Alínea 2 c) \n--- Listagem de Mobiliario de Transporte -----");
		List<Transporte> listTrans = cl.listTransportes();						
		for (Transporte t : listTrans) 
			System.out.println("Elemento:" + t + " para transporte " + t.getTipo());
	}
	
	// Nota: Deve completar este método
	private static void alinea2c() throws IOException{
		System.out.println("\n----- #Alínea 2 d) \n--- Leitura Ficheiro e Impressão de Resultado de Pesquisa -----");	 
		// introduza código aqui...
		List<String> fileArray;
		fileArray = Files.readAllLines(Path.of("mobiliario.txt"));
		for (int i = 0; i < fileArray.size(); i++) {
			String s[] = fileArray.get(i).split(":");
			if(s[0].equals("Cidade")) {
				System.out.println(s[0] + s[1]);
			}
		}
	
	}	
}
