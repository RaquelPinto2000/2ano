//Raquel Resende Milheiro Pinto nºMEC = 92948
package aula5.ex3;

import static java.lang.System.*;
import java.io.*;
public class ex3_test {
	

public static void main(String[] args) throws IOException{
		
		Agenda agenda = new Agenda();
		
		//Nokia 
		agenda.lerficheiro("Guiao 5/File1.txt");
		agenda.addcontacto(new Pessoa("Marco",12345678,new Data(),962789374));
		out.println("A agenda #1 tem "+agenda.numcontactos()+" contactos:");
		out.println(agenda);
		out.println();
		
		//vCard
		agenda = new Agenda();
		agenda.lerficheiro("Guiao 5/File2.txt");
		agenda.addcontacto(new Pessoa[] {
				new Pessoa("José Martins",23123421,new Data(),931231322),
				new Pessoa("André Mourato",23199421,new Data(),968231312),
				new Pessoa("Roberto Silva",23191421,new Data(),968222312),
				new Pessoa("Ludwig",23199421,new Data(),968231312),
		});
		agenda.addcontacto(new Pessoa("Maria Bornes",19945678,new Data(),962765474));
		out.println("A agenda #2 tem "+agenda.numcontactos()+" contactos:");
		out.println(agenda);
		out.println();
		
		//CSV 
		agenda = new Agenda();
		agenda.lerficheiro("Guiao "
				+ "5/File3.txt");
		agenda.addcontacto(new Pessoa("Ana Marques",12340078,new Data(),962222374));
		agenda.addcontacto(new Pessoa("João Nuno",16745678,new Data(),962282374));
		out.println("A agenda #3 tem "+agenda.numcontactos()+" contactos:");
		out.println(agenda);
		out.println();
		
	}

}
