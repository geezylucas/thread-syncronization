public class ThreadExample extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Count: " + i + " thread: " + Thread.currentThread().getName());
        }
    }
}