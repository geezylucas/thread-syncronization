class MyThread implements Runnable {

    int total;

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            total = total + i;
            if (total > 10000) {
                synchronized (this) {
                    notify();
                }
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("User Thread total: " + total);
    }
}

public class InnerThreadDemo {

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread t = new Thread(mt);
        t.start();
        try {
            synchronized (mt) {
                System.out.println("Waiting in main...");
                mt.wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main Thread total:" + mt.total);
    }
}