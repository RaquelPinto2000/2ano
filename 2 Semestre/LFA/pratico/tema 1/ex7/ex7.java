import java.util.*;

public class ex7 {
	
	public static void main (String[] args) {
		
		ExpressionTree tree = new ExpressionTree();
		tree.printInfix();
		System.out.printf(" = %f\n", tree.eval());
		
	}
}

