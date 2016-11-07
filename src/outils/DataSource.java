package outils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataSource {
	private static BufferedReader br;

	public static BufferedReader readTextFromFile(String directory, String file) throws Exception {
		File f = new File(directory, file);
		if ( f.exists() && f.isFile() && f.canRead() ) {
			br = new BufferedReader( new FileReader(f));
			return br;
		} else {
			throw new Exception("File can't be acccesed");
		}
	}
	
	// extract separate strings from the BufferdReader stream
	public static String[] getWordsFromReader ( BufferedReader br ) throws IOException {
		ArrayList<String> alWords = new ArrayList<>();
		String line;
		while ( (line = br.readLine()) != null ) {
			String[] words = line.split("\\s");
			for ( String word : words ) {
				word = word.trim().toLowerCase();
				if ( word.length() != 0 ) {
					alWords.add(word);
				}
			}
		}
		return alWords.toArray(new String[alWords.size()]);
	}
	
	// extract separate strings from the BufferdReader stream,
	//	convert these string to integers.
	public static int[] getIntegersFromReader ( BufferedReader br ) throws IOException {
		String[] numbers = getWordsFromReader(br);
		int[] result = new int[numbers.length];
		for ( int i = 0; i<numbers.length; i++ ) {
			result[i] = Integer.valueOf( numbers[i] );
		}
		return result;
	}
	
	public static void closeSources () throws IOException {
		if ( br != null ) {
			br.close();
		}
	}
}
