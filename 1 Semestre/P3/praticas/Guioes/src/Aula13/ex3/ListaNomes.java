package Aula13.ex3;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ListaNomes {
	
	private final Set<String> names = new TreeSet<>();
	
	public boolean addWorker(String workerName) {
		return names.add(workerName);
	}
	
	public boolean removeWorker(String workerName) {
		return names.remove(workerName);
	}

	@Override
	public String toString() {
		return names.stream().collect(Collectors.joining("\n"));
	}
}
