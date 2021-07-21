package Aula9.ex3;
import java.util.*;

public class VectorPessoas {
	private int totalpessoas=0;
	private VectorIterator iterator;
	private Pessoa[] pessoas;
	
	public VectorPessoas(int totalpessoas) {
		this.totalpessoas = totalpessoas;
		iterator = new VectorIterator();
		pessoas = new Pessoa[totalpessoas];
	}
	public VectorPessoas() {
		//iterator = new VectorIterator();
		this(0);
	}
	
	public boolean addPessoa(Pessoa p) {
		capacidade(totalpessoas+1);
		pessoas[totalpessoas++]=p;
		return true;
	}
	public void capacidade(int nova) {
		int velho = pessoas.length;
		if(nova>velho) {
			int novoespaco = (velho * 3)/2+1;
			if(novoespaco<nova) {
				novoespaco=nova;
			}
			pessoas=Arrays.copyOf(pessoas,novoespaco);
		}
	}
	
	public boolean removePessoa(Pessoa p) {
		boolean b= false;
		for(int i=0;i<pessoas.length;i++) {
			if(pessoas[i]==p) {
				pessoas[i]=null;
				totalpessoas--;
				b=true;
				break;
			}
		}
		Pessoa aux [] = new Pessoa[totalpessoas];
		for(int j =0 ;j<totalpessoas;j++) {
			if(pessoas[j]!=null) {
				aux[j]=pessoas[j];
			}
		}
		pessoas=aux;
		return b;
	}
	
	public int totalPessoas() {
		return totalpessoas;
	}
	
	public Iterator iterator() {
		return iterator;
	}
	
	private class VectorIterator implements Iterator{
		int count=0;
		@Override
		public boolean hasNext() {
			return count<totalpessoas;
		}

		@Override
		public Object next() {
			int i =count;
			if(i>=totalpessoas) {
				throw new NoSuchElementException();
			}
			count = i+1;
			return (Pessoa)pessoas[i];
		}
		
		public void remove() {
			remove();
		}
	}
}


