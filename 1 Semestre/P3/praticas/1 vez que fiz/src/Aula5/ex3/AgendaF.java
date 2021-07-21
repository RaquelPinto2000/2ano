//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula5.ex3;
import java.io.*;
public interface AgendaF {
	
	public Pessoa[] lerformatof(String filenome) throws IOException;
	public void escreverich(String filenome, Pessoa[] p) throws IOException;
}
