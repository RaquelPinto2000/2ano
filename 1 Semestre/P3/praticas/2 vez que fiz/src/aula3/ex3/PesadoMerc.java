package aula3.ex3;

import static java.lang.System.out;

import java.util.Arrays;

public class PesadoMerc extends Veiculo{
	static private int ncargava=0;
	private int ncarga = 0; //se tiver a 0 quer dizer que nao tem carga se for 1 tem
	private String cargas[] = {"materias perigogas" , "produtos Industriais" , "produtos Agriculas", "roupa", "animais"};
	private String carga = "";
	public PesadoMerc(Condutor condutor, double cilindrada, double potencia, double lotacao, double peso) {
		super(condutor, cilindrada, potencia, lotacao, peso, new Carta("C"));

	}
	
	public void tipocarga(String c) {
		for (int i = 0; i < cargas.length; i++) {
			if(c.equals(cargas[i])) {
				carga=c;
				return;
			}
		}
		out.println("Nao posso trasportar essa carga");
	}

	@Override
	public String toString() {
		return "PesadoMerc [ncarga=" + ncarga + ", cargas=" + Arrays.toString(cargas) + ", carga=" + carga + "]" + super.toString();
	}
	
	
}
