package Deadlock;

class Producer implements Runnable {

	private ProducerConsumerExample pc;

	public Producer(ProducerConsumerExample pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			pc.produce(i);
		}
	}

}

class Consumer implements Runnable {

	private ProducerConsumerExample pc;

	public Consumer(ProducerConsumerExample pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			pc.consume();
		}
	}

}

public class ProducerConsumerExample {

	private int[] array;
	int pointer;

	public ProducerConsumerExample(int size) {
		this.pointer = 0;
		array = new int[size];
	}

	public synchronized void produce(int i) {
		while (pointer == array.length) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		array[pointer++] = i;
		System.out.println("produced by " + Thread.currentThread().getName() + " value " + i);
		notifyAll();

	}

	public synchronized void consume() {
		while (pointer == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int value = array[--pointer];
		System.out.println("consumed by " + Thread.currentThread().getName() + " " + value);
		notifyAll();

	}

	public static void main(String[] args) {
		ProducerConsumerExample ex = new ProducerConsumerExample(4);
		Thread t1 = new Thread(new Producer(ex));
		Thread t2 = new Thread(new Consumer(ex));
		Thread t3 = new Thread(new Consumer(ex));
		t2.start();
		t1.start();
		t3.start();
		

	}
}