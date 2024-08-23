package Algo;

import java.util.Arrays;
import java.util.Scanner;

public class Wine {
	public static void main(String[] args) {
//	4
//	1 4 2 3
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] in = new int[n];
		for (int i = 0; i < in.length; i++) {
			in[i] = sc.nextInt();
		}

		int[][] dp = new int[n][n];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println((maxProfit(0, dp.length - 1, dp, in, 1)));
	}

	private static int maxProfit(int i, int j, int[][] dp, int[] originalArray, int year) {
		if (i == j) {
			return year * originalArray[i];
		}
		if (dp[i][j] == -1) {
			dp[i][j] = Math.max(year * originalArray[j] + maxProfit(i, j - 1, dp, originalArray, year + 1),
					originalArray[i] * year + maxProfit(i + 1, j, dp, originalArray, year + 1));
		}
		return dp[i][j];
	}
}