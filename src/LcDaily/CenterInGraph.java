package LcDaily;

import java.util.HashMap;
import java.util.Map;

public class CenterInGraph {
	public static void main(String[] args) {
		int[][] a = { { 1, 2 }, { 2, 3 }, { 4, 2 } };
		System.out.println(findCenter(a));
	}

	public static int findCenter(int[][] edges) {

		Map<Integer, Integer> hm = new HashMap<>();

		for (int[] i : edges) {
			hm.put(i[0], hm.getOrDefault(i[0], 0) + 1);
			hm.put(i[1], hm.getOrDefault(i[1], 0) + 1);
		}
		for (Map.Entry<Integer, Integer> h : hm.entrySet()) {
			if (h.getValue() > 1) {
				return h.getKey();
			}
		}
		return -1;

	}
}
