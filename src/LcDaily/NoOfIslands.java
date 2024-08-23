package LcDaily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {
	static int[] x = { 1, -1, 0, 0 };
	static int[] y = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		char[][] island = { { '1', '1', '1', '1', '0' },
							{ '1', '1', '0', '1', '0' }, 
							{ '1', '1', '0', '0', '0' },
							{ '0', '0', '0', '0', '0' } };
		System.out.println(numIslands(island));
	}

	public static int numIslands(char[][] grid) {

		int rows = grid.length;
		int cols = grid[0].length;

		boolean[][] visited = new boolean[rows][cols];
		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (visited[i][j] == false && grid[i][j] == '1') {
					bfs(i, j, grid, visited);
					count++;
				}
			}
		}
		return count;

	}

	private static void bfs(int i, int j, char[][] grid, boolean[][] visited) {

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { i, j });
		visited[i][j] = true;

		while (!q.isEmpty()) {
			int[] poll = q.poll();
			for (int k = 0; k < x.length; k++) {
				if (check(poll[0]+x[k],poll[1]+y[k], grid, visited)) {
					q.add(new int[] { poll[0]+x[k], poll[1]+y[k] });
					visited[poll[0]+x[k]][poll[1]+y[k]] = true;
				}
			}
		}
	}

	private static boolean check(int i, int j, char[][] grid, boolean[][] visited) {

		if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && visited[i][j] == false && grid[i][j] == '1') {
			return true;
		}
		return false;

	}
}
