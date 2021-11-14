package Aula13.ex3;
import java.util.*;

public class ex3 {
	public static void main(String[] args) {
		
		System.out.println("------ Testing NameList ------");
		/* These string[] are used for testing purposes */
		String[] workers = {"P3" , "Raquel", "Rodrigo", "Clara", "Lucia","Simao", "Pedro", "Gameiro", "Lara", "Fernanda", "Filipe","Raquel", "Simao"};
		String[] toys = {"Carro", "Comboio", "Power Ranger Amarelo", "LEGO City", 
								"Bola de futebol","Darth Vader - Boneco de Ação"};
		ListaNomes names = new ListaNomes();
		//Adds workers
		Arrays.stream(workers).forEach(x -> names.addWorker(x));
		//Prints the names of all the workers
		System.out.println(names);
		//Output: "Removed Manuel!"
		System.out.println(names.removeWorker("Manuel") ? "Removed Manuel!" : "Failed to remove Manuel");
		//Output: "Failed to remove Mariana"
		System.out.println(names.removeWorker("Mariana") ? "Removed Mariana!" : "Failed to remove Mariana!");
		
		System.out.println("\n------ Testing WorkerGifts (Worker,Gift) ------");
		Trabalhadores gifts = new Trabalhadores();
		//Simulates giving a gift to an employee every month for a year
		System.out.println("\nGiving gifts...\n");
		for(int i = 0; i < 12; i++) {
			int randWorkerIndex = (int)(Math.random() * workers.length);
			int randGiftIndex = (int)(Math.random() * toys.length);
			gifts.giveGift(toys[randGiftIndex],workers[randWorkerIndex]);
			System.out.println("'"+ toys[randGiftIndex] +"' given to "+workers[randWorkerIndex]);
		}
		System.out.println("\nPrinting lists of gifts...\n");
		System.out.println(gifts);
		System.out.println("\nTaking back gifts...\n");
		//Removes 1 gift from each workers. Workers can have more than 1 gift
		for(String worker : workers) {
			System.out.println(gifts.takeBackGift(worker) ? "Removed gift from "+worker : worker+" doesn't have a present");
		}
		System.out.println("\nPrinting lists of gifts...\n");
		System.out.println(gifts);
		
		System.out.println("\n------ Testing ToyList ------");
		String randomWorker = workers[(int)(Math.random() * workers.length)];
		Brinquedos toyList = new Brinquedos(randomWorker);
		//Adds all toys
		Arrays.stream(toys).forEach(x -> toyList.addToy(x));
		System.out.println(toyList);
		toyList.setName("Andre Mourato");
		System.out.println(toyList);
		System.out.println(toyList.removeToy("Carro") ? "Removed Carro!" : "Could not remove Carro");
		System.out.println(toyList.removeToy("Barbie") ? "Removed Barbie!" : "Could not remove Barbie");
		
		System.out.println("\n------ Testing Name Counter ------");
		ContadorNomes counter = new ContadorNomes();
		//Counts names
		Arrays.stream(workers).forEach(x -> counter.insert(x));
		System.out.println(counter);
		counter.remove("Andre"); //decrements by 1 the number of names Andre
		counter.remove("Joana"); //and so on...
		counter.remove("Joana");
		System.out.println(counter);
		
		System.out.println("\n------ Testing Ticket Manager ------\n");
		
		Bilhete manager = new Bilhete(workers);
		System.out.println("Given tickets to: \n");
		manager.giveTickets(4).forEach(System.out::println);
		System.out.println("\nGiven tickets to: \n");
		manager.giveTickets(3).forEach(System.out::println);
		System.out.println("\nGiven tickets to: \n");
		manager.giveTickets(1).forEach(System.out::println);
		System.out.println("\nGiven tickets to: \n");
		//Will rotate and give a ticket to the first worker
		manager.giveTickets(10).forEach(System.out::println);
	}

}
