package Aula13.ex3;
import java.util.*;
public class Bilhete {
	private int INDEX = 0;
	private String[] workers;
	
	public Bilhete(String[] workers) {
		this.workers = workers;
	}
	
	/* Gives out N tickets in rotating order */
	public List<String> giveTickets(int N) {
		List<String> awardedWorkers = new LinkedList<>();
		for(int i = 1; i <= N; i++) awardedWorkers.add(giveTicket());
		return awardedWorkers;
	}

	private String giveTicket() {
		INDEX = (INDEX + 1) % workers.length;
		return workers[INDEX];
	}
}
