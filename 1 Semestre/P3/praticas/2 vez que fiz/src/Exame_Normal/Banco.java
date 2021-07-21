package Exame_Normal;
import java.util.*;
public class Banco {
	private String nome;
	private SortedSet<Conta> contas;
	
	public Banco(String s) {
		nome=s;
		contas = new TreeSet<>();
	}
	
	public String getNome() {
		return nome;
	}
	public Set<Conta> getContas() {
		return contas;
	}
	
	public boolean add(Conta c) {
		return contas.add(c); // se adicionar ele devolve true, se nao ele devolve false;
	}
	public boolean add(int nconta, Movimento m) {
		for (var elem : contas) {
			if(elem.getNumber()==nconta) {
				elem.add(m);
				return true;
			}
		}
		return false;
	}
	
	public Iterator<Conta> iterator() {
		return contas.iterator();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contas == null) ? 0 : contas.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Banco other = (Banco) obj;
		if (contas == null) {
			if (other.contas != null)
				return false;
		} else if (!contas.equals(other.contas))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}
