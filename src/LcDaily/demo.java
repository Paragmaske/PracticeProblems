package LcDaily;

import java.util.Scanner;

public class demo {
	public static void main(String[] args) {
		// Arguments will be read by STDIN
		Scanner s = new Scanner(System.in); // do not change this
		String inputLine = s.nextLine(); // do not change this

		// you code will be inside this main method
		// to view the output, just print the string
		boolean flag = true;
		int[] a1 = new int[26];
		String s1 = inputLine.toLowerCase();
		char[] ca = s1.toCharArray();
		for (char c : ca) {
			int pos = c - 'a';
			if (pos >= 0 && pos <= 25) {
				a1[pos]++;
			}

		}
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] < 1) {
				flag = false;
				break;
			}
		}
		if (flag == false) {
			System.out.print("false");
		} else {
			System.out.print("true");
		}
	}
}
