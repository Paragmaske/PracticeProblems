package Algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TODAY {
	public static int smallestDistancePair(int[] nums, int k) {
	Queue<Integer> p=new PriorityQueue<>();
		for(int i=0;i<nums.length-1;i++)
			
		{
			for(int j=i+1;j<nums.length;j++)
			{
				if(p.size()<=k)
				{
					p.add(Math.abs(nums[i]-nums[j]));
				}
				else
				{
					if(Math.abs(nums[i]-nums[j])>p.peek())
					{
						
					}
					else
					{
						
					}
				}
			}
		}
		return k;
	    
    }

	public static void main(String[] args) {
		smallestDistancePair(new int[] { 1, 3, 1 }, 1);
	}
}
