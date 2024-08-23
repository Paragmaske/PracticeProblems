package Algo;

import java.util.Stack;

public class LogsCrawler {
	 public static int minOperations1(String[] logs) {
		    
			Stack<String> s = new Stack<String>();
			for (int i=0;i<logs.length;i++) {
				if (s.isEmpty() && logs[i] == "../") {
					continue;
				}  else if (!s.isEmpty() && logs[i]== "../") {
					s.pop();
				}
				else if (logs[i]=="./")
				{
					continue;
				}
				else
				{
					s.push(logs[i]);
				}
			}
			return s.size();


		   
	    }
	public static void main(String[] args) {
		String[] ans = {"d1/","../","../","../"};
		System.out.println(minOperations(ans));
	}
	private static int minOperations(String[] ans) {
		Stack<String> s=new Stack<String>();
		for(String ele:ans)
		{
			switch(ele) {
			case "../":
				if(s.isEmpty()) 
				{
					break;
				}
				else {
					s.pop();
				}
				break;
				
			case "./":
				break;
			default:
				s.add(ele);
			}
		}
		return s.size();
	}
}
