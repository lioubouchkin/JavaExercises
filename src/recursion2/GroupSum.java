package recursion2;

public class GroupSum {
	//Given an array of integers, determines if the group of some of the integers sums to the given target.
	public boolean sumEquals(int start, int[] nums, int target) {
	
		if ( start >= nums.length ) {
			return target == 0;
		}
		
		if ( sumEquals(start+1, nums, target) ) {
			return true;
		}
		
		if ( sumEquals(start+1, nums, target-nums[start]) ) {
			return true;
		}
		
		return false;
	}
}
