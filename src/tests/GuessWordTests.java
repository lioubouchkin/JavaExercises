package tests;

import java.io.IOException;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import guessWord.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GuessWordTests {
	static GuessWord guessWord;
	
	@BeforeClass
	public static void setUpClass() {
		guessWord = new GuessWord();
		guessWord.accessFile();
	}
	
	@AfterClass
	public static void tearDownClass() {
		guessWord.closeStream();
	}
	
	@Test
	public void a_fileAccess() {
		try {
			assertTrue(guessWord.getBr().ready());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void b_countLinesInFile() {
		guessWord.setLines(guessWord.getBr().lines());
//		assertEquals(7, guessWord.getLines().count());
	}
	
	@Test
	public void c_generateRandomLineNumber() {
		assertTrue(guessWord.randomLine((int)guessWord.getLines().count()) < 8);
	}
}
