package aula10.ex1;
import java.util.*;
public class ListaGeneric<T> {
	private List <T> list = new LinkedList<>();
	private ListaPessoasIterator iterator=new ListaPessoasIterator();
	
	public boolean addElem(T elem) {
		return list.add(elem);
	}
	
	public boolean remove(T elem) {
		return list.remove(elem);
	}

	
	public int totalElem () {
		return list.size();
	}
	
	public Iterator iterator() {
		return iterator;
	}
	
	private class ListaPessoasIterator <T>implements Iterator{
		
		private int pointer = 0;
		
		public boolean hasPrevious() {
			return pointer >= 0;
		}
		
		public Object previous() {
			int i = pointer;
			if(i < 0) 
				throw new NoSuchElementException();
			pointer = i - 1;
			return list.get(i);
		}
		
		public boolean hasNext() {
			return pointer < list.size();
		}
		
		public Object next() {
			int i = pointer;
			if(i >= list.size())
				throw new NoSuchElementException();
			pointer = i + 1;
			return list.get(i);
		}
		public void remove() {
			remove();
		}
		
	}
}
