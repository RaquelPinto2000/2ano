import java.util.*;
public class ex1 {

	public static void main(String[] args) {
		double resultado=0;
		Scanner sc = new Scanner (System.in);
		System.out.println("Introduza uma operacao(nº operador nº)");
		if (!sc.hasNextDouble())
		{
			System.err.println("Nao e um double");
			System.exit(1);
		}
		double number1 = sc.nextDouble();
		if (!sc.hasNext())
		{
			System.err.println("invalid operation");
			System.exit(1);
		}
		String s = sc.next();
		if (!sc.hasNextDouble())
		{
			System.err.println("Nao e um double");
			System.exit(1);
		}
		double number2 = sc.nextDouble();
		sc.close();
		
		switch(s) {
			case "+":
				resultado = number1+number2;
				System.out.println(resultado);
				break;
			case "-":
				resultado = number1-number2;
				System.out.println(resultado);
				break;
			case "*":
				resultado = number1*number2;
				System.out.println(resultado);
				break;
			case "/":
				if(number2 ==0){
					System.out.println("operacao invalida");
					System.exit(1);
				}
				resultado = number1/number2;
				System.out.println(resultado);
				break;
			default:
				System.out.println("Operador nao existe");
		}	
		
	}
}
