package aula4.ex1;

public class Professor extends Pessoa{
	private static int nfunc=0;
	private Data dataAdmissao;
	private int num;
	
	public Professor(String nome, int cc, Data dataNasc, Data dataAdmissao) {
		super(nome, cc, dataNasc);
		num= nfunc++;
		this.dataAdmissao = dataAdmissao;
	}
	
	public Professor(String nome, int cc, Data dataAdmissao) {
		this(nome,cc,new Data(),dataAdmissao);
	}

	public int numerofunc() {
		return num;
	}
	@Override
	public String toString() {
		return super.toString() + ", Nº Funcionario: " + num + ", Inscrito em Data: " + dataAdmissao;
	}
	
}
