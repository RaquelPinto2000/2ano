package aula6.ex1;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Ementa {
	private String nome;
	private String local;
	private HashMap<DiaSemana , LinkedList<Prato>> prato = new HashMap<>();
	
	public Ementa(String nome, String local) {
		this.nome = nome;
		this.local = local;
	}
	
	public void addPrato(Prato p , DiaSemana dia) {
		if(prato.containsKey(dia)) {
			prato.get(dia).insert(p);
		}else {
			LinkedList<Prato> aux = new LinkedList<>();
			aux.insert(p);
			prato.put(dia, aux);
		}
	}
	
	
	public void storeEmenta()throws IOException	{
		PrintWriter printer = new PrintWriter(new File("Ementas.txt"));
		printer.print(this.toString());
		printer.close();
	}
	
	
	public void removeEmenta(Prato p , DiaSemana dia) {
		if(prato.containsKey(dia)) {
			prato.get(dia).removeFirst();
		}else {
			System.out.println("Nao existe esse prato");
		}
	}

	@Override
	public String toString() {
		return "Ementa [nome=" + nome + ", local=" + local + ", prato=" + prato + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((prato == null) ? 0 : prato.hashCode());
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
		Ementa other = (Ementa) obj;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (prato == null) {
			if (other.prato != null)
				return false;
		} else if (!prato.equals(other.prato))
			return false;
		return true;
	}
	
	
	
}
