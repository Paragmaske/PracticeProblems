package Algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CycleInUnDirectedGraph {
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
			List<Integer> orDefault1 = adj.getOrDefault(a[i][1], new ArrayList<Integer>());
			orDefault.add(a[i][1]);
			orDefault1.add(a[i][0]);
			adj.put(a[i][0], orDefault);
			adj.put(a[i][1], orDefault1);
		}

		boolean[] visited = new boolean[nodes + 1];

		System.out.println(isCyclePresent(visited));
	}

	private static boolean isCyclePresent(boolean[] visited) {

		for (int i = 1; i < visited.length; i++) {
			if (!visited[i])
				if (cycle(visited, i, -1)) {
					return true;
				}
		}
		return false;
	}

	private static boolean cycle(boolean[] visited, int ele, int parent) {
		visited[ele] = true;
		for (Integer i : adj.get(ele)) {
			if (visited[i] == false) {
				if (cycle(visited, i, ele)) {
					return true;
				}}
			 else if (i != parent) {
				return true;
			}
		

	}
		return false;
}}
