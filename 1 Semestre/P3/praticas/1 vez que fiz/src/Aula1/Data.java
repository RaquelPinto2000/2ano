package Aula1;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public int dia() {
		return dia;
	}
	
	public int mes() {
		return mes;
	}
	
	public int ano() {
		return ano;
	}
	
	//data total
	public String toString(){
		return String.format("%02d-%02d-%04d", dia, mes, ano);
	}
	
	//indica se o ano e bissexto
		public static boolean bissexto(int ano) {
			return ano%4 == 0 && ano%100 != 0 || ano%400 == 0;
		}
	//valida a data
		public static boolean validadata(int dia,int mes,int ano) {
			boolean b = false;
			
		    if(mes<=12 && mes>0){
				if(mes == 1 || mes == 3 || mes == 5 || mes ==7 || mes ==8 || mes ==10 || mes ==12){
					if(dia<=31 && dia>0){
						b=true;
					}else{
						b=false;
					}
				}else if(mes==4||mes==6||mes == 9|| mes ==11){
					if(dia<=30 && dia>0){
						b=true;
					}else{
						b=false;
					}
				}else if(mes==2){
					if((dia<=29 && dia>0) && bissexto(ano)==true){
						b=true;
					}else if(bissexto(ano)==false && dia<=28 && dia>0){
						b=true;
					}else{
						b=false;
					}
				}

			}else{
				b=false;
			}
		    return b;
		  }
			
	
	
	
	
}
