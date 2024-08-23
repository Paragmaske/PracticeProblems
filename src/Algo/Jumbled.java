package Algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Jumbled {
	public static int[] sortJumbled(int[] mapping, int[] nums) {
		Map<String, String> hm = new HashMap<>();
		int[] ans = new int[nums.length];
		for (int i = 0; i < mapping.length; i++) {
			hm.put(String.valueOf(i), String.valueOf(mapping[i]));
		}
		Map<Integer, Integer> hm2 = new LinkedHashMap<>();
		int index=0;
		for (int j : nums) {
			String s = String.valueOf(j);
			StringBuilder s1 = new StringBuilder(s);
			String ans1 = "";

			for (int k = 0; k < s1.length(); k++) {
				char c = s1.charAt(k);
				String z = Character.toString(c);
				String ex = hm.get(z);
				ans1 = ans1 + ex;

			}
			hm2.put(index++, Integer.valueOf(ans1));
		}

		Map<Integer, Integer> tm = new TreeMap<>((a, b) -> {

			int res = hm2.get(a) - hm2.get(b);

			if (res == 0) {
				return a.compareTo(b);
			}
			return res;
		});
		tm.putAll(hm2);
		int p = 0;
		for (Map.Entry<Integer, Integer> en : tm.entrySet()) {
			ans[p++] = nums[en.getKey()];
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] mapping = { 8, 9, 4, 0, 2, 1, 3, 5, 7, 6 };
		int[] nums = { 991, 338, 38 };
		sortJumbled(mapping, nums);
	}
}
