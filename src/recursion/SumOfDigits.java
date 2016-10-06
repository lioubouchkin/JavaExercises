package recursion;

/**
 * calculate the sum of digits of a given non-negative integer (126 => 1 + 2 + 6 = 9) 
 */
public class SumOfDigits {
	public int calculate (int n) {
		return n < 10 
					? n % 10
					: n % 10 + calculate(n/10);
	}
}
