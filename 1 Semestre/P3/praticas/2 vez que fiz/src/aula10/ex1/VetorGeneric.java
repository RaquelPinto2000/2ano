package aula10.ex1;

import java.util.*;
public class VetorGeneric <T>{

	private Object[] listapessoas;
	private int nPessoas;
	private final int ALLOC = 50;
	private int dimClasse = ALLOC;
	
	public VetorGeneric() {
		listapessoas= new Object[ALLOC];
		nPessoas =0;
	}
	
	
	public boolean addElem(T elem) {
		if(elem ==null) {
			return false;
		}
		if(nPessoas>dimClasse) {
			dimClasse+=ALLOC;
			Object pe [] = new Object[dimClasse];
			System.arraycopy(listapessoas, 0, pe, 0, nPessoas);
			listapessoas = pe;
		}
		
		listapessoas[nPessoas++]=elem;
		return true;
	}
	
	public boolean removeElem(T elem) {
		for (int i = 0; i < listapessoas.length; i++) {
			if(listapessoas[i]==elem) {
				nPessoas--;
				for (int j = i; j < listapessoas.length; j++) {
					listapessoas[j]=listapessoas[j+i];
					return true;
				}
			}
		}
		return false;
	}
	public int totalElem() {
		return nPessoas;
	}
	
	
	public Iterator iterator() {
		return (this).new VectorIterator();
	}
	
	
	private class VectorIterator<T> implements Iterator{
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
			return (Object)listapessoas[i];
		}
		
		public void remove() {
			remove();
		}
	}
}
