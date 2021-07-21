package Aula10.ex2;

import java.util.Iterator;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import java.util.Stack;
public class BinarySearchTree<T extends Comparable<? super T>> implements Iterable<T> {
	// o elemento do tipo T deve ser comparável para efectuar pesquisas
	// mas como pode herdar a implementação de compareTo() é mais correcto
	// 	usar <? super T>
	
	private static class BSTNode<T> {
		T element;
		BSTNode<T> left;
		BSTNode<T> right;
		BSTNode(T theElement) {
			element = theElement;
			left = right = null;
		}
		
		public BSTNode<T> subTreeMin(){
			return subTreeMin(this);
		}
		
		private BSTNode<T> subTreeMin(BSTNode<T> n){
			if(n.left == null)
				return n;
			
			return subTreeMax(n.left);
		}
		public BSTNode<T> subTreeMax(){
			return subTreeMax(this);
		}
		
		private BSTNode<T> subTreeMax(BSTNode<T> n){
			
			if(n.right == null)
				return n;
			
			return subTreeMax(n.right);
		
		}
	}
	
	private BSTNode<T> root;
	private int numNodes;
	
	public BinarySearchTree() {
		root = null;
		numNodes = 0;
	}
	
	public int size() {
		return numNodes;
	}
	public void insert(T value) {
		if(contains(value)) {
			return;
		}
		root = insert(value, root);
	}
	
	private BSTNode<T> insert(T value, BSTNode<T> root) {
		if(root==null) {
			numNodes++;
			return new BSTNode<T>(value);
		}
		int i = value.compareTo(root.element);
		if(i<0) {
			root.left = insert(value,root.left);
			return root;
		}else {
			root.right = insert(value,root.right);
			return root;
		}
	}
	
	public void remove(T value) {
		if(root == null) throw new NullPointerException();
		if(!contains(value)) throw new NoSuchElementException();
		numNodes--;
		root = remove(value, root);
	}
	
	private BSTNode<T> remove(T value, BSTNode<T> root) {
		int i = value.compareTo(root.element);
		if(i<0) {
			root.left = insert(value,root.left);
		}else if(i>0){
			root.right = insert(value,root.right);
		}else if(root.left==null) {
			root=root.right;
		}else if(root.right==null) {
			root=root.left;
		}else {
			root=root.subTreeMin();
			remove(root.element);
		}
		return root;
	}
	
	
	public boolean contains(T value) {
		Iterator<T> it = iterator();
		boolean exists = false;
		while(it.hasNext()) {
			if(((T)it.next()).equals(value)) {
				return true;
			}
		}
		return exists;
		
	}
	
	
	
	public Iterator<T> iterator() {
		return new BSTIterator<T>(root);
	}
	
	
	public class BSTIterator<E> implements Iterator<E>{
		Stack<BSTNode<E>> stack;
		 
		public BSTIterator(BSTNode<E> root) {
			stack = new Stack<BSTNode<E>>();
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}
	 
		public boolean hasNext() {
			return !stack.isEmpty();
		}
	 
		public E next() {
			BSTNode<E> node = stack.pop();
			E top = node.element;
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
			return top;
		}
	}
	
}