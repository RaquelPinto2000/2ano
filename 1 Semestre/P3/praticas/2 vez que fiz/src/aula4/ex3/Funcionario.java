//Raquel Resende Milheiro Pinto nºMEC = 92948
package aula4.ex3;

public class Funcionario extends Pessoa{
		
		private int NFUNC;
		private int NFISC;

		
		public Funcionario(String nome, int cc, Data datanasc, int NFUNC, int NFISC, int nsocio, Data datainsc, int requesitou) {
			super(nome,cc,datanasc,nsocio,datainsc,requesitou);
			this.NFUNC = NFUNC;
			this.NFISC = NFISC;			
		}
		
		public int NFUNC() {
			return NFUNC;
		}
		public int NFISC() {
			return NFISC;
		}
}
