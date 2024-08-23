package Wise;

public class TwoT {
public  void m1()
{
	synchronized (TwoT.class) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m1 this side "+Thread.currentThread().getName());
	}
	
}
	public static void main(String[] args) {

		TwoT o1=new TwoT();
		TwoT o2=new TwoT();

		Thread t1=new Thread(()->{o1.m1();});
		Thread t2=new Thread(()->{o2.m1();});
		t1.start();
		t2.start();
		
}
}
