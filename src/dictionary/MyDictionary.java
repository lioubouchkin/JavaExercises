package dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class MyDictionary {

	private Set<String> words = new TreeSet<String>();
	BufferedReader br = null;
	BufferedWriter bw = null;
	private static final int BUFFER_SIZE = 256; // buffer size in bits
	
	public Set<String> readWords (File file) {
		int offset = 0;
		int numChar;
		char[] cbuf = new char[BUFFER_SIZE];
		StringBuilder word = new StringBuilder();
		try {
			this.br = new BufferedReader(new FileReader(file));
			numChar = this.br.read(cbuf, offset, BUFFER_SIZE);
			do {
				for (char ch : cbuf) {
					if (!String.valueOf(ch).matches("\\s")) {
						word.append(ch);
					} else {
						if (word.length() != 0) {
							words.add(word.toString().toLowerCase());
						}
						word = new StringBuilder();
					}
				}
				numChar = this.br.read(cbuf, offset, BUFFER_SIZE);
			} while (numChar != -1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			this.closeSilently();
		}
		return words;
	}
	
	public void writeToFile (File file, Set<String>words) {
		try {
			this.bw = new BufferedWriter (new FileWriter(file), BUFFER_SIZE);
			StringBuilder message = new StringBuilder("");
			for (String word : words ) {
				message = message.append(word).append("\n");
			}
			bw.write(message.toString());
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSilently();
		}
	}
	
	private void closeSilently() {
		try {
			if (this.br != null) {
				this.br.close();
			}
			if (this.bw != null) {
				this.bw.close();
			}
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
