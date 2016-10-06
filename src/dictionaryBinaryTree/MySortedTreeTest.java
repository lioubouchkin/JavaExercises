package dictionaryBinaryTree;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import dictionaryBinaryTree.MySortedTree.MyTreeNode;

//@RunWith(Parameterized.class)
public class MySortedTreeTest {
	private OutputStream out;
	private PrintStream ps;
	private MySortedTree tree;
	private String separator = System.getProperty("line.separator");
	
//	@Parameters
//    public static Object[] data() {
//        return new Object[] {
//                   "one", "two", "three", "four"
//           };
//    }
	
//	@Parameter // first data value (0) is default
//    public String fInput;
	
	@Before
	 public void setUp() {
		out = new ByteArrayOutputStream();
		ps = new PrintStream (out);
		System.setOut(ps);
		tree = new MySortedTree();
	}
	
	@After
	public void tearDown() throws Exception {
		if (ps != null) {
			ps.close();
		}
		System.setOut(System.out);
	}

//	@Test
//	public void testPrintAll() {
//		tree.insert("two");
//		tree.insert("one");
//		tree.insert("three");
//		tree.insert("four");
//		tree.insert("two");
//		tree.insert("one");
//		tree.insert("three");
//		tree.insert("two");
//		tree.printAll();
//		assertEquals("four"+separator+
//				"one"+separator+
//				"three"+separator+
//				"two"+separator, out.toString());
//	}
//	
//	@Test
//	public void testCount() {
//		tree.insert("four");
//		tree.insert("one");
//		tree.insert("three");
//		tree.insert("four");
//		tree.printAll();
//		assertEquals(tree.count(), 3);
//	}
//	
//	@Test
//	public void testIterator () {
//		tree.insert("two");
//		tree.insert("one");
//		tree.insert("three");
//		tree.insert("four");
//		StringBuilder sb = new StringBuilder("");
//		for (String s : tree) {
//			sb.append(s);
//		}
//		assertEquals(sb.toString(), "ok"+separator);
//	}
	
	@Test
	public void testEquals () {
		MyTreeNode n1 = new MyTreeNode("are");
		MyTreeNode n2 = new MyTreeNode("are");
		assertEquals(n1.equals(n2), true);
	}
	@Test
	public void testNotEquals () {
		MyTreeNode n1 = new MyTreeNode("are");
		String s ="are";
		assertEquals(n1.equals(s), false);
	}
	@Test
	public void testGreaterNodes () {
		MyTreeNode n1 = new MyTreeNode("not");
		MyTreeNode n2 = new MyTreeNode("and");
		assertEquals(n1.compareTo(n2) > 0, true);
	}
	@Test
	public void testLessNodes () {
		MyTreeNode n1 = new MyTreeNode("not");
		MyTreeNode n2 = new MyTreeNode("and");
		assertEquals(n2.compareTo(n1) < 0, true);
	}
	@Test
	public void testCompToEqual () {
		MyTreeNode n1 = new MyTreeNode("are");
		MyTreeNode n2 = new MyTreeNode("are");
		assertEquals(n2.compareTo(n1) == 0, true);
	}
}
