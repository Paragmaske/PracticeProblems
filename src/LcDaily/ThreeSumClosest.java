package LcDaily;

import java.util.Arrays;

public class ThreeSumClosest {
	public static void main(String[] args) {
		int[] nums = {0,1,2};
		int target = 3;
		
		System.out.println(threeSumClosest(nums, target));
		// Output: 2
		// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	}

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int closestSum = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length-2; i++) {
			
			int lp=i+1;
			int rp=nums.length-1;
			
			
			while(lp<rp)
			{
				int currSum=nums[i]+nums[lp]+nums[rp];
				
				if(Math.abs(target-currSum)<Math.abs(closestSum-target))
				{
					closestSum=currSum;
				}
				if(currSum>target)
				{
					rp--;
				}
				if(currSum<target)
				{
					lp++;
				}
			}
		}
		return closestSum;
	}
}
