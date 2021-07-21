package aula4.ex1;
import java.util.*;
public class Disciplina {
	private String nome;
	private String area;
	private int ECTS;
	private Professor responsavel;
	private List<Estudante> alunos;
	
	public Disciplina(String nome, String area, int eCTS, Professor responsavel) {
		super();
		this.nome = nome;
		this.area = area;
		ECTS = eCTS;
		this.responsavel = responsavel;
		alunos = new ArrayList<>();
	}
	public int numAlunos() {
		return alunos.size();
	}
	public boolean addAluno(Estudante est) {
		if(alunoInscrito(est.nMec())) {
			return false;
		}else {
			alunos.add(est);
			return true;
		}
	}
	public boolean delAluno(int num) {
		for (int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).nMec()==num) {
				alunos.remove(alunos.get(i));
				return true;
			}
		}
		return false;
	}
	public boolean alunoInscrito(int n) {
		for (int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).nMec()==n) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "Disciplina: " + nome + " ("+ ECTS+ " ECTS) da Area de " + area + "\nResponsavel: Professor: " + responsavel.toString() + "\nExistem " + numAlunos() +" alunos inscritos" ;
	}
	public Estudante [] getAlunos() {
		return alunos.toArray(new Estudante [0]);
	}
	public Estudante [] getAlunos(String tipo) {
		List <Estudante> aux = new ArrayList<>();
		for (int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).toString().contains(tipo)) {
				aux.add(alunos.get(i));
			}
		}
		return aux.toArray(new Estudante[0]);
	}
}
