package Aula10.ex2;
import static java.lang.System.*;
public class ex2 {
	public static void main(String[] args) {
		//Test elements
			Quadrado q1 = new Quadrado(4.0);
			Quadrado q2 = new Quadrado(90.0);
			Quadrado q3 = new Quadrado(1,2,25.0);
			Quadrado q4 = new Quadrado(8,9,15.4);
			Quadrado q5 = new Quadrado(19.2);
			Quadrado q6 = new Quadrado(6,2,12.4);
			Quadrado q7 = new Quadrado(9,4,52.2);
			Quadrado q8 = new Quadrado(14.4);
			
			//The BST
			BinarySearchTree<Quadrado> bst = new BinarySearchTree<>();
			
			//Inserts elements
			bst.insert(q1);
			bst.insert(q3);
			bst.insert(q7);
			bst.insert(q6);
			bst.insert(q4);
			
			out.println("A arvore " + (bst.contains(q1) ? "contem " : "nao contem") + "o elemento"); //TRUE
			out.println("A arvore " + (bst.contains(q7) ? "contem " : "nao contem") + "o elemento"); //TRUE
			out.println("A arvore " + (bst.contains(q3) ? "contem " : "nao contem") + "o elemento"); //TRUE
			out.println("A arvore " + (bst.contains(q8) ? "contem " : "nao contem") + "o elemento"); //FALSE
			out.println("A arvore " + (bst.contains(q2) ? "contem " : "nao contem") + "o elemento"); //FALSE
			out.println();
			
			for(Quadrado q : bst) {
				out.println(q);
			}
			
			out.println();
			
			Quadrado dummy = q1;
			
			bst.remove(dummy);
			out.println("Após a remoção, a árvore " + (bst.contains(dummy) ? "contem" : "nao contem") + " o elemento");
			dummy = q7;
			
			bst.remove(dummy);
			out.println("Após a remoção, a árvore " +(bst.contains(dummy) ? "contem" : "nao contem") + " o elemento");
			
			
			out.println("\nO BinarySearchTree contem " + bst.size() + " elementos.\n");
			
			for(Quadrado q : bst) {
				out.println(q);
			}
			
	}
}
