//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula4.ex1;

public class Professor extends People {
	static private int nfuncionario=1;
	
	private int nfunc;
	private Data dataA;
	
	public Professor(String nome, int cc, Data datanac) {
		super(nome,cc,datanac);
		nfunc=nfuncionario++;
		dataA=new Data();
	}
	
	public int nfunc() {
		return nfunc;
	}
	
	public Data dataAdmissao() {
		return dataA;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", NºFUNC = " + nfunc + ", Admitido na data: " + dataA;
	}
	

}
