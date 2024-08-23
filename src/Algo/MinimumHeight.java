package Algo;

public class MinimumHeight {
	public static void main(String[] args) {
		int[][] books = { { 1, 1 }, { 2, 3 }, { 2, 3 }, { 1, 1 }, { 1, 1 }, { 1, 1 }, { 1, 2 } };
		int shelfWidth = 4;
		minHeightShelves(books, shelfWidth);
	}

	public static int minHeightShelves(int[][] books, int shelfWidth) {

		solve(0, shelfWidth, books, 0, shelfWidth);
		return 0;
	}

	private static int solve(int i, int remainingWidth, int[][] books, int maxHeight, int originalShelfWidth) {
		if (i >= books.length)

		{
			return maxHeight;
		}
		int width = books[i][0];
		int height = books[i][1];
		return height;

	}
}
