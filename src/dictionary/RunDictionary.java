package dictionary;

import java.io.File;
import java.util.TreeSet;

public class RunDictionary {
	
	private static final String DIREXTORY_PATH = "C:\\Users\\A0707220\\Documents\\temp";
	private static final String FILE_PATH_READ = "C:\\Users\\A0707220\\Documents\\temp\\words.txt";
	private static final String FILE_PATH_WRITE = "C:\\Users\\A0707220\\Documents\\temp\\wordsSorted.txt";
	
	public static void main(String[] args) {
		
		IODirectories directories = new IODirectories();
		String inputFileMessage = "Enter input file name :";
		String outputFileMessage ="Enter output file name :";
		
		MyDictionary dict = new MyDictionary();
		TreeSet<String> words = new TreeSet<String>();
		// read file
		File f = directories.getFile(inputFileMessage, true);
		if ( f != null) {
			words = (TreeSet<String>) dict.readWords( f );
			
			// write file
			f = directories.getFile(inputFileMessage, false);
			if ( f != null) {
				dict.writeToFile( f, words );
			}
		}
		directories.closeSources();
	}
}
