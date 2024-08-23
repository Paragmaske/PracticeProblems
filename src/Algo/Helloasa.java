package Algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Helloasa {
	public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
		// east south west north
		int[][] coor = { { 0, 1 }, { 0, -1 }, { 0, -1 }, { -1, 0 } };

		int steps = 0;
		int dir = 0;
		int[][] ans = new int[rows][cols];
		while (ans.length < rows * cols) {
			if (dir == 0 || dir == 2) {
				steps++;
			}
			for (int count = 0; count < steps; count++) {
				rStart += coor[dir][0];
				cStart += coor[dir][1];

				if (rStart >= 0 && rStart < cols && cStart >= 0 && cStart < rows) {
					ans[count][0] = rStart;
					ans[count][0] = cStart;
				}
			}
			dir = (dir + 1) % 4;
		}

		return ans;
	}

	public static void main(String[] args) {
//	rows = 1, cols = 4, rStart = 0, cStart = 0
		spiralMatrixIII(1, 4, 0, 0);
	}

}
