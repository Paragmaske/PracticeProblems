package Algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest {
	int k;
	PriorityQueue<Integer> pq;

	public void KthLargest(int k, int[] nums) {
		this.k = k;
		this.pq = new PriorityQueue<>();
		for (int i : nums) {
			if(pq.size()<k)
			{
				pq.add(i);
			}
			else
			{
				if(i>pq.peek())
				{
					pq.poll();
					pq.add(i);
				}
			}
		}
	}

	public int add(int val) {
		
		if(pq.size()<k)
		{
			pq.add(val);
		}else {
			if(!pq.isEmpty() &&val>pq.peek()  )
			{
				pq.poll();
				pq.add(val);
			}
		}
		return (!pq.isEmpty())?pq.peek():-1;
	}

	public static void main(String[] args) {
//				["KthLargest", "add", "add", "add", "add", "add"]
//				[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
		KthLargest k=new KthLargest();
		k.KthLargest(1, new int[] {});
		k.add(-3);
		k.add(-2);
		k.add(-4);
		k.add(0);
		k.add(4);
	}
}
