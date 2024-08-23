package Algo;

public class ReplaceStringBuilder {
public static void main(String[] args) {
	String a="abc";
	StringBuilder s=new StringBuilder(a);
	int indexOf = s.indexOf("b");
	s.delete(indexOf, indexOf+1);
	s.insert(indexOf, "d");
	System.out.println(s.toString());
	int a11=Integer.valueOf(s.toString());
	int num=2;
	System.out.println(String.valueOf(num));
	char c=8;
	int a1=c;
	System.out.println(String.valueOf(a1));
}
}
