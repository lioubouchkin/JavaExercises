package recursion;
/**
 *	 compute recursively the number of lowercase 'x' chars in the string
 */
public class CountX {
	public int calculate (String x){
		if (x.length() == 0) {
			return 0;
		}
		if ( x.length() == 1 ) {
			return x.equals("x")
								? 1
								: 0 ;
		}
		return x.substring(x.length()-1, x.length()).equals("x")
								? 1 + calculate(x.substring(0, x.length()-1))
								: 0 + calculate(x.substring(0, x.length()-1)) ;
	}
}
