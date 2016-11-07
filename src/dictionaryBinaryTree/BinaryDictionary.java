package dictionaryBinaryTree;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Random;

import dictionaryBinaryTree.MySortedTree.MyTreeNode;
import outils.Constants;
import outils.DataSource;

public class BinaryDictionary {
	private static int wordCounter = 0;
	
	public static void main(String[] args) {
		try {
//			MySortedTree<String> sortedWords = mySortedTreeTest_initialise();
//			sortedWords.printInorder();
//			mySortedTreeTest_iterate(sortedWords);
//			MyQueue q = new MyQueue();
//			myQueueTest_enqueu(q);
//			myQueueTest_dequeu(q);
//			sortedWords.printLevelOrder();
			
			MySortedTree<Integer> numbers = new MySortedTree<Integer>();
			numbers = insertRandomInts();
			System.out.println(numbers.count());
			mySortedTreeTest_iterate(numbers);
			
			/*****************************
			 *  Exercise 9.5:
			 *  TestBinaryTreeBalance
			 ****************************/
			int countLeaves = numbers.countLeaves();
			int depthOfAllLeaves = numbers.depthOfAllLeaves();
			int maxDepth = numbers.maxDepth();
			System.out.println("countLeaves : "+countLeaves);
			System.out.println("depthOfAllLeaves : "+depthOfAllLeaves);
			System.out.println("maxDepth : "+maxDepth);
			System.out.println("the average depth : "+ (depthOfAllLeaves/countLeaves));
			/**************9.5***************/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static MySortedTree<Integer> insertRandomInts () {
		MySortedTree<Integer> numbers = new MySortedTree<Integer>();
		Random r = new Random();
		while ( numbers.count()<1023) {
			numbers.insert( r.nextInt(10000) );
		}
		return numbers;
	} 
	
	private static MySortedTree<String> insertInTree (String[] words, MySortedTree<String> sortedWords) {
		for ( String word : words ) {
			word = word.trim().toLowerCase();
			if ( word.length() != 0 ) {
				++ wordCounter;
				sortedWords.insert(word);
			}
		}
		return sortedWords;
	}
	
	private static MySortedTree<String> mySortedTreeTest_initialise () throws Exception {
		BufferedReader br;
		String[] words;
		MySortedTree<String> sortedWords = new MySortedTree<String>();
		br = DataSource.readTextFromFile(Constants.DIRECTORY, Constants.WORDS_INPUT_FILE);
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
	
	private static <T extends Comparable<T>> void mySortedTreeTest_iterate( MySortedTree<T> myTree ) throws Exception {
		Iterator<T> wordIterator = myTree.iterator();
		while (wordIterator.hasNext()) {
			System.out.println(wordIterator.next());
		}
//		System.out.println(wordIterator.hasNext());
//		System.out.println(wordIterator.next());
//		for ( Comparable c : myTree ) {
//			System.out.println(c);
//		}
	}
	
	private static void myQueueTest_enqueu( MyQueue<String> q ) {
		MyTreeNode<String> n1 = new MyTreeNode<String>("one");
		MyTreeNode<String> n2 = new MyTreeNode<String>("two");
		MyTreeNode<String> n3 = new MyTreeNode<String>("three");
		q.enqueue(n1);
		q.enqueue(n2);
		q.enqueue(n3);
	}
	
	private static void myQueueTest_dequeu( MyQueue<String> q ) {
		q.dequeue();
		q.dequeue();
		q.dequeue();
	}
} 