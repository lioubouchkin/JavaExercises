package networking.exercise11_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.NotDirectoryException;
import java.security.InvalidParameterException;
import java.util.Scanner;

/**
 * This program is one end of a simple command-line interface chat program. It
 * acts as a client which makes a connection to a CLChatServer program. The
 * computer to connect to can be given as a command line argument. If it is not,
 * then the program prompts the user for computer name or IP and for port
 * number. If a computer is specified on the command line, a port number can
 * also be specified as the second command-line argument; if no second argument
 * is specified, the default port number is used. Once a connection has been
 * established, the two ends of the connection each send a HANDSHAKE string to
 * the other, so that both ends can verify that the program on the other end is
 * of the right type. Then the connected programs alternate sending messages to
 * each other. The client always sends the first message. The user on either end
 * can close the connection by entering the string "quit" when prompted for a
 * message. Note that the first character of any string sent over the connection
 * must be 0 or 1; this character is interpreted as a command.
 */
class FTClient {

	/**
	 * Port number on server, if none is specified on the command line.
	 */
	static final String DEFAULT_MACHINE = "localhost";
	
	/**
	 * Port number on server, if none is specified on the command line.
	 */
	static final int DEFAULT_PORT = 1728;

	/**
	 * Handshake string. Each end of the connection sends this string to the
	 * other just after the connection is opened. This is done to confirm that
	 * the program on the other side of the connection is a CLChat program.
	 */
	static final String HANDSHAKE = "FileTransfert";

	/**
	 * This character is prepended to every message that is sent.
	 */
	static final char MESSAGE = '0';

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

	// instance fields
	static Socket connection; // For communication with the server.

	static BufferedReader incoming; // Stream for receiving data from server.
	static PrintWriter outgoing; // Stream for sending data to server.
	static String messageOut; // A message to be sent to the server.
	static String messageIn; // A message received from the server.

	static Scanner userInput; // A wrapper for System.in, for reading
						// lines of input from the user.
	
	public static void main(String[] args) {

		String computer; // The computer where the server is running,
							// as specified on the command line. It can
							// be either an IP number or a domain name.

		int port; // The port on which the server listens.

		/* First, get the computer and port number. */
		computer = DEFAULT_MACHINE;
		port = DEFAULT_PORT;

		/*
		 * Open a connection to the server. Create streams for communication and
		 * exchange the handshake.
		 */

		try {
			System.out.println("Connecting to " + computer + " on port " + port);
			connection = new Socket(computer, port);
			incoming = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			outgoing = new PrintWriter(connection.getOutputStream());
			outgoing.println(HANDSHAKE); // Send handshake to client.
			outgoing.flush();
			messageIn = incoming.readLine(); // Receive handshake from client.
			if ( !messageIn.equals(HANDSHAKE) ) {
				throw new IOException("Connected program is not FTServer!");
			}
			
			System.out.println("Connected. Enter your command.");
		} catch (Exception e) {
			System.out.println("An error occurred while opening connection.");
			System.out.println(e.toString());
			return;
		}

		
		/*
		 * Exchange messages with the other end of the connection until one side
		 * or the other closes the connection. This client program sends the
		 * first message. After that, messages alternate strictly back and
		 * forth.
		 */
		try {
			userInput = new Scanner(System.in);
			System.out.println("NOTE: Enter 'quit' to end the program.\n");
			connection: 
				while (true) {
					
					System.out.print("SEND:      ");
					messageOut = userInput.nextLine();
					switch (messageOut) {
					case "quit":
						// User wants to quit. Inform the other side
						// of the connection, then close the connection.
						outgoing.println(CLOSE);
						outgoing.flush();
						connection.close();
						System.out.println("Connection closed.");
						break connection;
					case "list":
						outgoing.println(LIST);
						break;
					default:
						outgoing.println(String.valueOf(LIST)+messageOut);
						break;
					}
					
					outgoing.println(MESSAGE + messageOut);
					outgoing.flush();
					if (outgoing.checkError()) {
						throw new IOException("Error occurred while transmitting message.");
					}
					System.out.println("WAITING...");
				}
		} catch (Exception e) {
			System.out.println("Sorry, an error has occurred.  Connection lost.");
			System.out.println(e.toString());
			System.exit(1);
		}
	}
}
