package recursion2;


//Given an array of ints, is it possible to choose a group of some of the ints, 
//such that the group sums to the given target, with this additional constraint: 
//	if there are numbers in the array that are adjacent and have the identical value, 
//	they must either all be chosen, or none of them be chosen. 
//	For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle 
//		must be chosen or not, all as a group. (one loop can be used to find the extent of the identical values).
public class GroupSumClump {
!!!!!!!!!!!!!ERROR!!!!!!!!!!!!!	
	public boolean sumEquals(int start, int[] nums, int target) {
		
		if ( start >= nums.length ) {
			return target == 0;
		}
		
		if ( start < nums.length-1 ) {
			if ( nums[start] == nums[start+1] ) {
				sumEquals(start+1, nums, target-nums[start]);
			}
		}
		
		if ( start > 0 ) {
			if( nums[start] == nums[start-1] ) {
				sumEquals(start+1, nums, target-nums[start]);
			}
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
