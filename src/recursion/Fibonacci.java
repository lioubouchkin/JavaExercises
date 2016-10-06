package recursion;

/**
 * Each subsequent value is the sum of the previous two values
 */
public class Fibonacci {
	
	public int calculate(int n) {
		switch (n) {
		case 0:
			return 0;
		default:
			return n == 1 ? 1 : calculate(n-1) + calculate(n-2);
		}
	}
}
