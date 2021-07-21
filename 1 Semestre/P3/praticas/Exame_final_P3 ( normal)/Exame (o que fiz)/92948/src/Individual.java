
public class Individual extends Cliente{
	private String numtele;
	public Individual(String nome, String nc,TipoCliente tipo, String numtele) {
		super(nome, nc,tipo);
		this.numtele = numtele;
	}
	
	
	public Individual(String nome,String numtele,TipoCliente tipo) {
		super(nome,tipo);
		this.numtele = numtele;
	}
	
	public String numtelefone() {
		return numtele;
	}


	@Override
	public String toString() {
		return "Individual [numtele=" + numtele + "]";
	}
	

}
