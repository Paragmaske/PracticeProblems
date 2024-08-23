//package Algo;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class MakeAs {
//	public static void main(String[] args) {
//		System.out.println(minSteps(3));
//	}
//
//	public static int minSteps(int n) {
//		int[] dp=new int[n];
//		dp[0]=0;
//		dp[1]=1;
//		if(n==0 || n==1)
//		{
//			return n;
//		}
//		ArrayList<Integer> arrayList = new ArrayList<Integer>();
//		makeAs("A", n, 1, "A",arrayList,dp);
//		Collections.sort(arrayList);
//		return arrayList.get(0);
//	}
//
//	private static void makeAs(String currentStr, int toMake, int steps, String copied, List<Integer> arrayList) {
//
//
//		
//		if (currentStr.length() == toMake) {
//			arrayList.add(steps);
//			return;
//		}
//		if (currentStr.length() > toMake) {
//			return;
//		}
//		if(copied.length()>toMake || steps>toMake)
//		{
//			return;
//		}
//		makeAs(currentStr, toMake, steps + 1, currentStr, arrayList);
//		makeAs(currentStr + copied, toMake, steps + 1, copied, arrayList);
//
//	}}
//
//
//}
