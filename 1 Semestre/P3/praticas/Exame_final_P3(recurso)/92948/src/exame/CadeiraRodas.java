package exame;

public class CadeiraRodas extends Cadeira implements Transporte{
	private int nrodas; 
	private boolean eletrica; // se e ou nao
	
	public CadeiraRodas(String nome, int id, Tipo material, TipoCadeira tipoC, double altura, int napoio, int nrodas,
			boolean eletrica) {
		super(nome, id, material, tipoC, altura, napoio);
		this.nrodas = nrodas;
		this.eletrica = eletrica;
	}
	
	public TipoTransporte getTipo() {
		return TipoTransporte.MobilidadeReduzida; 
	}
	public TipoTransporte setTipo(TipoTransporte tipo) {
		return tipo; 
	}
	
	public boolean Eletrica() {
		return eletrica;
	}
	
	public int getNRodas() {
		return nrodas;
	}
	
	@Override
	public String toString() {
		return "CadeiraRodas [nrodas=" + nrodas + ", eletrica=" + eletrica + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (eletrica ? 1231 : 1237);
		result = prime * result + nrodas;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadeiraRodas other = (CadeiraRodas) obj;
		if (eletrica != other.eletrica)
			return false;
		if (nrodas != other.nrodas)
			return false;
		return true;
	}
	

}
	