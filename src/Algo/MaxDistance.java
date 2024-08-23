package Algo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxDistance {

	public static int maxDistance(List<List<Integer>> arrays) {

		int[] minArray = new int[arrays.size()];
		int[] maxArray = new int[arrays.size()];
		int index = 0;
		for (List<Integer> l : arrays) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

			for (int i : l) {
				if (i < min) {
					min = i;
				}
				if (i > max) {
					max = i;
				}
			}
			minArray[index] = min;
			maxArray[index] = max;
			index++;

		}
		int maxDifference=Integer.MIN_VALUE;
		for(int mi=0;mi<minArray.length;mi++)
		{
			for(int ma=0;ma<minArray.length;ma++)
			{
				if(mi==ma)
				{
					continue;
				}
				maxDifference=Math.max(maxDifference, Math.abs(minArray[mi]-maxArray[ma]));
			}
		}
		return maxDifference;
	}

	public static void main(String[] args) {
		int[][] ar = { { 1,4 }, {0,5} };

		List<List<Integer>> collect = Arrays.stream(ar)
				.map(ia -> Arrays.stream(ia).boxed().collect(Collectors.toList())).collect(Collectors.toList());
		System.out.println(maxDistance1(collect));
	}

	private static int maxDistance1(List<List<Integer>> collect) {
		// for finding min 
		int minArray[] = new int[collect.size()];
		int maxArray[] = new int[collect.size()];
		for(int i = 0 ;i< collect.size();i++) {
			minArray[i] = collect.get(i).get(0);
			maxArray[i] = collect.get(i).get(collect.get(i).size()-1);
		}
		Arrays.sort(minArray);
		Arrays.sort(maxArray);
		return maxArray[maxArray.length-1] - minArray[0];
	}
}
