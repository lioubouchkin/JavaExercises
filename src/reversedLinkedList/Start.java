package reversedLinkedList;

import java.awt.List;
import java.io.BufferedReader;
import java.util.Iterator;

import outils.Constants;
import outils.DataSource;

public class Start {

	public static void main(String[] args) {
		MyLinkedList myList = new MyLinkedList();
		MyLinkedList revList = new MyLinkedList();
		try {
			BufferedReader br = DataSource.readTextFromFile(Constants.DIRECTORY, Constants.INTEGERS_INFILE);
			int[] numbers = DataSource.getIntegersFromReader(br);
			DataSource.closeSources();
			for (int i : numbers ) {
				myList.add(i);
			}
			printList(myList);
			revList = myList.reverseList();
			printList(revList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void printList (MyLinkedList myList) {
		for ( int i : myList ) {
			System.out.println(i);
		}
		System.out.println("*****************************");
	}

}
