package Algo;

public class Spiral {
	private static void printSpriral(int[][] arr) {
		int left = 0 ;
		int right = arr[0].length-1;
		int low= 0 ;
		int high = arr.length-1;
		int direction = 0;
		while(left < arr[0].length && left >=0 && right >=0 && right< arr[0].length	&&		
				low < arr.length && low >=0 && high >=0 && high< arr.length) {
			if(direction ==0) {
				for(int i=left;i<=right;i++)
				{
					System.out.print(arr[left][i]+" ");
				}
				low ++;
			}
			else if(direction == 1) {
				for(int i=low;i<=high;i++)
				{
					System.out.print(arr[i][right]+" ");
				}
				right--;
			}
			else if(direction ==2) {
				for(int i=right;i>=left;i--)
				{
					System.out.print(arr[high][i]+" ");
					
				}
				high--;
			}
			else if(direction==3){
				
				for(int i=high;i>=low;i--)
				{
					System.out.print(arr[i][left]+" ");
					
				}
				left++;
				
			}
			direction = (direction+1)%4;
		}
	}
	public static void main(String[] args) {
		printSpriral(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
	}
}

	
