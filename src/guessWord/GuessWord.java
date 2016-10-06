package guessWord;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class GuessWord {
	
	private static final String FILE_PATH = "C:\\Users\\A0707220\\Documents\\Temp\\words.txt";
	private BufferedReader br;
	private Stream <String> lines;
	private String word;
	private char[]guess;
	
	public String getWord() {
		return word;
	}

	public void readWord () {
		int rNumber;
		String[] words;
		
		// get a random line number
		this.accessFile();
		lines = this.br.lines();
		rNumber = this.randomLine((int)lines.count());
		
		// read words from a random text line
		this.accessFile();
		lines = this.br.lines();
		words = lines.toArray()[rNumber].toString().split("\\s");

		this.closeStream();
		
		// get a random word number
		rNumber = this.randomLine(words.length);
		this.word = words[rNumber];
	}
	
	public void guess() {
		char letter;
		
		this.guess = new char[this.word.length()];
		this.initGuess();
		System.out.println(this.guess);
		System.out.println("type any letter");
		try (Scanner sc = new Scanner(System.in)) {
			letter = sc.next().charAt(0);
			while ( (letter != '$') ) {
				this.findLetter(letter);
				System.out.println(new String(this.guess));
				
				if ( ! new String(this.guess).contains("*") ){
					System.out.println("*** WIN ***");
					break;
				}
				
				System.out.println("type any letter");
				letter = (char)sc.next().charAt(0);
				
			}
			if (letter == '$') {
				System.out.println("*** GOT OUT ***");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void findLetter(char letter) {
		int index = this.word.indexOf(letter);
		while ( index != -1 ) {
			this.guess[index] = this.word.charAt(index);
			index = index==this.word.length() ? -1
					: this.word.indexOf(letter, index+1);
		}
	}
	
	/**
	 * @param linesCounter : upper limit for scope to generate a random integer
	 * @return : integer between zero and the value passed by @param linesCounter
	 */
	public int randomLine (int linesCounter) {
		Random random = new Random();
		return random.nextInt(linesCounter);
	}
	
	public void initGuess() {
		for (int i=this.guess.length; i>0; i--) {
			this.guess[i-1] = '*';
		}
	}
	
	public void accessFile () {
		try {
			this.br = new BufferedReader(new FileReader(FILE_PATH));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void closeStream () {
		try {
			this.br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedReader getBr() {
		return br;
	}
	
	public Stream<String> getLines() {
		return lines;
	}
	
	public void setBr(BufferedReader br) {
		this.br = br;
	}
	
	public void setLines(Stream<String> lines) {
		this.lines = lines;
	}
	
	public static void main(String[] args) {
		GuessWord gw = new GuessWord();
		gw.readWord();
//		System.out.println(gw.word);
		gw.guess();
	}
}
