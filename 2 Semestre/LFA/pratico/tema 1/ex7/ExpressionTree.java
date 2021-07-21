import java.util.*;

public class ExpressionTree {
	private static Scanner sc = new Scanner(System.in);
	private ExpressionTree esq = null;
	private ExpressionTree dir = null;
	private double number;
	private String operacao = null;
	
	
	
/*	createPrefix ()
{
	if ( i n . hasNextDouble ( ) ) // next word is a number
	{
		// leaf tree with the number
	}
	else // next word is the operator
	{
		// tree with the form : operator left Expression right Expression
		// left Expression and right Expression can also be created with create Prefix
	}
}
*/	
	
	public ExpressionTree (){
		if(sc.hasNextDouble()){
			number = sc.nextDouble();
		}else{
			operacao = sc.next();
			if(!veroperador(operacao)){
				System.err.println("operador nao existe");
				System.exit(1);
			}else{
				esq = new ExpressionTree();
				dir = new ExpressionTree();
			}
			
		}
	}
	
	public void printInfix(){
		if(operacao==null){
			System.out.print(number);
		}else{
			System.out.print("(");
			esq.printInfix();
			System.out.print(operacao);
			dir.printInfix();
			System.out.print(")");
		}
	}
	
	
	public static boolean veroperador(String s){
		if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") ){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	
	public double eval(){
		double resultado=0;
		if(operacao!=null){
			switch(operacao) {
				case "+":
					resultado = esq.eval()+dir.eval();
					break;
				case "-":
					resultado = esq.eval()-dir.eval();
					break;
				case "*":
					resultado =  esq.eval()*dir.eval();
					break;
				case "/":
					if(dir.eval() ==0){
						System.out.println("operacao invalida");
						System.exit(1);
					}
					resultado =  esq.eval()/dir.eval();
					break;
				default:
					break;
			}	
		}else{
			resultado = number;
		}
		//System.out.print(resultado);
		return resultado;
	}
}

