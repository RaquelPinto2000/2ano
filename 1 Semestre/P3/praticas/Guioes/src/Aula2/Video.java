package Aula2;

public class Video {
	private int id;
	private String titulo;
	private String categoria;
	private String idade;
	private boolean requisitado = false;
	private int rating;
	
	public Video(int id,String titulo,String categoria,String idade) {
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.idade = idade;
	}
	public Video(int id,String titulo,String categoria,String idade, int rating) {
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.idade = idade;
		this.rating=rating;
	}
	
	public int id() {
		return id;
	}
	public String titulo() {
		return titulo;
	}
	public String categoria() {
		return categoria;
	}
	public String idade() {
		return idade;
	}
	public int rating() {
		return rating;
	}
	
	//ver se foi requisitado
	public boolean requisitado() {
		return requisitado;
	}
	//requisitar um video
	public void requisitar(Video video) {
		video.requisitado = true;
	}
	//devolver um video
	public void devolver(Video video) {
		video.requisitado = false;
	}
	
	//Dizer o estado de um video
	public String toString(Video video) {
		String s;
		if (video.requisitado() == true) {
			s = "Requisitado";
		}else {
			s = "Disponivel";
		}
		return String.valueOf(video.id()) + "       " + video.titulo() + "      " + video.categoria() + "         " + video.idade() + "       " + s;
	}
}
