package recursion;

public class CountByPairs {
	
	/**
	 * We have a number of bunnies and each bunny has two big floppy ears.
	 * We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
	 */
	public int calculate (int n) {
		return n == 0 ? 0 : 2+calculate(n-1);
	}
}
