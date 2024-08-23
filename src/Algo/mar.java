package Algo;

import java.util.HashSet;

public class mar {

	public static boolean checAllsum(int[][] innerGrid) {
		int sum = innerGrid[0][0] + innerGrid[0][1] + innerGrid[0][2];
		for (int i = 0; i < innerGrid.length; i++) {
			int sumrow = 0;
			int sumcol = 0;
			for (int j = 0; j < innerGrid[i].length; j++) {
				sumrow = sumrow + innerGrid[i][j];
				sumcol = sumcol + innerGrid[j][i];
			}

			if (sum != sumrow || sum != sumcol) {
				return false;
			}
		}
		int diagonalSum = 0 ;
		int diagonalSum2 = 0 ;
		for(int i = 0 ;i< innerGrid.length;i++) {
			diagonalSum+= innerGrid[i][i];
			diagonalSum2+= innerGrid[i][innerGrid.length-i-1];
		}
		if (sum != diagonalSum || sum != diagonalSum2) {
			return false;
		}
		return true;
	}

	public static int numMagicSquaresInside(int[][] grid) {
		int answer = 0;
		int row = grid.length - 3;
		int column = grid[0].length - 3;

		for (int l = 0; l <= row; l++) {
			for (int m = 0; m <= column; m++) {
				int[][] innerCol = new int[3][3];
				HashSet<Integer> hset  = new  HashSet<Integer>();
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						innerCol[i][j] = grid[l + i][m + j];
						if(innerCol[i][j]<=9) {
							hset.add(innerCol[i][j] );
						}
					}
				}
				if (hset.size()==9 && checAllsum(innerCol)) {
					answer++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		numMagicSquaresInside(new int[][] { { 4, 3, 8, 4 }, { 9, 5, 1, 9 }, { 2, 7, 6, 2 } });
	}
}
