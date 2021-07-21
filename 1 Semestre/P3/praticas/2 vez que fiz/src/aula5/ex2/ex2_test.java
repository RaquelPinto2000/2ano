package aula5.ex2;

import static java.lang.System.*;
import java.util.*;

public class ex2_test {
	public static void main(String[] args) {
		//CORES
		cor azul = cor.azul;
		cor castanho = cor.castanho;
		cor verde = cor.verde;
		cor amarelo = cor.amarelo;
		cor vermelho = cor.vermelho;
		
		// Associacao tipo
		associacao PSP = associacao.PSP;
		associacao PJ = associacao.PJ;
		associacao Bombeiros = associacao.Bombeiros;
		associacao INEM = associacao.INEM;
		associacao GNR = associacao.GNR;
		
		//MATRICULAS
		String matricula1 = "FG-27-32";
		String matricula2 = "20-MT-13";
		String matricula3 = "BE-90-71";
		String matricula4 = "GE-90-36";
		String matricula5 = "66-IO-71";
		String matricula6 = "56-LJ-89";
		String matricula7 = "PP-90-01";
		//Veiculos
		Veiculo mota = new moto(2,vermelho, 120, 1500, 75, matricula6);
		Veiculo carro = new automovel(4, azul, 280, 3000, 72, matricula7);
		Veiculo bicicleta = new Bicicleta(2,verde,matricula1);
		
		moto mota1 = new moto(2,vermelho, 120, 1500, 30,matricula1);
		moto mota2 = new moto(2,castanho, 120, 1500,40, matricula2);
		automovel carroAzul = new automovel(4,azul, 280, 3000,50 , matricula3);
		automovel carroAmarelo = new automovel(4,amarelo, 280, 3000, 88,matricula4);
		Bicicleta bicicletaVerde = new Bicicleta(2,verde, matricula5);
		
		//Veiculos da policia
		CarroPolicia carroPolicia = new CarroPolicia(4,azul, 120, 1500,77, matricula5,GNR);
		MotoPolicia motaPolicia = new MotoPolicia(2,azul, 120, 2000, 20,matricula6, PSP);
		BicicletaPolicia bicicletaPolicia = new BicicletaPolicia(2,azul, INEM, matricula4);
		
		out.println("TESTE DE VEICULOS: ");
		Veiculo dummyVeiculo = mota;
		out.println("O objeto é uma "+dummyVeiculo); //MOTO
		dummyVeiculo = carro;
		out.println("O objeto é um "+dummyVeiculo);//AUTOMOVEL
		dummyVeiculo = bicicleta;
		out.println("O objeto é uma "+dummyVeiculo);//BICICLETA
		
		out.println();
		out.println("TESTE DE MOTAS: ");
		moto dummyMoto = mota1;
		out.println("A "+dummyMoto+" de matricula "+dummyMoto.matricula()+ //FG-27-32
						   " moto de cor "+dummyMoto.cor());		 //VERMELHO
		
		dummyMoto = mota2;
		out.println("A "+dummyMoto+" de matricula "+dummyMoto.matricula()+ //20-MT-13
			" moto tem cor "+  dummyMoto.cor());							 //castanho
		
		out.println();
		out.println("TESTE DE CARROS: ");
		automovel dummyCarro = carroAzul;
		out.println("O "+dummyCarro+" de matricula "+dummyCarro.matricula()+ 	//BE-90-71			  
						"  tem cor "+dummyCarro.cor()); 			//AZUL
		
		dummyCarro = carroAmarelo;
		out.println("O "+dummyCarro+" de matricula "+dummyCarro.matricula()+  //GE-90-36
			" tem cor "+dummyCarro.cor()); 						//AMARELO
	
		out.println();
		out.println("TESTE DE VEICULOS DA POLICIA: ");
		out.println("O "+carroPolicia+" de matricula "+carroPolicia.matricula()+
						", de ID "+carroPolicia.ID()+
						" e de cor "+carroPolicia.cor());
		
		out.println("O "+carroPolicia+" de matricula "+carroPolicia.matricula()+
			", pertence ao Serviço de Emergência "+carroPolicia.getTipo()+				//PJ
			", de ID "+carroPolicia.ID()+											//ID = 9
			" e de cor "+carroPolicia.cor());
		
		out.println("A "+motaPolicia+", tem uma cilindrada de "+motaPolicia.getCilindrada()+		//2000
						", de potencia "+motaPolicia.getPotencia()+ "com " + motaPolicia.vMax() + "de combustivel");
		
		out.println("A "+bicicletaPolicia+" pertence ao Serviço de Emergência "+bicicletaPolicia.getTipo()+
						", tem cor "+bicicletaPolicia.cor());
	}
}
