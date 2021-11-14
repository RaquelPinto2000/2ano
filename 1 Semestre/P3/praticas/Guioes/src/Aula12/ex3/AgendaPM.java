//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula12.ex3;
abstract class AgendaPM {
	
	public static AgendaP load(String nome) throws Exception {
		Class<?> c= Class.forName(nome);
		return (AgendaP) c.newInstance();
	}	
}
