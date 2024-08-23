package Algo;

import java.util.ArrayList;

public class hell {
	public static void main(String[] args) {

		int[] ar = {1};
		
		System.out.println(minSwaps(ar));
	}

	public static int minSwaps(int[] nums) {
		
		
		int count1 = 0;
		for (int i : nums) {
			if (i == 1)
				count1++;
		}

		int end = 0;
		int start = 0;
		int minswaps = 0;
		int countOf1 = 0;
		int maxans = 0;
		while (end < nums.length*2) {
			if (nums[end%nums.length] == 1)
				countOf1++;
			if (end - start == (count1 - 1)) {
				
				maxans = Math.max(maxans, countOf1);
				if (nums[start%nums.length] %nums.length== 1) {
					countOf1--;
					
				}
				start++;
			}
			
			end++;

		}

		return count1 - maxans;
}}
