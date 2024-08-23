package Algo;

import java.util.Stack;

public class Pairs {
	private static String reverseParentheses(String s) {
		Stack<String> stac = new Stack<>();
		int i = 0;
		
		while (i < s.length()) {     
			String valueOf = String.valueOf(s.charAt(i));

			if (valueOf.equals("(")) {
				stac.push(String.valueOf(s.charAt(i)));
			} else if (valueOf.equals(")")) {
				String ans="";
				while(!stac.peek().equals("("))
				{
					String pop = stac.pop();
					for(int z=pop.length()-1;z>=0;z--)
					{
						ans=ans+pop.charAt(z);
					}
					
				}
				stac.pop();
				stac.push(ans);
			} else {
				String ans = "";
				for (int k = i; k < s.length(); k++) {
					String valueOfii = String.valueOf(s.charAt(k));
				
					if (valueOfii.equals("(") ||valueOfii.equals(")")  ) {
						stac.push(ans);
						i=k-1;
						break;
					}
					ans = ans+s.charAt(k)  ;
					if(k==s.length()-1)
					{
						i=s.length()-1;
						stac.push(ans);
						break;
					}
				}
			}
			i++;
		}
		String  fans="";
	while(!stac.isEmpty())
	{
		fans=stac.pop()+fans;
	}
	return fans;

	}

	public static void main(String[] args) {
		System.out.println(reverseParentheses("yfgnxf"));
	}
}
