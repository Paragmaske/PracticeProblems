package Shortest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CycleInGraph {
	static Map<Integer, List<Integer>> hm = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt();
		for (int i = 1; i <= nodes; i++) {
			hm.put(i, new ArrayList<Integer>());
		}
		int edges = sc.nextInt();

		for (int i = 0; i < edges; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			hm.computeIfPresent(a, (key, value) -> {
				value.add(b);
				return value;
			});
			hm.computeIfPresent(b, (key, value) -> {
				value.add(a);
				return value;
			});
		}
		boolean[] visited = new boolean[nodes + 1];
		System.out.println(dfs(hm, 1, -1, visited));
	}

	private static boolean dfs(Map<Integer, List<Integer>> adjList, int start, int parent, boolean[] visited) {

		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false) {
				if (checkCycle(adjList, i, -1, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean checkCycle(Map<Integer, List<Integer>> adjList, int i, int j, boolean[] visited) {
		visited[i] = true;

		for (int nei : adjList.get(i)) {
			if (!visited[nei]) {
				if (checkCycle(adjList, nei, i, visited)) {
					return true;
				}
			} else if (j == i) {
				return true;
			}
		}
		return false;
	}
}
