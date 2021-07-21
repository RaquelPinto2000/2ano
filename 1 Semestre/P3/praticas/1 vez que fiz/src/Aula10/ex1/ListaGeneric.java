package Aula10.ex1;
import java.util.*;

public class ListaGeneric<T> {

	private List <T> Elementos = new LinkedList<>();
	private ListaPessoasIterator iterator=new ListaPessoasIterator();
	
	public boolean addElem(T elem) {
		return Elementos.add(elem);
	}
	
	public boolean removeElem(T elem) {
		return Elementos.remove(elem);
	}
	
	public int totalElem () {
		return Elementos.size();
	}
	
	public Iterator iterator() {
		return iterator;
	}
	
	private class ListaPessoasIterator<T> implements Iterator{
		
		private int pointer = 0;
		
		public boolean hasPrevious() {
			return pointer >= 0;
		}
		
		public Object  previous() {
			int i = pointer;
			if(i < 0) 
				throw new NoSuchElementException();
			pointer = i - 1;
			return Elementos.get(i);
		}
		
		public boolean hasNext() {
			return pointer < Elementos.size();
		}
		
		public Object next() {
			int i = pointer;
			if(i >= Elementos.size())
				throw new NoSuchElementException();
			pointer = i + 1;
			return Elementos.get(i);
		}
		public void remove() {
			remove();
		}
		
	}	

}
