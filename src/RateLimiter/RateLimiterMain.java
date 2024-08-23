package RateLimiter;

public class RateLimiterMain {
	public static void main(String[] args) {

		Thread t = new Thread(() -> {
			RateLimiter rate = new RateLimiter();
			int k = 10;
			while (k >= 0) {
				System.out
						.println(rate.hitEndPoint(1) + " customerid " + 1 + " for time " + System.currentTimeMillis());
				k--;
			}
			try {
				Thread.sleep(10000);
				System.out.println("wake  up ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			k = 10;
			while (k >= 0) {
				System.out
						.println(rate.hitEndPoint(1) + " customerid " + 1 + " for time " + System.currentTimeMillis());
				k--;
			}
		});
		
		t.start();
	}
}
