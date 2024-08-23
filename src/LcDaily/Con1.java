package LcDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Node1 {
	int neighbour;
	int cost;

	public Node1(int neighbour, int cost) {
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

public class Con1 {
	static Map<Integer, List<Node1>> adj = new HashMap<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int Node1s = sc.nextInt();
		int edges = sc.nextInt();
		int arg = sc.nextInt();
		int startIndex = sc.nextInt();

		for (int i = 0; i < edges; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			int weight = sc.nextInt();

			List<Node1> orDefault = adj.getOrDefault(first, new ArrayList<Node1>());
			List<Node1> orDefault1 = adj.getOrDefault(second, new ArrayList<Node1>());
			orDefault.add(new Node1(second, weight));
			orDefault1.add(new Node1(first, weight));
			adj.put(first, orDefault);
			adj.put(second, orDefault1);
		}

		int[] ar = new int[arg];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = sc.nextInt();
		}
		int[] dist = new int[Node1s + 1];
		boolean[] visited = new boolean[Node1s + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dijkstras(startIndex, dist, visited);
		for (int i : ar) {
			System.out.println(dist[i]);
		}
	}

	private static void dijkstras(int i, int[] dist, boolean[] visited) {

		Queue<Node1> q = new PriorityQueue<Node1>((n1, n2) -> n1.getCost() - n2.getCost());

		q.add(new Node1(i, 0));
		while (!q.isEmpty()) {
			Node1 poll = q.poll();
			if (visited[poll.getNeighbour()]) {
				continue;
			}
			visited[poll.getNeighbour()] = true;
			dist[poll.getNeighbour()] = poll.getCost();

			for (Node1 n : adj.get(poll.getNeighbour())) {
				q.add(new Node1(n.getNeighbour(), poll.getCost() + n.getCost()));
			}

		}

	}
}
