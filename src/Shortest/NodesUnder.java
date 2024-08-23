package Shortest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NodesUnder {
	static Map<Integer, List<Integer>> ad = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 2;

		for (int i = 1; i < n + 1; i++) {
			ad.put(i, new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			int num = sc.nextInt();
			List<Integer> list = ad.get(num);
			list.add(count);
			List<Integer> list2 = ad.get(count);
			list2.add(num);
			ad.put(count, list2);
			ad.put(num, list);
			count++;
		}

		boolean[] visited = new boolean[n + 1];
		int[] ans = new int[n + 1];
		dfs(1, visited, ans);
		
		for(int i=1;i<ans.length;i++)
		{
			System.out.print(i+ " ");
		}
	}

	private static int dfs(int i, boolean[] visited, int[] ans) {
		visited[i]=true;
		int count=0;
		for(int me:ad.get(i))
		{
			if(visited[me]==false)
			{
				
				count+=dfs(me, visited, ans)+1;
				
			}
		}
		ans[i]=count;
		return count;

	}
}
