package Aula13.ex2;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Word {

	private Map<String, Map<String, Integer>> dict = new TreeMap<>();
	
	public Word(String path) throws IOException {
		loadWords(readFile(path));
	}
	
	//Loads every word from a file
	private String[] readFile(String path) throws IOException {
		return Arrays.stream(Files.readAllLines(Paths.get(path)).stream()
				.collect(Collectors.joining(" "))
				.split("[-|\t|\n| |.|,|:|'|,|;|?|!|*|{|}|=|+|&|/|(|)|[|]|\"|'|“|”|‘|’]")) //Uses the separators
				.filter(x -> x.length() >= 3) //Only accepts words with length >= 3 characters
				.map(x -> x.toLowerCase()) //Converts every word to lower case
				.collect(Collectors.toList()).toArray(new String[0]);
	}
	
	//Counts every pair of words and stores to the map
	private void loadWords(String[] words) {
		/* "change trousers" e "change shirt" are converted to {"change",{"trousers","shirt"}} */
		for(int i = 0; i < words.length - 1; i++) {
			String firstWord = words[i];
			String secondWord = words[i+1];
			if(dict.containsKey(firstWord)) { //Already contains firstWord
				Map<String, Integer> numbers = dict.get(firstWord);//Found a new pair for firstWord
				if(numbers.containsKey(secondWord))  //Pair already exists
					numbers.put(secondWord,numbers.get(secondWord)+1);
				else  //Pair doesn't exist
					numbers.put(secondWord, 1);
				
			}else { //Doesn't contain firstWord
				//Creates a new dict for the pair associated with firstWord
				Map<String, Integer> wordDict = new TreeMap<>();
				wordDict.put(secondWord, 1); //Adds its first element
				dict.put(firstWord, wordDict); //Inserts the created dict into the main dict
			}
		}
		
	}
	
	@Override
	public String toString() {
		return dict.keySet().stream().map(x -> x.concat("=").concat(dict.get(x).toString()))
									 .collect(Collectors.joining("\n"));
	}
}
