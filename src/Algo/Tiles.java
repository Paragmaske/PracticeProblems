package Algo;

import java.util.Arrays;
import java.util.Scanner;

public class Tiles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] dp = new int[a + 1];
		Arrays.fill(dp, -1);
		
		System.out.println(findTiles(a, dp));
	}


	private static int findTiles(int a, int[] dp) {

		if(a==1 || a==2)
		{
			return a;
		}
		if(dp[a]==-1)
		{
			dp[a]=(findTiles(a-1, dp)+findTiles(a-2, dp))%1000000007;
			return dp[a];
		}
		return dp[a]%1000000007;
	}

}
