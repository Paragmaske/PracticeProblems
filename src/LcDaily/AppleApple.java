package LcDaily;

import java.util.*;

public class AppleApple {
	static Map<Integer, List<Integer>> adjList = new HashMap<>();

	public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {

		for (int i = 0; i <= n; i++) {
			adjList.put(i, new ArrayList<>());
		}

		for (int i = 0; i < edges.length; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			List<Integer> lista = adjList.get(a);
			List<Integer> listb = adjList.get(b);
			lista.add(b);
			listb.add(a);
		}
		boolean[] isVisted = new boolean[n];
		int[] dist = new int[n];
		int dfs = dfs(0, hasApple, isVisted, 0);
		return dfs;
	}

	private static int dfs(int i, List<Boolean> hasApple, boolean[] isVisted, int myCost) {

		if (isVisted[i] == true)
			return 0;
		isVisted[i] = true;
		int childCost = 0;
		for (int ele : adjList.get(i)) {

			childCost += dfs(ele, hasApple, isVisted, 2);

		}
		if (childCost == 0 && hasApple.get(i) == false) {
			return 0;
		}
		return myCost + childCost;
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		Boolean[] apple = { false, false, true, false, false, true, false };
		List<Boolean> hasApple = Arrays.asList(apple);
		System.out.println(minTime(7, edges, hasApple));
 	}
}
