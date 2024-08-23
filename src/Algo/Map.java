package Algo;

import java.util.NavigableMap;

public class Map {
	public static void main(String[] args) {
		String[] a = { "7868190130M7522", "5303914400F9211", "9273338290F4010" };
		System.out.println(countSeniors(a));
	}

	public static int countSeniors(String[] details) {
		int ans = 0;
		for (int i = 0; i < details.length; i++) {

			int age = Character.getNumericValue(details[i].charAt(11))*10
					+ Character.getNumericValue(details[i].charAt(12));
			if (age > 60) {
				ans++;
			}
		}
		return ans;

	}
}
