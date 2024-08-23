package Algo;

public class KodanesAlgorithm {
	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(largestSum(nums));
	}

	private static int largestSum(int[] nums) {

		int sum = Integer.MIN_VALUE;
		int windowSum = 0;
		for (int i = 0; i < nums.length; i++) {
			windowSum += nums[i];
			sum = Math.max(sum, windowSum);
			if (windowSum < 0) {
				windowSum = 0;
			}

		}
		return sum;
	}
}
