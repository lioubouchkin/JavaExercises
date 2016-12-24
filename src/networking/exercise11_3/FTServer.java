package networking.exercise11_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.NotDirectoryException;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class FTServer {
	/**
	 * Port to listen on, if none is specified on the command line.
	 */
	static final int DEFAULT_PORT = 1728;

	/**
	 * Handshake string. Each end of the connection sends this string to the
	 * other just after the connection is opened. This is done to confirm that
	 * the program on the other side of the connection is a FTServer program.
	 */
	static final String HANDSHAKE = "FileTransfert";

	/**
	 * This character is sent to the connected program when the user quits.
	 */
	static final char CLOSE = '0';
	/**
	 * This character is sent to the connected program when the user wants to get the list of available files.
	 */
	static final char LIST = '1';
	/**
	 * This character is sent to the connected program when the user wants to get the list of available files.
	 */
	static final char FILE = '2';
	/**
	 * Working directory  
	 */
	static String directory;
	/**
	 * working directory for test purpose
	 */
	static String workDirectory = "C:\\Users\\A0707220\\Documents\\Training";
	
	// instance properties
	static ServerSocket listener; // Listens for a connection request.
	static Socket connection = null; // For communication with the client.

	static BufferedReader incoming; // Stream for receiving data from client.
	static PrintWriter outgoing; // Stream for sending data to client.
	static StringBuilder messageOut = new StringBuilder(); // A message to be sent to the client.
	static String messageIn; // A message received from the client.

	static Scanner userInput; // A wrapper for System.in, for reading
						// lines of input from the user.
	static String[] files;	// files in the directory passed in the parameter
	
	public static void main(String[] args) {
		/*
		 * Wait for a connection request. When it arrives, close down the
		 * listener. Create streams for communication and exchange the
		 * handshake.
		 */
		try {
			listener = new ServerSocket(DEFAULT_PORT);
			System.out.println("Listening on port " + listener.getLocalPort());
			connection = listener.accept();
			listener.close();
			incoming = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			outgoing = new PrintWriter(connection.getOutputStream());
			outgoing.println(HANDSHAKE); // Send handshake to client.
			outgoing.flush();
			messageIn = incoming.readLine(); // Receive handshake from client.
			if ( !HANDSHAKE.equals(messageIn) ) {
				throw new Exception("Connected program is not a FTClient!");
			}
			if ( args.length == 0 ) {
				throw new InvalidParameterException("Not valid operation without parameter");
			} else {
				files = readDirectory(args[0]);
			}
			System.out.println("Connected. Enter filename to transfer.");
		} catch (Exception e) {
			System.out.println("An error occurred while opening connection.");
			System.out.println(e.toString());
			return;
		}

		/*
		 * Exchange messages with the other end of the connection until the client closes the connection.
		 */

		try {
			userInput = new Scanner(System.in);
			System.out.println("NOTE: Enter 'quit' to end the program.\n");
			connex: 
				while (true) {
					System.out.println("WAITING...");
					messageIn = readLineInMessage();
					System.out.println("RECEIVED:  " + messageIn);
					if (messageIn.length() > 0) {
						// The first character of the message is a command.
						switch ( messageIn.charAt(0) ) {
						// close connection
						case CLOSE:
							System.out.println("Connection closed at other end.");
							connection.close();
							break connex;
						// display files list
						case LIST: 
							for (String file : files) {
								messageOut.append(file+"\n");
							}
							outgoing.print(messageOut.toString());
							break;
						// transfer file
						case FILE:
							if ( FTServer.fileExists(messageIn.substring(1)) ) {
								BufferedReader br = FTServer.readFile(messageIn.substring(1));
								char[] buf = new char[256];
								while (br.read(buf) != -1) {
									messageOut.append(new String(buf));
								}
							} else {
								System.out.println("File not found !");
							}
							break;
						// invalid command
						default:
							throw new Exception("Invalid command");
						}
					}
					outgoing.flush(); // Make sure the data is sent!
					if (outgoing.checkError()) {
						throw new IOException("Error occurred while transmitting message.");
					}
				}
		} catch (Exception e) {
			System.out.println("Sorry, an error has occurred. Connection lost.");
			System.out.println("Error:  " + e);
			System.exit(1);
		} finally {
			try {
				connection.close();
			} catch (IOException e) {
				System.out.println("An error occurred while closing connection.");
				System.out.println(e.toString());
			}
		}
	}
	
	public static String readLineInMessage () throws IOException {
		try {
			return incoming.readLine();
		} catch (IOException e) {
			throw e;
		}
	}
	
	private static String[] readDirectory(String dir) throws Exception {
		File directory = new File(dir);
		if (!directory.isDirectory()) {
			if (directory.exists() == false)
				throw new FileNotFoundException("No directory found !");
			else
				throw new NotDirectoryException("The file is not a directory !");
		} else {
			FTServer.directory = dir;
			return directory.list();
		}
	}
	
	private static BufferedReader readFile (String file) throws IOException {
		FileReader fis = new FileReader( new File(FTServer.directory, file));
		BufferedReader br = new BufferedReader(fis);
		return br;
	}
	
	private static boolean fileExists (String fName) throws IOException {
		File f = new File(FTServer.directory, fName);
		return f.exists() && f.isFile() && f.canRead();
	}
}
