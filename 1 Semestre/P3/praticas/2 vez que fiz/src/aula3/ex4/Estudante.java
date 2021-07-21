//Raquel Resende Milheiro Pinto nºMEC = 92948
package aula3.ex4;

public class Estudante extends Pessoa{

	private String curso;
	private int NMEC;
	
	
	public Estudante(String nome, int NMEC, int cc,String curso,Data datanasc, int nsocio, Data datainsc, int requesitou) {
		super(nome, cc, datanasc,nsocio, datainsc, requesitou);
		this.NMEC = NMEC;
		this.curso = curso;
	}
	
	public int NMEC() {
		return NMEC;
	}
	public String curso() {
		return curso;
	}
	


}
