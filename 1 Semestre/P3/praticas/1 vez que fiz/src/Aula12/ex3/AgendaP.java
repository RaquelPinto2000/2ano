//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula12.ex3;
import java.io.*;
public interface AgendaP {
	
	public Pessoa[] lerformatof(String s) throws IOException;
	public void escreverfich(String s, Pessoa[] p) throws IOException;
}
