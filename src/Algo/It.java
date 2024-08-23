package Algo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class It {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);

		Iterator<Integer> it = l.iterator();

		while (it.hasNext()) {
			Integer next = it.next();
			if (next % 2 == 0) {
				it.remove();
			}
		}
		System.out.println(l);
	}
}
