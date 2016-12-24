package recursion2;

//Given an array of integers, determines if the group of some of the integers 
//	sums to the given target (with the constraint that all 6's must be chosen).
public class GroupSum6 {
	
	public boolean sumEquals(int start, int[] nums, int target) {
		
		if ( start >= nums.length ) {
			return target == 0;
		}
		if ( nums[start] == 6 ) {
			return sumEquals(start + 1, nums, target - nums[start]);
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
