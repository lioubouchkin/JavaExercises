package recursion;
/**
 *	given base and n that are both 1 or more, compute the value of base to the n power
 */
public class PowerN {

	public int calculate (int base, int n) {
		if ( n > 1 ) {
			return base * calculate( base, --n );
		}
		return base;
	}
}
