
public class WordManager {
//List of words given in the game
private String[] words = {"Ant","Bird","Cat","Chicken","Cow","Dog","Elephant","Kangaroo","Rabbit","Whale","Zebra"};
	//gives the list of words to whoever asks for it
	public String[] getWords() {
		return this.words;
	}
	//randomly selects a word for the game
	public String SelectWord() {
		int position =(int) (Math.random()*words.length);
		String word = words[position];
		return word;
	}
	//changes the word into letters
	public char[] convertWord(String word) {
		int numOfLetters = word.length();
		char[] charWord = new char[numOfLetters];
		for (int i=0;i<word.length();i++) {
			charWord[i] = word.charAt(i);
		}
		return charWord;
	}
	//changes the letters into dashes for the game
	private char[] convertToDash (char[] word) {
		int numOfDashes = word.length;
		char[] dashes = new char[numOfDashes];
		for (int i = 0;i<numOfDashes;i++) {
			dashes[i] = '-';
		}
		return dashes;
		
	}
	//gives the final product to the game
	public char[] giveWord (char[] word) {
		return convertToDash(word);
	}
}
