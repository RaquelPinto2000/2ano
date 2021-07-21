package aula9.ex3;
import java.util.*;
public class VetorPessoas {
	private Pessoa[] listapessoas;
	private int nPessoas;
	private final int ALLOC = 50;
	private int dimClasse = ALLOC;
	
	public VetorPessoas() {
		listapessoas= new Pessoa[ALLOC];
		nPessoas =0;
	}
	
	
	public boolean addPessoa(Pessoa p) {
		if(p ==null) {
			return false;
		}
		if(nPessoas>dimClasse) {
			dimClasse+=ALLOC;
			Pessoa pe [] = new Pessoa[dimClasse];
			System.arraycopy(listapessoas, 0, pe, 0, nPessoas);
			listapessoas = pe;
		}
		
		listapessoas[nPessoas++]=p;
		return true;
	}
	
	public boolean removePessoa(Pessoa p) {
		for (int i = 0; i < listapessoas.length; i++) {
			if(listapessoas[i]==p) {
				nPessoas--;
				for (int j = i; j < listapessoas.length; j++) {
					listapessoas[j]=listapessoas[j+i];
					return true;
				}
			}
		}
		return false;
	}
	public int totalPessoas() {
		return nPessoas;
	}
	
	public Pessoa getPessoa(int i) {
		return listapessoas[i];
	}
	
	
	public Iterator iterator() {
		return (this).new VectorIterator();
	}
	
	
	private class VectorIterator implements Iterator{
		int count=0;
		@Override
		public boolean hasNext() {
			return count<nPessoas;
		}

		@Override
		public Object next() {
			int i =count;
			if(i>=nPessoas) {
				throw new NoSuchElementException();
			}
			count = i+1;
			return (Pessoa)listapessoas[i];
		}
		
		public void remove() {
			remove();
		}
	}
}
