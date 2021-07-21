// notacao diferente a que estamos habituada
import java.util.*;
public class ex2 {
	public static void main(String[] args) {
		Stack pilha = new Stack ();
		double resultado=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduza uma operacao");
		
		while(sc.hasNext()){
			if(sc.hasNextDouble()){
				double number = sc.nextDouble();
				pilha.push(number);
				System.out.println("Stack: "+pilha.toString());
			}else{
				if(!sc.hasNext()){
					System.err.println("Operacao invalida");
					System.exit(1);
				}else{
					String operacao = sc.next();
					double number2 = (double)pilha.pop();
					double number1 = (double)pilha.pop();
					switch(operacao) {
						case "+":
							resultado = number1+number2;
							break;
						case "-":
							resultado = number1-number2;
							break;
						case "*":
							resultado = number1*number2;
							break;
						case "/":
							if(number2 ==0){
								System.out.println("operacao invalida");
								System.exit(1);
							}
							resultado = number1/number2;
							//System.out.println(resultado);
						default:
							System.out.println("Operador nao existe");
							System.exit(1);
					}	
					pilha.push(resultado);
					System.out.println("Stack: "+pilha.toString());
				}	
			}
		}						
	}
}
