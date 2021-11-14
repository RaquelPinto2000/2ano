package Aula13.ex1.parte1;
import java.util.*;
import java.util.stream.Collectors;
public class Pais implements Comparable<Pais>{
	private String nome;
	private Localidade capital;
	private final List<Regiao> regioes = new ArrayList<>();
	
	public Pais(String nome) {
		this.nome = nome;
	}

	public Pais(String nome, Localidade capital) {
		this.nome = nome;
		this.capital = capital;
	}

	public void addRegiao(Regiao regiao) {
		regioes.add(regiao);
	}
	
	public int populacaototal() {
		return regioes.stream().collect(Collectors.summingInt(Regiao::populacao));
	}

	@Override
	public String toString() {
		String s="";
		if(capital!= null) {
			s=capital.toString();
		}else {
			s = "*Indefinida*";
		}
		return "Pais: " + nome + ", População: " + populacaototal() + "(Capital: " + s + ")";
		//return String.format("Pais: %s, População: %d (Capital: %s)", nome, populacaototal(),capital!=null?capital:"*Indefinida*");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((regioes == null) ? 0 : regioes.hashCode());
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
		Pais other = (Pais) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (regioes == null) {
			if (other.regioes != null)
				return false;
		} else if (!regioes.equals(other.regioes))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Pais arg0) {
		return nome.compareTo(arg0.nome);
	}
}
