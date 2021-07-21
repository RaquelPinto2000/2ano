import java.util.*;
public class Banco extends Cliente{
	private String nome ;
	private List<String>  s = new ArrayList<String>();
	public Banco(String nome) {
		super(nome);
		this.nome=nome;
	}
	
	public boolean add(Conta c) {
		boolean b=false;
		for(int i=0 ;i<s.size();i++) {
			if(s.get(i)==c.c().nome()) {
				b= false;
				break;
			}else {
				b=true;
				s.add(c.c().nome());
			}
		}
		return b;
	}

	@Override
	public String toString() {
		return "Banco [nome=" + nome + ", s=" + s + "]";
	}
}