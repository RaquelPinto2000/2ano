package aula3.ex3;

import java.util.Arrays;

public class PesadoPass extends Veiculo{
	static private int n;
	private String[] destinos = {"Aveiro", "Braganca", "Porto", "Algarve", "Lisboa", "Coimbra"};
	
	public PesadoPass(Condutor condutor, double cilindrada, double potencia, double lotacao, double peso) {
		super(condutor, cilindrada, potencia, lotacao, peso, new Carta("D"));
	}
	public int entrapessoa(int num,Pessoa p) {
		return n+=num;
	}
	public int saidapessoas(int num) {
		assert n>0;
		return n-=num;
	}
	
	public void nextparagem(String nome) {
		for (int i = 0; i < destinos.length; i++) {
			if(nome.equals(destinos[i])) {
				System.out.println("Proxima paragem: " + nome);
				return;
			}
		}
	}
	@Override
	public String toString() {
		return "PesadoPass [destinos=" + Arrays.toString(destinos) + "]" + super.toString();
	}
	
	
	
}
