package recursion;

/**
 * Sum of a consecutive set of positive whole numbers (positive integers and zero)
 */
public class NaturalSequenceSum {
	public int calculate(int n) {
		return n == 0
				? 0 
				: n + calculate(n-1);
	}
}
