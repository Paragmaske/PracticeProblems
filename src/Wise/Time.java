package Wise;

public class Time {
public static void main(String[] args) {
	long a=System.currentTimeMillis();
	long b=System.currentTimeMillis()-7200000;
	
	System.out.println((((a-b)/1000)/60)/60);
}
}
