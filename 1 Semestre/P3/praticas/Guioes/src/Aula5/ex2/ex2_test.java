//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex2;
import static java.lang.System.*;

public class ex2_test {

	public static void main(String[] args) {
		
		//CORES
		Cor azul = Cor.azul;
		Cor roxo = Cor.roxo;
		Cor verde = Cor.verde;
		Cor amarelo = Cor.amarelo;
		Cor vermelho = Cor.vermelho;
		
		//MATRICULAS
		String matricula1 = "FG-27-32";
		String matricula2 = "20-MT-13";
		String matricula3 = "BE-90-71";
		String matricula4 = "GE-90-36";
		String matricula5 = "66-IO-71";
		String matricula6 = "56-LJ-89";
		String matricula7 = "PP-90-01";
		
		//Veiculos
		Veiculo mota = new moto(vermelho, 120, 1500, 75, matricula6,true);
		Veiculo carro = new automovel(4, azul, 280, 3000, 72, matricula7,false);
		Veiculo bicicleta = new Bicicleta(verde, 0.58);
		
		moto motaSemAtrelado = new moto(vermelho, 120, 1500, 30,matricula1, false);
		moto motaComAtrelado = new moto(roxo, 120, 1500,40, matricula2, true);
		automovel carroAzulTrancado = new automovel(4,azul, 280, 3000,50 , matricula3, true);
		automovel carroAmareloDestrancado = new automovel(4,amarelo, 280, 3000, 88,matricula4, false);
		Bicicleta bicicletaVerde = new Bicicleta(verde, 0.58);
		
		//Veiculos da policia
		CarroPolicia carroPolicia = new CarroPolicia(4,azul, 120, 1500,77, matricula5, true, true);
		MotoPolicia motaPolicia = new MotoPolicia(azul, 120, 2000, 20,matricula6, false);
		BicicletaPolicia bicicletaPolicia = new BicicletaPolicia(azul, 0.58);
		
		
		out.println("TESTE DE VEICULOS:");
		Veiculo dummyVeiculo = mota;
		out.println("O objeto é uma "+dummyVeiculo); //MOTO
		dummyVeiculo = carro;
		out.println("O objeto é um "+dummyVeiculo);//AUTOMOVEL
		dummyVeiculo = bicicleta;
		out.println("O objeto é uma "+dummyVeiculo);//BICICLETA
		
		out.println();
		out.println("TESTE DE MOTAS: ");
		moto dummyMoto = motaSemAtrelado;
		out.println("A "+dummyMoto+" de matricula "+dummyMoto.matricula()+ //FG-27-32
						   (dummyMoto.malote()?"":" não")+					 //Sem atrelado
						   " tem atrelado e tem cor "+dummyMoto.cor());		 //VERMELHO
		
		dummyMoto = motaComAtrelado;
		out.println("A "+dummyMoto+" de matricula "+dummyMoto.matricula()+ //20-MT-13
			   (dummyMoto.malote()?"":" não")+" tem atrelado e tem cor "+   //Com atrelado
			   dummyMoto.cor());												 //ROXO
		
		out.println();
		out.println("TESTE DE CARROS: ");
		automovel dummyCarro = carroAzulTrancado;
		out.println("O "+dummyCarro+" de matricula "+dummyCarro.matricula()+ 	//BE-90-71			  
						(dummyCarro.Trancado()?"":" não")+			  			//Trancado
						" está trancado e tem cor "+dummyCarro.cor()); 			//AZUL
		
		dummyCarro = carroAmareloDestrancado;
		out.println("O "+dummyCarro+" de matricula "+dummyCarro.matricula()+  //GE-90-36
			(dummyCarro.Trancado()?"":" não")+									//Destrancado
			" está trancado e tem cor "+dummyCarro.cor()); 						//AMARELO
	
		out.println();
		out.println("TESTE DE BICICLETAS: ");
		out.println("A "+bicicletaVerde+" tem um selim de altura "+
						bicicletaVerde.alturaSelim()+"m e tem cor "+bicicletaVerde.cor());
	
		out.println();
		out.println("TESTE DE VEICULOS DA POLICIA: ");
		out.println("O "+carroPolicia+" de matricula "+carroPolicia.matricula()+
						", de ID "+carroPolicia.ID()+
						" e de cor "+carroPolicia.cor()+
						", tem as sirenes "+(carroPolicia.sirene()?"":"des")+"ligadas"); //Ligadas
		carroPolicia.controlesirene(); //Desliga as sirenes
		out.println("O "+carroPolicia+" de matricula "+carroPolicia.matricula()+
			", pertence ao Serviço de Emergência "+carroPolicia.getTipo()+				//PJ
			", de ID "+carroPolicia.ID()+											//ID = 9
			" e de cor "+carroPolicia.cor()+											//AZUL
			", tem as sirenes "+(carroPolicia.sirene()?"":"des")+"ligadas");   //Desligadas
		
		out.println("A "+motaPolicia+", tem uma cilindrada de "+motaPolicia.getCilindrada()+		//2000
						", de potencia "+motaPolicia.getPotencia()+ "com " + motaPolicia.getCombustivel() + "de combustivel" +
						" e "+(motaPolicia.malote()?"":"não")+" tem atrelado"); 				//Não tem atrelado
		
		out.println("A "+bicicletaPolicia+" pertence ao Serviço de Emergência "+bicicletaPolicia.getTipo()+
						", tem cor "+bicicletaPolicia.cor()+
						" e tem selim de altura "+bicicletaPolicia.alturaSelim()+"m");		
		
	}
}
