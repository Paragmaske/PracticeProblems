package Algo;

public class LongestCommonSubSequence {
	public static void main(String[] args) {
		String s = "abcdef";
		String t = "cfdhisdsdada";

		lcs(s, t, s.length(), t.length(), 0);
	}

	private static int lcs(String s, String t, int i, int j, int k) {

		if(i==0 || j==0)
		{
			return 0;
		}
		if (s.charAt(i - 1) == t.charAt(j - 1)) {
			return 1+lcs(s, t, i - 1, j - 1, k);
		} else

		{
			return Math.max(lcs(s, t, i - 1, j, k), lcs(s, t, i, j - 1, k));
		}
	}

}
