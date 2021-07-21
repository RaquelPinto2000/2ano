package aula9.ex3;
import java.util.*;



public class ListaPessoas {
	private List <Pessoa> pessoa = new LinkedList<>();
	private ListaPessoasIterator iterator=new ListaPessoasIterator();
	
	public boolean addPessoa(Pessoa p) {
		return pessoa.add(p);
	}
	
	public boolean remove(Pessoa p) {
		return pessoa.remove(p);
	}
	
	public int size() {
		return pessoa.size();
	}
	
	public Iterator iterator() {
		return iterator;
	}
	
	private class ListaPessoasIterator implements Iterator{
		
		private int pointer = 0;
		
		public boolean hasPrevious() {
			return pointer >= 0;
		}
		
		public Pessoa previous() {
			int i = pointer;
			if(i < 0) 
				throw new NoSuchElementException();
			pointer = i - 1;
			return pessoa.get(i);
		}
		
		public boolean hasNext() {
			return pointer < pessoa.size();
		}
		
		public Pessoa next() {
			int i = pointer;
			if(i >= pessoa.size())
				throw new NoSuchElementException();
			pointer = i + 1;
			return pessoa.get(i);
		}
		public void remove() {
			remove();
		}
		
	}
}

