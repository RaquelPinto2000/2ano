
public class Conta {
	private int number=0;
	private Cliente c;
	private double saldo;
	private int mov;
	
	public Conta(Cliente c) {
		this.c=c;
		number++;
	}
	
	public int number() {
		return number;
	}
	
	public Cliente c() {
		return c;
	}
	public int movimentos() {
		return mov;
	}
	
	public double saldo() {
		return saldo;
	} 
	public double add (Movimento novo) {
		return saldo = saldo() + novo.montante();
		
	}
	@Override
	public String toString() {
		return "Conta [number=" + number + ", c=" + c + ", saldo=" + saldo + ", mov=" + mov + "]";
	}
	
}
