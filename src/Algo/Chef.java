package Algo;

import java.util.Stack;

public class Chef {
	public static double averageWaitingTime(int[][] customers) {

		Stack<Integer> s = new Stack<>();
		double time = 0;
		for (int[] k : customers) {
			if (s.isEmpty()) {
				s.push(k[0] + k[1]);
				time = time+s.peek() - k[0];
			} else {
                if(s.peek()> k[0])
                {
                	s.push(s.peek() + k[1]);
                	time=time+s.peek()-k[0];
                }
                else
                {
                	s.push(k[0]+k[1]);
                	time+=k[1];
                }
			}
		}
		return time/customers.length;

	}

	public static void main(String[] args) {
		int[][] a = {{5,2},{5,4},{10,3},{20,1}};
		System.out.println(averageWaitingTime(a));
	}
}
