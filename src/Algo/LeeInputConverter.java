package Algo;

import java.util.Arrays;
//[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
public class LeeInputConverter {
	public static void main(String[] args) {
		String s = "[[1,2,3],[4,5],[1,2,3]]";
		String ans = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[') {
				ans = ans + '{';
			} else if (s.charAt(i) == ']') {
				ans = ans + '}';
			} else {
				ans = ans + s.charAt(i);
			}
		}

		System.out.println(ans);
	}
}
