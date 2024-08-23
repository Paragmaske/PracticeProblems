package Algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CycleInDirectGraph {
	static Map<Integer, List<Integer>> adj = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt();
		int n = sc.nextInt();
		int[][] a = new int[n][2];

		for (int i = 0; i < a.length; i++) {
			a[i][0] = sc.nextInt();
			a[i][1] = sc.nextInt();

			List<Integer> orDefault = adj.getOrDefault(a[i][0], new ArrayList<Integer>());
			orDefault.add(a[i][1]);
			adj.put(a[i][0], orDefault);
		}

		boolean[] visited = new boolean[nodes + 1];
		boolean[] currentPathVisited = new boolean[nodes + 1];
		System.out.println(isCyclePresent(visited, currentPathVisited));
	}

	private static boolean isCyclePresent(boolean[] visited, boolean[] currentPathVisited) {

		for (int i = 1; i < visited.length; i++) {
			if (!visited[i])
				if (cycle(visited, i, currentPathVisited)) {
					return true;
				}
		}
		return false;
	}

	private static boolean cycle(boolean[] visited, int ele, boolean[] currentPathVisited) {
		visited[ele] = true;
		currentPathVisited[ele] = true;
		for (Integer i : adj.getOrDefault(ele, new ArrayList<Integer>())) {
			if (visited[i] == false) {
				if (cycle(visited, i, currentPathVisited)) {
					return true;
				}
			} else if (visited[ele] == true && currentPathVisited[ele] == true) {
				return true;
			}

		}
		currentPathVisited[ele] = false;
		return false;
	}
}
