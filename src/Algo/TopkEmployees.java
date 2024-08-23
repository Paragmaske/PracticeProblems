package Algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;
class Pair{
	int a;
	int b;
	public Pair(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
}
public class TopkEmployees {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		int[] ans = new int[a];
		Map<Integer, Integer> hm = new LinkedHashMap<>();

		for (int i = 0; i < ans.length; i++) {
			int ai= sc.nextInt();
			ans[i]=ai;
			hm.put(ai, hm.getOrDefault(ai, 0) + 1);
		
		}

	PriorityQueue<Pair> p=new PriorityQueue<Pair>((k1,k2)->
	{ int cmp = hm.get(k2.b).compareTo(hm.get(k1.b));
    if (cmp == 0) {
        return Integer.compare(k1.b, k2.b); // Compare keys lexicographically
    }
    return cmp;});
	for(Map.Entry<Integer, Integer> en:hm.entrySet())
	{
		p.add(new Pair(en.getKey(), en.getValue()));
	}
	int k=1;
	
	while(k<=b)
	{
		System.out.println(p.poll().a);
		k++;
		
	}
	
		
	}
}
