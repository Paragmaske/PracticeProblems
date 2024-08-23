package Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int neighbour;
	int cost;

	public Node(int neighbour, int cost) {
		super();
		this.neighbour = neighbour;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Node [neighbour=" + neighbour + ", cost=" + cost + "]";
	}

	public int getNeighbour() {
		return neighbour;
	}

	public void setNeighbour(int neighbour) {
		this.neighbour = neighbour;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}

public class DijkstraAlgorithm {
	static Map<Integer, List<Node>> adj = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt();
		int n = sc.nextInt();
		int[][] a = new int[n][3];

		for (int i = 0; i < a.length; i++) {
			a[i][0] = sc.nextInt();
			a[i][1] = sc.nextInt();
			a[i][2] = sc.nextInt();

			List<Node> orDefault = adj.getOrDefault(a[i][0], new ArrayList<Node>());
			List<Node> orDefault1 = adj.getOrDefault(a[i][1], new ArrayList<Node>());
			orDefault.add(new Node(a[i][1], a[i][2]));
			orDefault1.add(new Node(a[i][0], a[i][2]));
			adj.put(a[i][0], orDefault);
			adj.put(a[i][1], orDefault1);
		}

		int[] dist = new int[nodes + 1];
		boolean[] visited = new boolean[nodes + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dijkstras(1, dist, visited);
		System.out.println(dist[6]);
	}

	private static void dijkstras(int i, int[] dist, boolean[] visited) {

		Queue<Node> q = new PriorityQueue<Node>((n1, n2) -> n1.getCost() - n2.getCost());

		q.add(new Node(1, 0));
		while (!q.isEmpty()) {
			Node poll = q.poll();
			if (visited[poll.getNeighbour()]) {
				continue;
			}
			visited[poll.getNeighbour()] = true;
			dist[poll.getNeighbour()] = poll.getCost();

			for (Node n : adj.get(poll.getNeighbour())) {
				q.add(new Node(n.getNeighbour(),poll.getCost()+n.getCost()));
			}

		}

	}
}
