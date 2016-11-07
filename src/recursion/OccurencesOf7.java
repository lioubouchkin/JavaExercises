package recursion;

/**
 *	count the occurrences of the digit 7 in a non-negative integer 
 */
public class OccurencesOf7 {
	public int calculate(int n) {
		if (n < 10) {
			return n % 10 == 7
							? 1
							: 0;
		}
		return n % 10 == 7
				? 1 + calculate(n/10)
				: 0 + calculate(n/10);
	}
}
