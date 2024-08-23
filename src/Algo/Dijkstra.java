package Algo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Neigh {
	int weight;
	int neighbour;

	public Neigh(int weight, int neighbour) {
		this.weight = weight;
		this.neighbour = neighbour;
	}

	@Override
	public String toString() {
		return "Node [weight=" + weight + ", neighbour=" + neighbour + "]";
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getNeighbour() {
		return neighbour;
	}

	public void setNeighbour(int neighbour) {
		this.neighbour = neighbour;
	}

}

public class Dijkstra {

	public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
		Map<Integer, List<Neigh>> hm = new HashMap<>();

		for (int[] i : edges) {
			List<Neigh> first = new ArrayList<Neigh>();
			List<Neigh> second = new ArrayList<Neigh>();
			Neigh n1 = new Neigh(i[2], i[1]);
			Neigh n2 = new Neigh(i[2], i[0]);
			first.add(n1);
			second.add(n2);
			hm.put(i[0], first);
			hm.put(i[1], second);
		}

		for (int i = 0; i < n; i++) {
			int[] distFromAllVertices = calDistance(i, hm, new int[n], new boolean[n]);
		}
		return distanceThreshold;

	}

	private static int[] calDistance(int i, Map<Integer, List<Neigh>> hm, int[] dist, boolean[] visited) {
Comparator<Neigh> comp= Comparator.comparingInt(Neigh::getWeight);
		PriorityQueue<Neigh> pq = new PriorityQueue<Neigh>(comp);
		pq.add(new Neigh(0, 0));

		while (!pq.isEmpty()) {
			Neigh poll = pq.poll();
			if(visited[poll.neighbour]==true) continue;
			visited[poll.neighbour]=true;
			for(Neigh n:hm.get(poll.neighbour))
			{
				if(visited[n.neighbour]==true) continue;
				visited[n.neighbour]=true;
				dist[n.neighbour]=dist[poll.weight]+n.weight;
				pq.add(new Neigh(dist[n.neighbour], n.neighbour));
				
			}
		}
			return null;

	}

	public static void main(String[] args) {
		int noOfEdges = 4;
		int[][] edges = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
		int distanceThreshold = 4;
		findTheCity(noOfEdges, edges, distanceThreshold);
	}
}
