
public class WordManager {
	
private String[] words = {"Ant","Bird","Cat","Chicken","Cow","Dog","Elephant","Kangaroo","Rabbit","Whale","Zebra"};
	
	public String[] getWords() {
		return this.words;
	}
	
	public String SelectWord() {
		int position =(int) (Math.random()*words.length);
		String word = words[position];
		return word;
	}
	
	public char[] convertWord(String word) {
		int numOfLetters = word.length();
		char[] charWord = new char[numOfLetters];
		for (int i=0;i<word.length();i++) {
			charWord[i] = word.charAt(i);
		}
		return charWord;
	}
	
	private char[] convertToDash (char[] word) {
		int numOfDashes = word.length;
		char[] dashes = new char[numOfDashes];
		for (int i = 0;i<numOfDashes;i++) {
			dashes[i] = '-';
		}
		return dashes;
		
	}
	
	public char[] giveWord (char[] word) {
		return convertToDash(word);
	}
}
