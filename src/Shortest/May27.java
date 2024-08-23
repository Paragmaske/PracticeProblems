package Shortest;

public class May27 {
	public static int specialArray(int[] a) {

		int maxSum=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>=maxSum)
			{
				maxSum=a[i];
			}
		}
		for (int i = 0; i <=maxSum; i++) {
			int count = i;
			int no = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[j] >= i) {
					no++;
				}
			}
			if (no == count)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(specialArray(new int[] { 3, 5 }));
	}
}
