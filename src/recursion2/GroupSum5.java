package recursion2;

//Given an array of ints, is it possible to choose a group of some of the ints, 
//such that the group sums to the given target with these additional constraints: 
//	all multiples of 5 in the array must be included in the group. 
//	If the value immediately following a multiple of 5 is 1, it must not be chosen. (No loops needed.)
public class GroupSum5 {
	public boolean sumEquals(int start, int[] nums, int target) {
		if ( start >= nums.length ) {
			return target == 0;
		}
		if ( (nums[start] % 5)  == 0 ) { 									// multiple of 5
			if ( (start < nums.length-1) && (nums[start+1] == 1) ) {		// 	TRUE : 1 immediately follows multiple of 5
				return sumEquals(start + 2, nums, target - nums[start]);
			}
			return sumEquals(start + 1, nums, target - nums[start]);		// 	FALSE : 1 immediately follows multiple of 5
		}
		if ( sumEquals(start+1, nums, target-nums[start]) ) {
			return true;
		}
		if ( sumEquals(start+1, nums, target) ) {
			return true;
		}
	
		return false;
	}
}
