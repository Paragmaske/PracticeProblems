package Algo;

import java.util.List;
import java.util.Stack;

public class FractionAddition {
	public static String fractionAddition(String expression) {
		Stack<String> fractionStack = new Stack<>();
		String s = "";
		for (int i = 0; i < expression.length(); i++) {

			char ch = expression.charAt(i);
			if (i != 0 && (ch == '+' || ch == '-')) {

				fractionStack.push(s);
				fractionStack.push("" + ch);
				s = "";
				continue;
			}
			s = s + ch;
			if (i == expression.length() - 1) {
				fractionStack.push(s);
				break;
			}
		}

		while (!fractionStack.isEmpty() && fractionStack.size()!=1) {
			String exp1 = fractionStack.pop();
			char numerator1 = exp1.charAt(0);
			char denominator1 = exp1.charAt(2);
			String operator = fractionStack.pop();
			String exp2 = fractionStack.pop();
			char numerator2 = exp2.charAt(0);
			char denominator2 = exp2.charAt(2);

			String ans = "";
			int num1 = Character.getNumericValue(-numerator1);
			int den2 = Character.getNumericValue(denominator2);
			int num2 = Character.getNumericValue(numerator2);
			int den1 = Character.getNumericValue(denominator1);
			int ansnum = 0;
			if (operator.equals("+")) {
				ansnum = (num1 * den2) + (den1 * num2);
			}
			if (operator.equals( "-")) {
				ansnum = (num1 * den2) - (den1 * num2);
			}
			int den=1;
			den=den1*den2;
		fractionStack.push(ansnum+"/"+den);

		}
		return expression;

	}

	public static void main(String[] args) {
		fractionAddition("-1/2+1/2+1/3");
		  // List<String> lis=List.of("a","v","p");
	     //   li.stream().map(String::toUpperCase).collect(Collectors.toList());
	}
}
