
package dictionaryBinaryTree;

import dictionaryBinaryTree.MySortedTree.MyTreeNode;

/**
 * class for purpose of stocking nodes of MySortedTree
 */
public class MyQueue<T extends Comparable<T>> {
	private QueueNode tail = null;
	private QueueNode head = null;
	
	private class QueueNode {
		MyTreeNode<T> item = null;
		QueueNode next = null;
		
		public QueueNode( MyTreeNode<T> treeNode ) {
			this.item = treeNode;
		}
	}
	
	
	/**
	 * allows to add a new item to the end of this queue. 
	 * @param newNode		MyTreeNode item to add to this queue
	 */
	public void enqueue( MyTreeNode<T> treeNode ) {
		QueueNode newNode = new QueueNode(treeNode);
		// the queue is empty
		if ( tail == null ) {
			// the tail and the head point to the same only element in the collection
			this.tail = newNode;
			this.head = newNode;
		// the queue is not empty
		} else {
			// the second from the end item of the collection keeps track with the tail
			this.tail.next = newNode;
			// the new element becomes the tail of the collection
			this.tail = newNode;
		}
	}
	
	/**
	 * get MyTreeNode element from this collection according to FIFO politics.
	 * @return	MyTreeNode element from this collection
	 */
	public MyTreeNode<T> dequeue() {
		if ( this.head == null) {
			throw new IllegalStateException("Can't perform a retrieve operation on an empty queue");
		}
		MyTreeNode<T> treeNode = this.head.item;
		// The previous second item is now first item in the collection.
		this.head = this.head.next;
		// no more elements left in the collection
		if ( this.head == null ) {
			this.tail = null;
		}
		return treeNode;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
}
