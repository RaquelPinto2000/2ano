package aula5.ex3;
import java.io.*;
public interface AgendaFormat {

	public Pessoa[] lerinformacao(String nome) throws IOException;
	public void escreverfich (String nome, Pessoa[] p) throws IOException;
}
