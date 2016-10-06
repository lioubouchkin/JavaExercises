package dictionary;

import java.io.File;
import java.nio.CharBuffer;
import java.nio.file.FileSystemException;
import java.util.Scanner;

import org.junit.experimental.theories.Theories;

public class IODirectories {
	private static final String DIRECTORY_PATH = "C:\\Users\\A0707220\\Documents\\temp";
	private static final String FILE_PATH_READ = "C:\\Users\\A0707220\\Documents\\temp\\words.txt";
	private static final String FILE_PATH_WRITE = "C:\\Users\\A0707220\\Documents\\temp\\wordsSorted.txt";
	Scanner sc = null;
	
	public IODirectories() {
		super();
		this.sc = new Scanner(System.in);
	}
	
	public File getFile (String message, boolean read) {
		File file = null;
		
		try {
			if (message == null || message.trim().length() == 0) {
				message = " Enter file name :";
			}
			System.out.println(message);
			String name = this.sc.next();
			if ( read ) {
				if ( new File(DIRECTORY_PATH, name).exists() && ! (new File(DIRECTORY_PATH, name).isDirectory()) ) {
					file = new File(DIRECTORY_PATH, name);
				} else {
					throw new FileSystemException("File does not exist or path indicates to a directory");
				}
			} else {
				if ( !new File(DIRECTORY_PATH, name).isDirectory() ) {
					file = new File(DIRECTORY_PATH, name);
				} else {
					throw new FileSystemException("Path indicates to a directory");
				}
			}
		} catch (FileSystemException fse) {
			fse.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}
	
	public void closeSources() {
		if (this.sc != null) {
			this.sc.close();
		}
	}
}
