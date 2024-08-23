package Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> finalAns = new ArrayList<>();
		combine(candidates, target, new ArrayList<>(), 0, finalAns);
		return finalAns;

	}

	private static void combine(int[] candidates, int target, ArrayList<Integer> arrayList, int start,
			List<List<Integer>> finalAns) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			finalAns.add(new ArrayList<>(arrayList)); // Found a valid combination
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1]) {
				continue;
			}

			arrayList.add(candidates[i]);
			combine(candidates, target - candidates[i], arrayList, i + 1, finalAns);
			arrayList.remove(arrayList.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };

		// 1 1 2 5 6 7 10
		int target = 8;
		List<List<Integer>> combinationSum2 = combinationSum2(candidates, target);
		System.out.println(combinationSum2);

	}
}
