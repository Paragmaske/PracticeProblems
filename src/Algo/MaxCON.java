package Algo;

import sun.applet.Main;

public class MaxCON {

	public static int longestOnes(int[] nums, int k) {
		int left=0;
		int right=0;
		int maxAns=0;
		int countOfZeros=0;
		int firstZeroCount=0;
		while(right<nums.length)
		{
			if(countOfZeros>k)
			{
				maxAns=Math.max(maxAns,right-firstZeroCount-1) ;	
				countOfZeros--;
				
			}
			if(nums[right]==0)
			{
				if(countOfZeros==0)
				{
					firstZeroCount=right;
				}
				countOfZeros++;
			}
			right++;
		}
		return k;
		
		
	}

	public static void main(String[] args) {
		int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k = 3;
		System.out.println(longestOnes(nums, k));
	}
}
