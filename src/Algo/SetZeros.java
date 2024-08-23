package Algo;

public class SetZeros {
	public static void setZeroes(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				boolean flag=false;
				if (matrix[i][j] == 0 && matrix[i][0]!=0 && matrix[0][j]!=0){
					flag=true;
					for (int k = 0; k < matrix[0].length; k++) {
						matrix[i][k] = 0;
					}
					for (int l = 0; l < matrix.length; l++) {
						matrix[l][j] = 0;
					}

				}
				if(flag==true) break;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		setZeroes(new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}});
	}
}
