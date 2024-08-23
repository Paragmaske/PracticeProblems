package Algo;

public class QuickSort {
	public static void main(String[] args) {
		int[] a = { 12, 24, 1, 4, 5, 6 };
		quick(a);
		System.out.println(a);
	}

	private static void quick(int[] a) {
		quickseort(a , 0 , a.length-1);
	}

	private static void quickseort(int[] a, int start, int end) {
		if(start>end) {
			return;
		}
		int pivot = getPivot(a, start, end);
		quickseort(a ,start ,pivot-1);
		quickseort(a,pivot+1,end);
	}

	private static int getPivot(int[] a, int start, int end) {
		int  pivot = a[end];
		int pointer = start;
		
		for(int i = start; i<end;i++) {
			if(pivot> a[i]) {
				swap(a, i , pointer);
				pointer++;
			}
		}
		swap(a , pointer+1, end);
		return pointer+1;
	}

	private static void swap(int[] a, int i, int pointer) {
		int temp = a[i];
		a[i] = a[pointer];
		a[pointer] = temp;
	}
}
