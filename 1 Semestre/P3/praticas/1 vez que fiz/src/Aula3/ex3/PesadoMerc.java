//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula3.ex3;
import static java.lang.System.*;

public class PesadoMerc extends Veiculo{
	static private int ncargava=0;
	private int ncarga = 0; //se tiver a 0 quer dizer que nao tem carga se for 1 tem
	private String cargas[] = {"materias perigogas" , "produtos Industriais" , "produtos Agriculas", "roupa", "animais"};
	private String carga = "";
	
	public PesadoMerc(Condutor con, double cilin, double P, int lo, double peso) {
		super(con, cilin, P, lo, peso, new Carta("C"));
	}
	
	
	//numero de pessoas saindo uma
	public int saidamerc() {
		assert ncargava>0;
		ncarga = ncargava--;
		return ncarga;
	}
	
	//numero de pessoas entrando uma
	public int entramerc () {
		ncarga= ncargava++;
		return ncarga;
	}
	
	public void tipocarga(String c){
		for(int i =0;i<cargas.length;i++) {
			if(c.equals(cargas[i])) {
				carga=c;
				return;
			}
		}
		out.println("Nao posso trasportar essa carga");
	}
	
	public String toString() {
		return "Pessado de mercadorias que transporta " + carga + " com condutor " + super.condutor().nome() + 
				" de lotacao " + super.lotacao() + " de cilindrada " + super.cilindrada() + 
				" com pesso bruto de " + super.peso() + " de potencia de " + super.potencia();
	}
}
