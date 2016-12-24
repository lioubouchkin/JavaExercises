package recursion;

/**
 * The odd numbers have the value of 2. The even numbers have the value of 3.
 */
public class CountByPairsEvenOdd {
	
	public int calculate (int n) {
		switch (n) {
		case 0:
			return 0;
		default:
			return (n % 2) == 1
						? 2 + calculate(n-1) 
						: 3 + calculate(n-1);
		}
	}
}
