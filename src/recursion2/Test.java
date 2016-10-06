package recursion2;

public class Test {
	public static void main(String[] args) {
		int start = 0;
		int[] nums = new int [] {
			2,2,20,30,2,64,3,2,2	
		};
		
		int sum = nums[start];
		int count = 1;
	    for (int i = start + 1; i < nums.length; i++) {
	        if (nums[i] == nums[start]) {
	            sum += nums[i];
	            count++;
	        } else
	        	break;
		}
	    System.out.println(count);
	}
}
