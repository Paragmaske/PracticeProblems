package Algo;

import java.util.Arrays;

public class SortArray {
	public static int[] sortArray(int[] nums) {

if(nums.length==1)
{
	return nums;
		
	}
int mid=nums.length/2;
int[] left=sortArray(Arrays.copyOfRange(nums, 0, mid));
int[] right=sortArray(Arrays.copyOfRange(nums, mid, nums.length));
return merge(left, right);



	}

	private static int[] merge(int[] left, int[] right) {
		int lp = 0;
		int rp = 0;
		int fp = 0;
		int[] ans = new int[left.length + right.length];

		while (lp < left.length && rp < right.length) {

			if (left[lp] < right[rp]) {
				ans[fp] = left[lp];
				lp++;
				fp++;
			} else {
				ans[fp] = right[rp];
				rp++;
				fp++;
			}
		}

		while (lp < left.length) {
			ans[fp] = left[lp];
			fp++;
			lp++;
		}
		while (rp < right.length) {
			ans[fp] = left[rp];
			fp++;
			rp++;
		}

		return ans;
	}

	public static void main(String[] args) {

		int[] a = {5,2,3,1};
		int[] sortArray = sortArray(a);
		for(int i:sortArray)
		{
			System.out.println(i);
		}
	}
}
