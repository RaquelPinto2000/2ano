//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula4.ex1;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {

	private String nome;
	private String ac;
	private int ects;
	private Professor prof;
	private List<Estudante> alunos;
	
	public Disciplina(String nome, String AC, int ECTS, Professor prof) {
		this.nome=nome;
		ac=AC;
		ects=ECTS;
		this.prof=prof;
		alunos=new ArrayList<>();
	}
	
	public String nome() {
		return nome;
	}
	
	public String ac() {
		return ac;
	}
	
	public int ects() {
		return ects;
	}
	
	public Professor prof() {
		return prof;
	}
	
	public int numAlunos() {
		return alunos.size();
	}
	
	public boolean addAluno(Estudante e) {
		if(alunoInscrito(e.nMec())) {
			return false;
		}else {
			alunos.add(e);
			return true;
		}
	}
	public boolean delAluno(int nMec) {
		for(int i = 0;i< alunos.size();i++) {
			if(alunos.get(i).nMec()==nMec) {
				alunos.remove(alunos.get(i));
				return true;
			}
		}
		return false;
	}
	
	public boolean alunoInscrito(int nMec) {
		for(int i = 0;i<alunos.size();i++) {
			if(nMec==alunos.get(i).nMec()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Disciplina: " + nome + " ("+ ects+ " ECTS) da Area de " + ac + "\nResponsavel: Professor: " + prof.toString() + "\nExistem " + numAlunos() +" alunos inscritos" ;
	}
	
	public Estudante[] getAlunos() {
		return alunos.toArray(new Estudante [0]);
	}
	
	public Estudante[] getAlunos(String tipo) {
		List<Estudante> aux = new ArrayList<>();
		for(int i=0;i<alunos.size();i++) {
			if(alunos.get(i).toString().contains(tipo)) {
				aux.add(alunos.get(i));
			}
		}
		return aux.toArray(new Estudante [0]);
	}
	
}
