package Shortest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class AllNodesOfShortestPath {
	static Map<Integer, List<Integer>> adj = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt();
		int edges = sc.nextInt();
		int[][] edge = new int[edges][2];
		for (int i = 0; i < edge.length; i++) {
			edge[i][0] = sc.nextInt();
			edge[i][1] = sc.nextInt();
		}

		for (int i = 1; i <= nodes; i++) {
			adj.put(i, new ArrayList<>());
		}
		for (int[] a11 : edge) {
			List<Integer> a1 = adj.get(a11[0]);
			List<Integer> a2 = adj.get(a11[1]);
			a1.add(a11[1]);
			a2.add(a11[0]);
			adj.put(a11[0], a1);
			adj.put(a11[1], a2);
		}

		boolean[] visited = new boolean[nodes + 1];

		printAllPaths(2, 3);
//		int[] dist = new int[nodes + 1];
//       Arrays.fill(dist, Integer.MIN_VALUE);
//		int[] parent = new int[nodes + 1];
//		int[] bfs = bfs(1, nodes, visited, dist);
//		int shortestPath=(dist[nodes]==Integer.MIN_VALUE)?-1:dist[nodes];
//		if(shortestPath==-1)
//		{
//			System.out.println(-1);
//			System.exit(0);
//		}
//		boolean[] visited1 = new boolean[nodes + 1];
//		int[] dist1 = new int[nodes + 1];
//
//		int[] bfs2 = bfs(nodes, 1, visited1, dist1);
//
//		
//	for(int i=0;i<bfs.length;i++)
//	{
//		if(bfs[i]+bfs2[i]==shortestPath)
//		{
//			System.out.print(i+ " ");
//		}
//	}
	}

	private static void printAllPaths(int i, int j) {
		boolean[] visited = new boolean[4];
		List<Integer> paths = new ArrayList<Integer>();

		printHelper(i, j, visited, paths);
	}

	private static void printHelper(int i, int j, boolean[] visited, List<Integer> paths) {
		if (i == j) {
			System.out.println(paths);
			return;
		}
		visited[i] = true;
		for (int ele : adj.get(i)) {
			if (!visited[ele]) {
				paths.add(i);
				printHelper(i, j, visited, paths);
			}
			paths.remove(i);

		}
	}

	private static int[] bfs(int src, int dest, boolean[] visited, int[] dist) {
		Queue<Integer> q = new LinkedList<>();
		dist[src] = 0;
		q.add(src);
		visited[src] = true;

		while (!q.isEmpty()) {
			Integer poll = q.poll();

			for (int i : adj.get(poll)) {
				if (visited[i] == false) {

					dist[i] = dist[poll] + 1;

					visited[i] = true;
					q.add(i);
				}
			}
		}
		return dist;

	}
}
