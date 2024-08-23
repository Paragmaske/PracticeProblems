package Algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Remove {
	public static int maximumGain(String s, int x, int y) {
//ab ba
		int ans = 0;
		Stack<Character> sta = new Stack<>();
		if (x > y) {

			for (int i = 0; i < s.length(); i++) {
				if (!sta.isEmpty() && sta.peek() == 'a' && s.charAt(i) == 'b') {
					sta.pop();
					ans = ans + x;
				} else {
					sta.add(s.charAt(i));
				}
			}

			String middle = "";
			while (!sta.isEmpty()) {
				middle = sta.pop() + middle;
			}
			// System.out.println(middle);

			for (int i = 0; i < middle.length(); i++) {
				if (!sta.isEmpty() && sta.peek() == 'b' && middle.charAt(i) == 'a') {
					sta.pop();
					ans = ans + y;
				} else {
					sta.add(middle.charAt(i));
				}
			}
		

		} else {

			for (int i = 0; i < s.length(); i++) {
				if (!sta.isEmpty() && sta.peek() == 'b' && s.charAt(i) == 'a') {
					sta.pop();
					ans = ans + y;
				} else {
					sta.add(s.charAt(i));
				}
			}

			String middle = "";
			while (!sta.isEmpty()) {
				middle = sta.pop() + middle;
			}
			// System.out.println(middle);

			for (int i = 0; i < middle.length(); i++) {
				if (!sta.isEmpty() && sta.peek() == 'a' && middle.charAt(i) == 'b') {
					sta.pop();
					ans = ans + x;
				} else {
					sta.add(middle.charAt(i));
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {

		String s = "aabbaaxybbaabb";
		System.out.println(maximumGain(s, 5, 4));
		// maximumGain1(s, 4, 5);

	}

	private static int maximumGain1(String s, int i, int j) {
		StringBuilder s1 = new StringBuilder(s);
		int sum = 0;
		if (j > i) {
			while (s1.indexOf("ba") >= 0) {
				s1 = s1.delete(s1.indexOf("ba"), s1.indexOf("ba") + 2);
				sum = sum + j;
			}
			while (s1.indexOf("ab") >= 0) {
				s1 = s1.delete(s1.indexOf("ab"), s1.indexOf("ab") + 2);
				sum = sum + i;
			}
		}

		else {

			while (s1.indexOf("ab") >= 0) {
				s1 = s1.delete(s1.indexOf("ab"), s1.indexOf("ab") + 2);
				sum = sum + j;
			}
			while (s1.indexOf("ba") >= 0) {
				s1 = s1.delete(s1.indexOf("ba"), s1.indexOf("ba") + 2);
				sum = sum + i;
			}
		}
		return sum;
	}
}
