package Chess;

class ResourceClass {
    private int[] array;
    private int size;
    private int capacity;

    ResourceClass(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public synchronized void produceData(int data) throws InterruptedException {

            while (size == capacity) {
                System.out.println("waiting for the consumer");
                wait();
            }
            array[size] = data;
            size++;
            System.out.println("Data produced: " + data + " --> Thread: " + Thread.currentThread().getName());
            notify();
            Thread.sleep(100); // Sleep added to make output readable

    }

    public synchronized void consumeData() throws InterruptedException {

            while (size == 0) {
                System.out.println("waiting for producer");
                wait();
            }
            size--;
            int data = array[size];
            array[size] = 0;
            System.out.println("Data consumed: " + data + " --> Thread: " + Thread.currentThread().getName());
            notify();
            Thread.sleep(100); // Sleep added to make output readable

    }
}

public class ProducerConsumerProblem {

    public static void main(String[] args) {
        ResourceClass resource = new ResourceClass(10);

        Runnable produceTask = () -> {
            for (int i = 0; i < 25; i++) {
                try {
                    resource.produceData(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable consumeTask = () -> {
            for (int i = 0; i < 25; i++) {
                try {
                    resource.consumeData();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread producerThread = new Thread(produceTask, "Producer");
        Thread consumerThread = new Thread(consumeTask, "Consumer");
        consumerThread.start();
        producerThread.start();
    }
}