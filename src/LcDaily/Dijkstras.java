package LcDaily;

public class Dijkstras {
	public static void main(String[] args) {
		int graph[][] = new int[][] { { -1, 3, -1, -1, -1, -1, -1, 7, -1 }, { 3, -1, 7, -1, -1, -1, -1, 10, 4 },
				{ -1, 7, -1, 6, -1, 2, -1, -1, 1 }, { -1, -1, 6, -1, 8, 13, -1, -1, 3 },
				{ -1, -1, -1, 8, -1, 9, -1, -1, -1 }, { -1, -1, 2, 13, 9, -1, 4, -1, 5 },
				{ -1, -1, -1, -1, -1, 4, -1, 2, 5 }, { 7, 10, -1, -1, -1, -1, 2, -1, 6 },
				{ -1, 4, 1, 3, -1, 5, 5, 6, -1 } };
	
	dijk(graph);
}

	private static void dijk(int[][] graph) {
		int rows=graph.length;
		int col=graph[0].length;
		boolean[][] visited=new boolean[rows][col];
	}}
