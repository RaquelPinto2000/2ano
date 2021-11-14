//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula6.ex1;

public class Node<E> {
	 

	final E elem;
	Node<E> next;

	Node(E e, Node<E> n) {
	   elem = e;
	   next = n;
	}

	Node(E e) {
	   elem = e;
	   next = null;
	}
}
