package aula6.ex2;



public class Estudante extends Pessoa{
	static private int nMec =100;
	private Data datainsc;
	private int count;
	
	public Estudante(String nome,int cc, Data dataNasc){
		super( nome,cc,dataNasc);
		datainsc = new Data();
		count = nMec++;
		
	}
	public Estudante(String nome, int cc,Data datanasc, Data datainsc) {
		super(nome, cc, datanasc);
		this.datainsc = new Data (datainsc.dia(),datainsc.mes(),datainsc.ano());
		count = nMec++;
	}
	
	public int nMec() {
		return count;
	}
	public Data datainsc() {
		return datainsc;
	}
	public Data data() {
		return datainsc;
	}
	@Override
	public String toString() {
		return super.toString() + ", Nº MEC: " + count + ", Inscrito em Data: " + datainsc;
	}
	

}
