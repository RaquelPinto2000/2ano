//Raquel Resende Milheiro Pinto nºMEC = 92948

package Aula12.ex3;
import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Agenda {
	
	private List<Pessoa> agenda = new ArrayList<>();
	private List<AgendaP> plugins = new ArrayList<>();
	
	/* Loads teh plugins */
	public Agenda() throws Exception{
		loadPlugins("bin/Aula12/plugins");
	}
	
	public void loadPlugins(String directoryName) throws Exception{
		for(File pluginFile : (new File(directoryName)).listFiles()) {
			String pluginName = "aula12.ex3."+pluginFile.getName().split("\\.")[0];
			plugins.add(AgendaPM.load(pluginName));
		}
	}
	
	public void lerficheiro(String filename) throws Exception {
		Scanner read = new Scanner(new File(filename));
		AgendaP pluginProxy = (AgendaP)Class.forName("aula12.ex3."+read.nextLine()).newInstance();
		read.close();
		addcontacto(pluginProxy.lerformatof(filename));
	}
	
	public void saveToFile(String filename,AgendaP format) throws IOException{
		format.escreverfich(filename, agendaToArray());
	}
	
	public void addcontacto(Pessoa[] pessoas) {
		for(Pessoa p : pessoas) {
			addcontacto(p);
		}
	}
	
	public void addcontacto(Pessoa pessoa) {
		agenda.add(pessoa);
	}
	
	public void removeContact(Pessoa pessoa) throws Exception{
		if(!agenda.contains(pessoa)) throw new Exception("Pessoa given doesn't exist in list");
		agenda.remove(pessoa);
	}
	
	private Pessoa[] agendaToArray() {
		return agenda.toArray(new Pessoa[0]);
	}
	
	public int numcontactos() {
		return agenda.size();
	}
	
	public List<AgendaP> supportedPlugins(){
		return plugins;
	}
	
	@Override
	public String toString() {
		return agenda.toString();
	}

}
