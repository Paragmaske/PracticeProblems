package LcDaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MaxProfit {
	static Map<Integer, List<Integer>> ad = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 1; i < n + 1; i++) {
			ad.put(i, new ArrayList<>());
		}
		for (int i = 2; i < n + 1; i++) {
			int num = sc.nextInt();
			List<Integer> list = ad.get(num);
			list.add(i);
			List<Integer> list2 = ad.get(i);
			list2.add(num);
			ad.put(i, list2);
			ad.put(num, list);
		}
		int[] profits = new int[n + 1];
		for (int i = 1; i < profits.length; i++) {
			profits[i] = sc.nextInt();
		}

		boolean[] visited = new boolean[n + 1];
		long[] ans = new long[n + 1];

		dfs(visited, 1, ans, profits);
		
		long maxAns=0;
		for(long i:ans)
		{
			if(i>maxAns)
			{
				maxAns=i;
			}
		}
System.out.println(maxAns);
	}

	private static int dfs(boolean[] visited, int i, long[] ans, int[] profits) {

		visited[i] = true;
		int ans1 = profits[i];
		for (int j : ad.get(i)) {
			if (visited[j] == false) {
				ans1 = ans1 + dfs(visited, j, ans, profits);
			}
		}
		ans[i] = ans1;
		return ans1;

	}
}