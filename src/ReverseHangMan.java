import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseHangMan {
	
	public static WordManager wordManager = new WordManager();
	public static Robot robot= new Robot();
	
	public static boolean[] Verify(char c, char [] word) {

		boolean [] positions = new boolean[word.length];
		for (int i = 0;i<word.length;i++) {
			if (c == word[i]) {
				positions[i]=true;
			} else {
				positions[i]=false;
			}
		}
		return positions;
		
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean winning = false;
		int losses =0;

		while(!winning){	
			int lives = 6;
			int wrong =0;
			int count=0;
				
				
				String word = wordManager.SelectWord().toLowerCase();
				int unknown = word.length();
				char[] wordToGuess = wordManager.convertWord(word);
				System.out.println(Arrays.toString(robot.GetWord(wordToGuess)));
				char[] wordOnScreen = wordManager.giveWord(wordToGuess);
				ArrayList<Character> lettersUsed = new ArrayList<Character>();
				
			while (lives >0 && unknown > 0) {
				System.out.println(wordOnScreen);
				System.out.println(lives);
				System.out.println("Letters Not in Word: ");
				System.out.println(lettersUsed);
				System.out.println("Generation: "+robot.generation+" Losses: "+losses);
				System.out.print("Guess a letter: ");
				
				char letter = Character.toLowerCase(robot.guess());
				System.out.println(letter);
				boolean[] verify = Verify(letter,wordToGuess);
				robot.correct(letter, verify);
				
				for (int i =0; i<verify.length;i++) {				
					if (verify[i]) {
						wordOnScreen[i] = letter;
						unknown-=1;
					} else {
						wrong++;
					}
					if (wrong == verify.length) {
						lives--;
						lettersUsed.add(letter);
						count++;
					}
				}
				wrong =0;
			}
			
			if (lives>0) {
				System.out.println(word);
				System.out.println("You Win!");
				winning = true;
			} else {
				System.out.println("The word was "+word+".");
				System.out.println("You Suck!");
				losses++;
			}
			
			
			input.close();	
		}
	}
		
		
		
			

}
