//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula7.ex1;

public class voo implements Comparable<voo>{
	private Hora partida;
	private String nome;
	private String origem;
	private Hora atraso;
	private Companhia companhia;
	
	public voo(Hora hora,Hora atraso,String nome,String origem,Companhia companhia) {
		partida=hora;
		this.nome=nome;
		this.origem=origem;
		this.atraso=atraso;
		this.companhia=companhia;
	}
	
	public int atrasomin() {
		return atraso.getTotalMinutos();
	}
	
	public Hora partida() {
		return partida;
	}

	public String nome() {
		return nome;
	}
	
	public String origem() {
		return origem;
	}
	
	public Hora atraso(){
		return atraso;
	}
	
	public Companhia companhia(){
		return companhia;
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%-10s\t%-18s\t%-20s\t%-5s\t%s",  partida.toString(), nome.toString(),
				companhia.toString(), origem.toString(),	Hora.isHourZero(atraso) ? "" : atraso.toString(),
				Hora.isHourZero(atraso) ? "" : "Previsto: "+Hora.horaPrevista(partida,atraso).toString());
	}
	
	@Override
	public int compareTo(voo v) {
		return atrasomin()-v.atrasomin();
	}
}
