package Aula10.ex1;
import java.util.*;
public class VectorGeneric <T> {

	private int totalpessoas=0;
	private VectorIterator iterator;
	private Object[] elementos;
	
	public VectorGeneric(int totalpessoas) {
		this.totalpessoas = totalpessoas;
		iterator = new VectorIterator();
		elementos = new Object[totalpessoas];
	}
	public VectorGeneric() {
		//iterator = new VectorIterator();
		this(0);
	}
	
	public boolean addElem(T elem) {
		capacidade(totalpessoas+1);
		elementos[totalpessoas++]=elem;
		return true;
	}
	public void capacidade(int nova) {
		int velho = elementos.length;
		if(nova>velho) {
			int novoespaco = (velho * 3)/2+1;
			if(novoespaco<nova) {
				novoespaco=nova;
			}
			elementos=Arrays.copyOf(elementos,novoespaco);
		}
	}
	
	public boolean removePessoa(Pessoa p) {
		boolean b= false;
		for(int i=0;i<elementos.length;i++) {
			if(elementos[i]==p) {
				elementos[i]=null;
				totalpessoas--;
				b=true;
				break;
			}
		}
		Object aux [] = new Object[totalpessoas];
		for(int j =0 ;j<totalpessoas;j++) {
			if(elementos[j]!=null) {
				aux[j]=elementos[j];
			}
		}
		elementos=aux;
		return b;
	}
	
	public int totalElem () {
		return totalpessoas;
	}
	
	public Iterator iterator() {
		return iterator;
	}
	
	private class VectorIterator <T> implements Iterator <T>{
		int count=0;
		@Override
		public boolean hasNext() {
			return count<totalpessoas;
		}

		@Override
		public T next() {
			int i =count;
			if(i>=totalpessoas) {
				throw new NoSuchElementException();
			}
			count = i+1;
			return (T)elementos[i];
		}
		
		public void remove() {
			remove();
		}
	}	
}
