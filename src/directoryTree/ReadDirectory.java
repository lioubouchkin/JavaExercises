package directoryTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.DirectoryStream;
import java.util.Scanner;

public class ReadDirectory {
	
	private static final String HOME_DIRECTORY = "E:\\MyDocs\\temp";
	
	public static void main(String[] args) throws FileNotFoundException {
		ReadDirectory rd = new ReadDirectory();
		File file = new File(HOME_DIRECTORY, rd.directoryToRead());
		if (file.exists()) {
			rd.readDirectory (file, 0, 0);
		} else {
			System.out.println("No such file found");
		}
	}
	
	private String directoryToRead () {
		String directory = "";
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("directory to read:");
			directory = sc.nextLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return directory;
	}
	
	private void readDirectory (File file, int fromInd, int tab) {
		// current object is a file
		if ( file.isFile() ) {
			for (int i = tab; i>0; i--) {
				System.out.print("|\t");
			}
			System.out.println(file.getName());
			// TODO return this file name
			return;
		} 
		// current object is a directory
		else {
			// the first file in the directory to read.
			if ( fromInd == 0 ) {
				// tabulation
				for (int i = tab; i>0; i--) {
					if (i == 1) {
						System.out.print("|-------");
					}
					else {
						System.out.print("|\t");
					}
				}
				// print the directory name.
				System.out.println(file.getName());
				// tabulation moves forward one level
				++tab;
			}
			// to continue on reading files from this directory.
			if ( fromInd < file.list().length ) {
				String currentFile = file.list()[fromInd];
				File toRead = new File(file, currentFile);
				// read the current file
				readDirectory (toRead, 0, tab);
				// check the next file
				readDirectory(file, ++fromInd, tab);
			}
			// last file in the directory is read 
			else {
				return;
			}
		}
	}
}
