package dictionaryBinaryTree_balanceTest;

public class TestBinaryTreeBalance {
	
	public static void main(String[] args) {
		MySortedTree cl = new MySortedTree();
		TestBinaryTreeBalance test = new TestBinaryTreeBalance();
		cl = test.initialize_Collection(cl);
		System.out.println("countLeaves : "+cl.countLeaves());
		System.out.println("depthOfAllLeaves : "+cl.depthOfAllLeaves());
		System.out.println("maxDepth : "+cl.maxDepth());
	}
	
	public MySortedTree initialize_Collection (MySortedTree c) {
		c.insert("q");
		c.insert("s");
		c.insert("d");
		c.insert("f");
		c.insert("a");
		c.insert("z");
		c.insert("e");
		c.insert("w");
		c.insert("x");
		return c;
	}
}

class MySortedTree {
	private MyTreeNode 	root;
	private int depthOfAllLeaves;
	
	public MySortedTree() {
		super();
	}
	
	public void insert (String value) {		// the list is empty
		if ( this.root == null ) {
			this.root = new MyTreeNode(value);
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
	
	/**
	 * Count leaves(nodes without children) in this MySortedTree object
	 * @return		number of found leaves;
	 */
	public int countLeaves () {
		if ( this.root == null ) {
			return 0;
		}
		int result = countLeaves(this.root, 0);
		return result;
	}
	
	/**
	 * Count leaves(nodes without children) in this MySortedTree object
	 * @param node		MyTreeNode to examine;
	 * @param result	leaves found so far;
	 * @return			number of found leaves;
	 */
	private int countLeaves (MyTreeNode node, int result) {
		if ( node.leftChild != null ) {
			result = countLeaves( node.leftChild, result );
		}
		if ( node.rightChild != null ) {
			result = countLeaves( node.rightChild, result );
		}
		if ( node.leftChild == null && node.rightChild == null ) {
			++ result;
		}
		return result;
	}
	
	/**
	 * Calculates the sum of depths of all the leaves.
	 * @return	the sum of depths of all the leaves.
	 */
	public int depthOfAllLeaves() {
		if ( this.root == null ) {
			return 0;
		}
		this.depthOfAllLeaves = 0;
		this.depthOfAllLeaves(this.root, 0);
		return this.depthOfAllLeaves;
	}
	
	/**
	 * Calculates the sum of depths of all the leaves.
	 * @param node		MyTreeNode to examine
	 * @param result	depth calculated so far
	 */
	private void depthOfAllLeaves (MyTreeNode node, int result) {
		++result;
		if ( node.leftChild != null ) {
			depthOfAllLeaves( node.leftChild, result );
		}
		if ( node.rightChild != null ) {
			depthOfAllLeaves( node.rightChild, result );
		}
		if ( node.leftChild == null && node.rightChild == null ) {
			this.depthOfAllLeaves += result;
			System.out.println(node.item+":"+result);
		}
	}
	
	/**
	 * Calculates the maximum depth of this MySortedTree object
	 * @return	the maximum depth value of this MySortedTree object
	 */
	public int maxDepth() {
		if ( this.root == null ) {
			return 0;
		}
		return this.maxDepth(this.root, 0, 0);
	}
	
	/**
	 * Calculates the maximum depth of this MySortedTree object
	 * @param node					MyTreeNode to examine
	 * @param currentNodeDepth		the depth of the current MyTreeNode
	 * @param maxDepth				the max depth found so far
	 * @return						the maximum value of maxDepth and the value calculated by the function
	 */
	public int maxDepth(MyTreeNode node, int currentNodeDepth, int maxDepth) {
		++currentNodeDepth;
		if ( node.leftChild != null ) {
			maxDepth = maxDepth( node.leftChild, currentNodeDepth, maxDepth );
		}
		if ( node.rightChild != null ) {
			maxDepth = maxDepth( node.rightChild, currentNodeDepth, maxDepth );
		}
		if ( node.leftChild == null && node.rightChild == null ) {
			return maxDepth>currentNodeDepth ? maxDepth : currentNodeDepth;
		}
		return maxDepth;
	}
	
	static class MyTreeNode implements Comparable<MyTreeNode> {
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
			if ( obj instanceof MyTreeNode ) {
				if ( ((MyTreeNode)obj).item.equals(this.item) ) {
					return true;	
				}
			}
			return false;
		}
		
		@Override
		public String toString() {
			return this.item.toString();
		}
	}
}

