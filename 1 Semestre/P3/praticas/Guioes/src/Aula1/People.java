package Aula1;

public class People {
	private String name;
	private int cc;
	private Data datanac;
	
	
	public People(String name, int cc, Data datanac) {
		this.name = name;
		this.cc=cc;
		this.datanac=datanac;
	}
	
	public String name() {
		return name;
	}
	public int cc() {
		return cc;
	}
	public Data datanac() {
		return datanac;
	}

	public String toString() {
		return String.format("%1$"+12+"s", name) + " | " + String.format("%1$"+11+"s", cc)+" | "+String.format("%1$"+8+ "s", datanac);
	}
	
}
