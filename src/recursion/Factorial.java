package recursion;

public class Factorial {
	public int calculate (int n) {
		return n == 1 ? 1 : n * calculate(n-1);
	}
}
