package LcDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Star {

	  public static long maximumImportance(int n, int[][] edges) {

		Map<Integer, List<Integer>> adjList = new HashMap<>();

		for (int i = 0; i < edges.length; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			if (adjList.containsKey(a)) {
				List<Integer> lista = adjList.get(a);
				lista.add(b);
				adjList.put(a, lista);
			} else {
				List<Integer> l = new ArrayList<Integer>();
				l.add(b);
				adjList.put(a, l);
			}
			if (adjList.containsKey(b)) {
				List<Integer> listb = adjList.get(b);
				listb.add(a);
				adjList.put(b, listb);
			} else {
				List<Integer> l = new ArrayList<Integer>();
				l.add(a);
				adjList.put(b, l);

			}
		}

		TreeMap<Integer, List<Integer>> tm = new TreeMap<Integer, List<Integer>>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				 int sizeComparison = Integer.compare(adjList.get(o1).size(), adjList.get(o2).size());
				  if (sizeComparison != 0) {
	                    return sizeComparison;
	                } else {
	                    return Integer.compare(o1, o2);
	                }
			}
		});
		tm.putAll(adjList);
		int[] dist=new int[n+1];
		int count=1;
		for(Map.Entry<Integer, List<Integer>> T:tm.entrySet())
			
		{
			dist[T.getKey()]=count++;;
		}
		int sum=0;
		for (int i = 0; i < edges.length; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			sum+=dist[a]+dist[b];
		}
		if(tm.size()==n)
		{
		return sum;
	
		}
		return (n-tm.size())*sum;
		}

	public static void main(String[] args) {
		System.out.println(maximumImportance(5,new int[][] { { 0, 1 }}));
	}

}
