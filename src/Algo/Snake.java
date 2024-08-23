package Algo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Snake {
	public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
		int i = 1;
		int ans = 0;
		int maxCanReach = 0;
		while (i != 100) {
			int proans = 0;
			for (int k = i + 1; k <= i + 6; k++) {
				if (isSnakeOrLadder(i, snakes)) {
					continue;
				} else if (isSnakeOrLadder(k, ladders)) {
					if (getmaxpos(k, ladders) > maxCanReach) {
						maxCanReach = getmaxpos(k, ladders);
						proans = k;
					}
				} else {
					if (k > maxCanReach) {
						proans = k;
						maxCanReach = k;
						if (k == 100) {
							break;
						}
					}
				}
			}
			
			i = maxCanReach;
			ans++;
		}
		return ans;
	}

	static boolean isSnakeOrLadder(int i, List<List<Integer>> snakes) {
		for (List<Integer> l : snakes) {
			if (l.get(0) == i) {
				return true;
			}
		}
		return false;
	}

	static int getmaxpos(int i, List<List<Integer>> snakes) {
		for (List<Integer> l : snakes) {
			if (l.get(0) == i) {
				return l.get(1);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		List<List<Integer>> pairsList = new ArrayList<>();

		pairsList.add(Arrays.asList(8, 52));
		pairsList.add(Arrays.asList(6, 80));
		pairsList.add(Arrays.asList(26, 42));
		pairsList.add(Arrays.asList(2, 72));
		List<List<Integer>> pairList = new ArrayList<>();
		pairList.add(Arrays.asList(51, 19));
		pairList.add(Arrays.asList(39,11));
		pairList.add(Arrays.asList(37, 29));
		pairList.add(Arrays.asList(81, 3));
		pairList.add(Arrays.asList(59, 5));
		pairList.add(Arrays.asList(79, 23));
		pairList.add(Arrays.asList(53,7));
		pairList.add(Arrays.asList(43,33));
		pairList.add(Arrays.asList(77,21));
		System.out.println(quickestWayUp(pairsList, pairList));
	}
}