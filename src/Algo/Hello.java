package Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Stream;

class Emp11 {
	int salary;
	String name;

	public Emp11(int salary, String name) {
		super();
		this.salary = salary;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp11 [salary=" + salary + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : salary);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Emp11 e = (Emp11) obj;
		if (e.salary == this.salary) {
			return true;
		}
		return false;
	}

}

public class Hello {

	public static List<Integer> luckyNumbers(int[][] matrix) {
		int[] minrows = new int[matrix.length];
		int[] maxcol = new int[matrix[0].length];

		Arrays.fill(minrows, Integer.MAX_VALUE);
		Arrays.fill(maxcol, Integer.MIN_VALUE);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] < minrows[i]) {
					minrows[i] = matrix[i][j];
				}
			}
		}

		for (int j = 0; j < matrix[0].length; j++) {
			for (int k = 0; k <matrix.length; k++) {

				if (matrix[k][j] > maxcol[j]) {
					maxcol[j] = matrix[k][j];
				}
			}
		}
		List<Integer> ans = new ArrayList<Integer>();
		for (int x = 0; x < minrows.length; x++) {
			for (int y = 0; y < maxcol.length; y++) {
				if (matrix[x][y] == minrows[x] && matrix[x][y] == maxcol[y]) {
					ans.add(matrix[x][y]);
				}
			}
		}
		return ans;

	}

public static void main(String[] args) {
//		Map<String, Integer> mp = new HashMap<>();
//
//		mp.put("a", 7);
//		mp.put("c", 1);
//		mp.put("d", 2);
//		mp.put("g", 12);
//		TreeMap<String, Integer> tm = new TreeMap<>((x, y) -> mp.get(x) - mp.get(y));
//
//		;
//		tm.putAll(mp);
//		for (Map.Entry<String, Integer> TM : tm.entrySet()) {
//			System.out.println(TM.getValue());
//		}
//		int sum = tm.values().stream().filter(a -> a % 2 == 0).mapToInt(a -> a).sum();
//		System.out.println(sum);
//
//		Emp11 e1 = new Emp11(500, "a");
//		Emp11 e2 = new Emp11(300, "b");
//		Emp11 e3 = new Emp11(1000, "c");
//		Emp11 e4 = new Emp11(1500, "d");
//		Emp11 e6 = new Emp11(1500, "z");
//		Emp11 e5 = new Emp11(10, "e");
//		List<Emp11> emp = new ArrayList<Emp11>();
//		emp.add(e1);
//		emp.add(e2);
//		emp.add(e3);
//		emp.add(e4);
//		emp.add(e5);
//		emp.add(e6);
//		Optional<Emp11> findFirst = emp.stream().distinct().sorted((a, b) -> b.salary - a.salary).skip(1).findFirst();
//		System.out.println(findFirst.get());
//	
	
	int[][] a={{3,7,8},{9,11,13},{15,16,17}};
	luckyNumbers(a);
}}
