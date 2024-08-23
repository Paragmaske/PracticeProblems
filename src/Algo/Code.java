package Algo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Code {
	public static int[] frequencySort(int[] nums) {
		Map<Integer, Integer> hm = new HashMap<>();

		for (int i : nums) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}

		Map<Integer, Integer> tm = new TreeMap<>((a, b) -> {
			int res = hm.get(a) - hm.get(b);
			if (res == 0) {
				res = hm.get(b) - hm.get(a);
			}
		
			return res;
		});
		tm.putAll(hm);

		int[] ans = new int[nums.length];
		int k = 0;
		for (Map.Entry<Integer, Integer> en : tm.entrySet()) {

			for (int z = 0; z < en.getValue(); z++) {
				ans[k] = en.getKey();
				k++;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
int[] a= {2,3,1,3,2};
frequencySort(a);
	}

}
