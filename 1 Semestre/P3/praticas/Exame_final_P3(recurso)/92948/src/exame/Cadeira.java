package exame;

public class Cadeira extends Mobiliario{
	private TipoCadeira tipoC; // tipo de cadeira
	private int napoio; //numero de apoios
	private double altura;
	
	public Cadeira(String nome, int id, Tipo material, TipoCadeira tipoC,  double altura,int napoio) {
		super(nome, id, material);
		this.tipoC = tipoC;
		this.napoio = napoio;
		this.altura = altura;
	}
	
	public TipoCadeira getTipoC() {
		return tipoC;
	}
	public int getNumapoio() {
		return napoio;
	}
	public double getAltura() {
		return altura;
	}

	@Override
	public String toString() {
		return "Cadeira do tipo " + tipoC + "com " + napoio + " apoios e altura " + altura ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(altura);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + napoio;
		result = prime * result + ((tipoC == null) ? 0 : tipoC.hashCode());
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
		Cadeira other = (Cadeira) obj;
		if (Double.doubleToLongBits(altura) != Double.doubleToLongBits(other.altura))
			return false;
		if (napoio != other.napoio)
			return false;
		if (tipoC != other.tipoC)
			return false;
		return true;
	}
	
	
	
}