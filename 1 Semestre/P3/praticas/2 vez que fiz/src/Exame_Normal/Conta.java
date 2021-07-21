package Exame_Normal;
import java.util.*;
public class Conta implements Comparable<Conta> {
	private static int number =1;
	private int num;
	private Cliente cliente;
	private double saldo;
	private List<Movimento> mov;
	
	public Conta(Cliente c) {
		num = number;
		number +=1;
		this.cliente = c;
		saldo=0;
		mov = new ArrayList<Movimento>();
	}
	
	public void add(Movimento c) {
		if(c.getClass().getSimpleName().equals("Credito")) {
			saldo += c.getMontante();
		}else {
			saldo -= c.getMontante();
		}
	}
	
	public int getNumber() {
		return num;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public double getSaldo() {
		return saldo;
	}
	
	public List <Movimento>getMovimentos() {
		return mov;
	}

	@Override
	public String toString() {
		return "N: " + num + ",Cliente: "+ cliente.getNome()+", Movimentos:" + mov + "[" + cliente.getTipo().toString() + "]" ;
	}
	
	
	//se o daqui < que o que vem retorna -1
	//se o daqui > que o que vem retorna 1
	//se o daqui = que o que vem retorna 0
	public int compareTo(Conta c) {
		if(num<c.getNumber()) {
			return -1;
		}else if(num>c.getNumber()) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((mov == null) ? 0 : mov.hashCode());
		result = prime * result + num;
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (mov == null) {
			if (other.mov != null)
				return false;
		} else if (!mov.equals(other.mov))
			return false;
		if (num != other.num)
			return false;
		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		return true;
	}
	
	
	
	
}
