package Wise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Mobile {
	public static int minimumPushes(String word) {
		Map<String, Integer> hm1 = new HashMap<>();
		for (char c : word.toCharArray()) {
			hm1.put(String.valueOf(c), hm1.getOrDefault(String.valueOf(c), 0) + 1);
		}
		Map<String, Integer> tm = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				int compare = Integer.compare(hm1.get(arg1), hm1.get(arg0));
				if (compare == 0) {
					return arg0.compareTo(arg1);
				}
				return compare;
			}
		});
		tm.putAll(hm1);

		int counter  = 0;
		int total = 0;
		for (Map.Entry<String, Integer> map : tm.entrySet()) {
			int press= counter/8+1;
			total = total + press* map.getValue();
			counter++;
		}
		return total;
	}

	public static void main(String[] args) {
		minimumPushes("aabbccddeeffgghhiiiiii");
	}
}