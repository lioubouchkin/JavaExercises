package dictionaryBinaryTree;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

//@RunWith(Parameterized.class)
public class MyQueueTest {

	@Parameters
	public static Object[] data() {
	    return new Object[][] {
	    	{"one", "two"}, {"three", "four"}, {"three", "four"}
	    };
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
