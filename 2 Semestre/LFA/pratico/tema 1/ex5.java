import java.util.*;
// nao da bem
public class ex5 {
	
	public static void main (String[] args) {
	//	int numero=0;
		//String s ="";
		double resultado=0;
		Map<String,Double> var = new HashMap<>();
		Scanner sc = new Scanner(System.in);
	/*	while(true){
			String s = sc.nextLine();
			String [] ope = s.split(" ");
			if(ope.contains("=")){
				if(ope.length==3){
					var.put(ope[0],Integer.parseInt(ope[2]));
				}
			}
		}
		*/
		
		double number1=0;
		double number2=0;
		
		while(true){
			
			if(sc.hasNextDouble()){ // se comecao com um numero e 9 * 8
				if(!sc.hasNext()){
					resultado = sc.nextDouble();
				}else{
						number1 = sc.nextDouble();
						String operacao = sc.next();
					if(!sc.hasNextDouble()){
						System.err.println("Operacao invalida");				
						System.exit(1);
					}else{
						number2 = sc.nextDouble();
						resultado = operacoes(number1,number2,operacao);						
					}	
						
				}

			}else { 
				String total = sc.nextLine();
				if(total.contains("=")){ // atribui variaveis n = 9
					String s [] = total.trim().split("=");
					double number = Double.parseDouble(s[1]);
					var.put(s[0], number);
					resultado = number;					
				}else{ // fazer operacoes com variaveis
					String s [] = total.trim().split(" ");			
					if(var.get(s[0])== null && var.get(s[0])== null){
						System.out.println("meme");
						String operacao1 = sc.next();
						number2 = sc.nextDouble();
						resultado = operacoes(resultado, number2,operacao1 );
					}else if(resultado==0){
						System.out.println("ola");
					}else{
					}
				}						
										
				/*	char letra1= s[0].charAt(0);
					char letra2  = s[2].charAt(0);
					if(Character.isLetter(letra1) && Character.isDigit(letra2)){ // se for n opecarao um numero
						number1 = var.get(s[0]);
						number2 = Double.parseDouble(s[2]);
						resultado = operacoes(number1, number2, s[1]);
					}else if(Character.isLetter(letra1) && Character.isDigit(letra2)){
						number1 = var.get(s[0]);
						number2 = var.get(s[2]);
						resultado = operacoes(number1,number2,s[1]);
					}
					*/
				
			}
			System.out.printf("Resultado : %f\n", resultado);
		}
	}						
		
	
	
	
	public static double operacoes(double number1, double number2, String operacao){
		double resultado=0;
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
				break;
			default:
				System.out.println("Operador nao existe");
				System.exit(1);
		}	
		return resultado;
	}
}

