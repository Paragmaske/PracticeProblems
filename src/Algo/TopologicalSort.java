package Algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSort {
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
		topoSort(1, adj, visited, nodes);
	}

	private static void topoSort(int i, Map<Integer, List<Integer>> adj2, boolean[] visited, int nodes) {

		int[] indegree = new int[nodes + 1];

		for (Map.Entry<Integer, List<Integer>> e : adj.entrySet()) {
			for (Integer ele : e.getValue()) {
				indegree[ele] += 1;
			}}

			Queue<Integer> q = new LinkedList<Integer>();
			for (int k = 1; k < indegree.length; k++) {
				if (indegree[k] == 0) {
					q.add(k);
				}
			}
			while (!q.isEmpty()) {
				Integer poll = q.poll();
				System.out.println(poll);
				for (int z : adj.getOrDefault(poll, new ArrayList<Integer>())) {
					indegree[z] -= 1;
					if (indegree[z] == 0) {
						q.add(z);
					}
				}
			}
		}
	

}
