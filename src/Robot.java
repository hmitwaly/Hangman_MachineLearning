import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Robot {
	
	WordManager wordManager = new WordManager();
	//starting alphabet for the robot
	char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	//gets the words that the wordmanager has
	String [] words = wordManager.getWords();
	
	char[] currentAlphabet = alphabet;
	
	int position =0;
	
	int generation =0;
	//initializes the array that tracks which letters worked
	int[] hits = new int[26];
	//keeps hits and alphabet linked together for robots reference
	HashMap<Character,Integer> common = new HashMap<Character,Integer>();
	
	
	public Robot() {	
		for (int i =0;i<alphabet.length;i++) {
			common.put(currentAlphabet[i],hits[i]);
		}
	}
	//gets the words from the word manager
	public String[] GetWord(char[] word) {
		ArrayList<String> possibleWordsList = new ArrayList<String>();
		for (int i =0; i<words.length;i++){
			if (word.length == words[i].length()) {
				possibleWordsList.add(words[i]);
			}
		}
		String [] possibleWords = new String[possibleWordsList.size()];
		possibleWords = possibleWordsList.toArray(possibleWords);
		return possibleWords;
	}
	// goes through its alphabet and if it runs through alphabet, it changes the guessing order
	public char guess() {
		char c = currentAlphabet[this.position];
		if (this.position >24) {
			this.position = 0;
			generation++;
			RefineAnswer();
		} else {
			this.position++;
		}
		return c;
	}
	//lets the robot know if it was correct or not
	public void correct(char c, boolean[] b) {
		for (int i =0;i<b.length;i++){
			if (b[i]) {
				int current = common.get(c);
				current++;
				common.put(c, current);
			}
		}
	}
	//changes the alphabet order and hence guess order if robot keeps losing
	public char[] RefineAnswer() {	
		Arrays.sort(hits);
		char [] newAlphabet = new char[26];
		int count =0;
		
		for (int i =0; i<hits.length;i++) {
			int max = 0;
			
			if (common.get(currentAlphabet[i]) > max) {
				max = common.get(currentAlphabet[i]);
				newAlphabet[count]=currentAlphabet[i];
				count++;
				common.put(currentAlphabet[i],0);
				currentAlphabet[i]='-';
			}
		}
		
		for (int i=0;i<hits.length;i++) {
			if (currentAlphabet[i] != '-') {
				newAlphabet[count]=currentAlphabet[i];
				count++;
			}
		}
		

		currentAlphabet = newAlphabet;
		return currentAlphabet;
	}
		
		

		
}
