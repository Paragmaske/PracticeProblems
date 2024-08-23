package Algo;

import java.util.ArrayList;

public class Ratings {
	public static void main(String[] args) {

		int[] rating = { 2, 5, 3, 4, 1 };
		System.out.println(numTeams(rating));
	}

	static int numTeams(int[] rating) {
		int calTeams = calTeams(rating, 0, new ArrayList<Integer>());
		return calTeams;
	}

	private static int calTeams(int[] rating, int i, ArrayList<Integer> arrayList) {

		if (arrayList.size() == 3) {
			if (((arrayList.get(0) < arrayList.get(1)) && (arrayList.get(1) < arrayList.get(2)))
					|| ((arrayList.get(0) > arrayList.get(1)) && (arrayList.get(1) > arrayList.get(2)))) {
				return 1;
			} else {
				return 0;
			}
		}
		
		if (i >= rating.length) {
			return 0;
		}

		arrayList.add(rating[i]);
		int include = calTeams(rating, i + 1, arrayList);
		arrayList.remove(arrayList.size() - 1); // Remove the added element

		int exclude = calTeams(rating, i + 1, arrayList);
		return include + exclude;
	}
}
