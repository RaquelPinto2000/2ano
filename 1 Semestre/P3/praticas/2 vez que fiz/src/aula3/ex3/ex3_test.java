//Raquel Resende Milheiro Pinto nºMEC = 92948
package aula3.ex3;
import static java.lang.System.*;

public class ex3_test {
	public static void main(String[] args) {
		out.println("--------------------------Teste do programa--------------------------");
		out.println();
		// carta 
		Carta mota = new Carta("A");
		Carta carro = new Carta("B");
		Carta pesadomerc= new Carta("C");
		Carta pesadopass = new Carta("D");
		
		//condutor
		Condutor c1= new Condutor("Joao",14785467,new Data(11,12,2000),mota);
		Condutor c2 = new Condutor("Pedro",14345487,new Data(11,1,1942),carro);
		Condutor c3 = new Condutor("Lucia",14725347,new Data(17,5,1984),pesadomerc);
		Condutor c4 = new Condutor("Marta",16786354,new Data(18,12,1954),pesadopass);
		
		//Pessoas
		Pessoa p1 = new Pessoa("Raquel",19765334,new Data(11,12,2000));
		Pessoa p2 = new Pessoa("Simao",19895334,new Data(10,8,1955));
		Pessoa p3 = new Pessoa("Tiago",19794534,new Data(8,10,1972));
		Pessoa p4 = new Pessoa("Sofia",19700334,new Data(16,1,1942));
		Pessoa p5 = new Pessoa("Beatriz",197795334,new Data(18,11,1988));
		Pessoa p6 = new Pessoa("Rodrigo",19795334,new Data(29,9,1855));
		
		
		//veiculos
		Veiculo veiculo = new Veiculo(c1,11,125.4,1,3000.1,mota);
		Motociclo motaS = new Motociclo(c1,15,135.44,1,3070.1,false);
		Motociclo motaC = new Motociclo(c1,20,125.4,1,3000.1,true);
		Ligeiro carro1 = new Ligeiro(c2,40,156.6,5,5000.5,"amarelo");
		Ligeiro carro2 = new Ligeiro(c2,50,200,5,5444,"preto");
		PesadoMerc camiao = new PesadoMerc(c3, 70,250,3,8055);
		camiao.tipocarga("materias perigogas");
		PesadoPass autocarro = new PesadoPass(c4,80,300,20,10000);
		autocarro.entrapessoa(1,p1);
		autocarro.entrapessoa(1,p3);
		out.println(autocarro.toString());
		out.println();
		autocarro.saidapessoas(2);
		autocarro.entrapessoa(1,p2);
		autocarro.nextparagem("Leiria");
		out.println();
		autocarro.nextparagem("Aveiro");
		out.println();
		out.println(veiculo.toString());
		out.println();
		out.println(motaS.toString());
		out.println();
		out.println(motaC.toString());	
		out.println();
		out.println(carro1.toString());
		out.println();
		out.println(carro2.toString());
		out.println();
		out.println(camiao.toString());
		out.println();
		out.println(autocarro.toString());
		
	}
}
