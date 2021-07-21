
public class Cliente {
	private String nome;
	private String Nc ;
	private TipoCliente tipo ;
	
	public Cliente(String nome, String nc) {
		this.nome = nome;
		Nc = nc;
		tipo = TipoCliente.Balcao;
	}
	public Cliente(String nome, String nc, TipoCliente tipo) {
		this.nome = nome;
		Nc = nc;
		this.tipo = tipo;
	}
	public Cliente(String nome, TipoCliente tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public Cliente (String nome) {
		this.nome=nome;
	}
	public String nome () {
		return nome;
	}
	public String numcontribuinte() {
		return Nc;
	}
	public TipoCliente tipocliente() {
		return tipo;
	}
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", Nc=" + Nc + ", tipo=" + tipo + "]";
	}
	
}
