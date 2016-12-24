package recursion;
/**
 *	count the occurrences of the digit 8 in a non-negative integer,
 *		taking account of the fact, that another 8 to its left counts double
 *		ex : calculate(8) -> 1 , calculate(887) -> 3, calculate(878) -> 2
 */
public class OccurencesOf8 {
	public int calculate(int n) {
		if( n < 10 ) {
			return n % 10 == 8 
					? 1
					: 0 ;
		} else {
			if ( n % 10 == 8 ) {
				return (n / 10 ) % 10 == 8
						? (2 + calculate( n / 10) )
						: (1 + calculate( n / 10) ) ;
			}
			return 0 + calculate( n / 10 ) ;
		}
	}
}