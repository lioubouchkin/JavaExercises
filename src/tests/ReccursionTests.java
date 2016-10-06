package tests;

import recursion.*;
import recursion2.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReccursionTests {
	
//	@Test
//	public void factorial () {
//		Factorial f = new Factorial();
//		assertEquals(6, f.calculate(3));
//		assertEquals(24, f.calculate(4));
//	}
//	
//	@Test
//	public void countByPairs () {
//		CountByPairs f = new CountByPairs();
//		assertEquals(0, f.calculate(0));
//		assertEquals(6, f.calculate(3));
//		assertEquals(8, f.calculate(4));
//	}
//	
//	@Test
//	public void fibonacci () {
//		Fibonacci f = new Fibonacci();
//		assertEquals(0, f.calculate(0));
//		assertEquals(1, f.calculate(2));
//		assertEquals(8, f.calculate(6));
//		assertEquals(21, f.calculate(8));
//	}
//	
//	@Test
//	public void countByPairsOddEven() {
//		CountByPairsEvenOdd p = new CountByPairsEvenOdd();
//		assertEquals(0, p.calculate(0));
//		assertEquals(2, p.calculate(1));
//		assertEquals(5, p.calculate(2));
//	}
//	
//	@Test
//	public void naturalSequenceSum() {
//		NaturalSequenceSum s = new NaturalSequenceSum();
//		assertEquals(0, s.calculate(0));
//		assertEquals(1, s.calculate(1));
//		assertEquals(3, s.calculate(2));
//		assertEquals(15, s.calculate(5));
//	}
//	
//	@Test
//	public void sumOfDigits() {
//		SumOfDigits s = new SumOfDigits();
//		assertEquals(9, s.calculate(441));
//		assertEquals(0, s.calculate(0));
//		assertEquals(5, s.calculate(1112));
//	}
//	
//	@Test
//	public void occurencesOf7() {
//		OccurencesOf7 s = new OccurencesOf7();
//		assertEquals(1, s.calculate(471));
//		assertEquals(0, s.calculate(4506));
//		assertEquals(3, s.calculate(11727567));
//	}
//	
//	@Test
//	public void occurencesOf8(){
//		OccurencesOf8 s = new OccurencesOf8();
//		assertEquals(1, s.calculate(384));
//		assertEquals(3, s.calculate(388));
//		assertEquals(0, s.calculate(4));
//		assertEquals(6, s.calculate(388878));
//	}
//	
//	@Test
//	public void powerN(){
//		PowerN s = new PowerN();
//		assertEquals(1, s.calculate(1,1));
//		assertEquals(9, s.calculate(3,2));
//		assertEquals(16, s.calculate(2,4));
//		assertEquals(1024, s.calculate(2,10));
//	}
	
//	@Test
//	public void countX(){
//		CountX s = new CountX();
//		assertEquals(1, s.calculate("x"));
//		assertEquals(1, s.calculate("Xx"));
//		assertEquals(1, s.calculate("dxXdX"));
//		assertEquals(0, s.calculate(""));
//	}
	
//	@Test
//	public void testGroupSum(){
//		GroupSum s = new GroupSum();
//		assertEquals(true, s.sumEquals(0, new int[]{2, 5, 10, 4}, 12));
//		assertEquals(true, s.sumEquals(0, new int[]{2, 7, 8, 3, 12, 1}, 6));
//		assertEquals(false, s.sumEquals(0, new int[]{2, 4, 8}, 9));
//		assertEquals(true, s.sumEquals(0, new int[]{2, 4, 8}, 8));
//		assertEquals(true, s.sumEquals(0, new int[]{2, 4, 8}, 6));
//	}
	
//	@Test
//	public void testGroupSum6(){
//		GroupSum6 s = new GroupSum6();
//		assertEquals(false, s.sumEquals(0, new int[]{5, 6, 2}, 7));
//		assertEquals(false, s.sumEquals(0, new int[]{5, 2, 4, 6}, 9));
//		assertEquals(false, s.sumEquals(0, new int[]{3, 2, 4, 6}, 3));
//		assertEquals(false, s.sumEquals(0, new int[]{1, 6, 2, 6, 4}, 9));
//	}
	
	@Test
	public void groupSumClump(){
		GroupSumClump s = new GroupSumClump();
		assertEquals(false, s.sumEquals(0, new int[]{2, 4, 4, 8}, 14));
//		assertEquals(false, s.sumEquals(0, new int[]{8, 2, 2, 1}, 11));
//		assertEquals(true, s.sumEquals(0, new int[]{8, 2, 2, 1}, 9));
//		assertEquals(true, s.sumEquals(0, new int[]{1, 2, 4, 8, 1}, 14));
	}	
}
