package Algo;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class KthDistinct {
	public  static String kthDistinct(String[] arr, int k) {
		   Set<String> set=new TreeSet<>();
		   for(String s:arr)
		   {
		    set.add(s);
		   }
		 
		  
		 int count = 0;
		        for (String s : set) {
		            count++;
		            // Check if this is the k-th distinct element
		            if (count == k) {
		                return s;}
		            
		   }
		    return "";
		    }
public static void main(String[] args) {
	kthDistinct(new String[] {"d","b","c","b","c","a"}, 2);
}
}
