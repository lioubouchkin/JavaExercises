package dictionaryBinaryTree;

import java.util.Iterator;
import java.util.Stack;

import javax.swing.tree.MutableTreeNode;

public class MySortedTree implements Iterable<String> {
	private MyTreeNode root;
	private long allElements = 0;
	
	public MySortedTree() {
		super();
	}
	
	public void insert (String value) {		// the list is empty
		if ( this.root == null ) {
			this.root = new MyTreeNode(value);
			++ this.allElements;
			return;
		}
		// runs down the tree to find the place for a new item,
		//	starts form the root item.
		MyTreeNode runner = this.root;
		while ( true ) {
			// the value is to be placed on the left of the compared node
			if ( value.compareTo(runner.item) < 0 ) {
				if ( runner.leftChild == null ) {
					runner.leftChild = new MyTreeNode(value);
					runner.leftChild.parent = runner;
					++ this.allElements;
					return;
				} else {
					runner = runner.leftChild;
				}
			}
			// the value is to be placed on the right of the compared node
			if ( value.compareTo(runner.item) > 0 ) {
				if ( runner.rightChild == null ) {
					runner.rightChild = new MyTreeNode(value);
					runner.rightChild.parent = runner;
					++ this.allElements;
					return;
				} else {
					runner = runner.rightChild;
				}
			}
			// the value already exists in the list
			if ( value.compareTo(runner.item) == 0 ) {
				return;
			}
		}
	}
	
	public void printInorder () {
		System.out.println("*************** InOrder tree traversal ***************");
		this.printInorder(this.root);
		System.out.println("*************** END InOrder ***************");
	}
	
	// inorder nodes traversal: left child first, then root node, then right child 
	private void printInorder( MyTreeNode node ) {
		if ( node.leftChild != null ) {
			this.printInorder( node.leftChild );
		}
		System.out.println(node.item);
		if ( node.rightChild != null ) {
			this.printInorder( node.rightChild );
		}
	}
	
	public long count() {
		return this.allElements;
	}
	
   /**
    * Use a queue to print all the strings in the tree to which
    * root points.  (The nodes will be listed in "level order",
    * that is:  first the root, then children of the root, then
    * grandchildren of the root, and so on.)
    */
	public void printLevelOrder() {
		MyTreeNode 	treeNode;
		MyQueue 	queque;
		int			level = 0;
		// the collection is empty
		if ( this.root == null ) {
			throw new IllegalStateException("Cannot perform print operation on an empty collection");
		}
		queque = new MyQueue();
		queque.enqueue(root);
		while ( !queque.isEmpty() ) {
			treeNode = queque.dequeue();
			System.out.println(treeNode);
			if ( treeNode.rightChild != null ) {
				queque.enqueue(treeNode.rightChild);
			}
			if ( treeNode.leftChild != null ) {
				queque.enqueue(treeNode.leftChild);
			}
			++ level;
		}
	}
	
	@Override
	public Iterator<String> iterator() {
		return new MyTreeIterator(this.root);
	}
	
	static class MyTreeNode implements Comparable<MyTreeNode>{
		private MyTreeNode 	leftChild;
		private MyTreeNode 	rightChild;
		private MyTreeNode 	parent;
		private String 		item;
		
		public MyTreeNode(String item) {
			this.item = item;
		}

		@Override
		public int compareTo(MyTreeNode node) {
			return this.item.compareTo(node.item);
		}
		@Override
		public boolean equals(Object obj) {
			if ( obj.getClass().getName() == MyTreeNode.class.getName() ){
				MyTreeNode node = (MyTreeNode) obj;
				return this.item.compareTo(node.item) == 0 ;
			}
			return false;
		}
		
		@Override
		public String toString() {
			return this.item;
		}
	}
	
	private class MyTreeIterator implements Iterator<String> {
		private MyTreeNode next;
		/* stack is loaded the next way starting from the utmost left down (the smallest) element:
		 * while (right child) 
		 * 		then if(left child)
		 * 			then while (left child)
		 * 			end while
		 * 		end if
		 * end while
		 * else 
		 * 		then parent
		 * end else 		
		 */
		Stack<MyTreeNode> pile = new Stack<MyTreeNode>();
		
		public MyTreeIterator(MyTreeNode root) {
			this.iterateToFirst(root);
		}
		
		// load the right branch to the stack : beginning from the root ending at the smallest element
		private void iterateToFirst( MyTreeNode root) {
			// in case of an empty TreeList
			if ( root == null ) {
				return;
			}
			if ( root.leftChild == null ) {
				this.pile.push(root);
				return;
			} else {
				this.pile.push(root);
				this.iterateToFirst (root.leftChild);
			}
		}
		
		// right after initialization of the Iterator the cursor is before the first element,
		//		the next element is the first element;
		@Override
		public boolean hasNext() {
			return this.pile.empty();
		}
		
		@Override
		public String next() {
			MyTreeNode current;
			MyTreeNode next;
			if ( this.hasNext() ) {
				current = this.pile.pop();
				next = current.rightChild;
				
				if ( next != null ) {
					this.pile.push(next);
					while (next.leftChild != null) {
						next = next.leftChild;
						pile.push(next);
					}
				}
				return next.item;
			}
			return null;
		}
	}
}