
public class Empresa extends Cliente {
	private String nome;
	private String numero;
	private TipoCliente tipo;
	public Empresa(String nome, String numero, TipoCliente tipo ,Cliente c) {
		super(c.nome(), c.numcontribuinte());
		this.nome = nome;
		this.numero=numero;
		this.tipo = tipo;
	}
	
	public String nome () {
		return nome;
	}
	public String numbalco() {
		return numero;
	}
	public TipoCliente tipocliente() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Empresa [nome=" + nome + ", numero=" + numero + ", tipo=" + tipo + "]";
	}
	
	
}
