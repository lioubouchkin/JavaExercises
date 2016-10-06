package line_counter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class CountLines {
	static final String PACKAGE_NAME = "line_counter\\";
	private static final String OUTPUT_FILE = "output.txt";
	
	private BufferedReader br = null;
	private BufferedWriter bw = null;
	HashMap<String, Integer> results = new HashMap<String, Integer>();

	private void execute (String fileName) {
		try {
			File f = new File(CountLines.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath(),
					PACKAGE_NAME + fileName);
			this.results.put(fileName, 
					this.readAndCount(f));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			System.out.println( "ERROR execute : " + e.getMessage() );
		} catch (Exception e) {
			System.out.println("ERROR execute : " + e.getMessage());
		} finally {
			this.closeSilently();
		}
		
	}
	
	public static void main(String[] args) {
		if (args.length != 0) {
			CountLines cl = new CountLines();
			for (String fName : args) {
				cl.execute(fName);
			}
			cl.writeResults();
		} else {
			System.out.println("Argument(s) is(are) missing");
		}
	}
	
	private int readAndCount (File file) throws IOException {
		FileReader fis = new FileReader(file);
		this.br = new BufferedReader(fis);
		int counter = 0;
		while (br.readLine() != null) {
			counter++;
		}
		return counter;
	}
	
	private void writeResults () {
		try {
			File file = new File( CountLines.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath(),
					PACKAGE_NAME + OUTPUT_FILE);
			this.bw = new BufferedWriter(new FileWriter (file));
			this.results.forEach(new BiConsumer<String, Integer>() {
				@Override
				public void accept(String t, Integer u) {
					try {
						CountLines.this.bw.write(t + " : " + u);
						CountLines.this.bw.newLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			CountLines.this.bw.flush();
			this.closeSilently();
		} catch (Exception e) {
			System.out.println("ERROR writeResults : " + e.getMessage());
		}
	}
	
	private void closeSilently () {
		try {
			if ( this.br != null ) {
				this.br.close();
			}
			if ( this.bw != null ) {
				this.bw.close();
			}
		} catch (Exception e) {
			 System.out.println( "ERROR closeSilently" + e.getMessage() );
		}
	}

}
