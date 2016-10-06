package dictionaryBinaryTree;

import java.io.BufferedReader;
import java.util.Iterator;

import dictionaryBinaryTree.MySortedTree.MyTreeNode;
import outils.Constants;
import outils.DataSource;

public class BinaryDictionary {
	private static int wordCounter = 0;
	
	public static void main(String[] args) {
		try {
			MySortedTree sortedWords = mySortedTreeTest_initialise();
			sortedWords.printInorder();
//			mySortedTreeTest_iterate(sortedWords);
//			MyQueue q = new MyQueue();
//			myQueueTest_enqueu(q);
//			myQueueTest_dequeu(q);
			sortedWords.printLevelOrder();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static MySortedTree insertInTree (String[] words, MySortedTree sortedWords) {
		for ( String word : words ) {
			word = word.trim().toLowerCase();
			if ( word.length() != 0 ) {
				++ wordCounter;
				sortedWords.insert(word);
			}
		}
		return sortedWords;
	}
	
	private static MySortedTree mySortedTreeTest_initialise () throws Exception {
		BufferedReader br;
		String[] words;
		MySortedTree sortedWords = new MySortedTree();
		br = DataSource.readTextFromFile(Constants.DIRECTORY, Constants.WORDS_INFILE);
		words =  DataSource.getWordsFromReader(br);
		DataSource.closeSources();
		sortedWords = insertInTree(words, sortedWords);
		System.out.println("words in file : " + wordCounter);
		System.out.println("words in list : " + sortedWords.count());
//		Iterator<String> wordIterator = sortedWords.iterator();
//		while (wordIterator.hasNext()) {
//			System.out.println(wordIterator.next());
//		}
//		for ( String s : sortedWords ) {
//			System.out.println(s);
//		}
		return sortedWords;
	}
	
	private static void mySortedTreeTest_iterate( MySortedTree myTree ) throws Exception {
		Iterator<String> wordIterator = myTree.iterator();
		while (wordIterator.hasNext()) {
			System.out.println(wordIterator.next());
		}
		for ( String s : myTree ) {
			System.out.println(s);
		}
	}
	
	private static void myQueueTest_enqueu( MyQueue q ) {
		MyTreeNode n1 = new MyTreeNode("one");
		MyTreeNode n2 = new MyTreeNode("two");
		MyTreeNode n3 = new MyTreeNode("three");
		q.enqueue(n1);
		q.enqueue(n2);
		q.enqueue(n3);
	}
	
	private static void myQueueTest_dequeu( MyQueue q ) {
		q.dequeue();
		q.dequeue();
		q.dequeue();
	}
} 