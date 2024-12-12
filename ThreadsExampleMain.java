public class ThreadsExampleMain {

    public static void main(String[] args) throws InterruptedException {
        //ThreadExample threadExample = new ThreadExample();
        // start thread
        //threadExample.start();

        RunnableExample runnableExample = new RunnableExample();
        Thread threadRunnable = new Thread(runnableExample);

        Thread threadAnonymous = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Count: " + i + " thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        System.out.println("threadRunnable: " + threadRunnable.getState());
        System.out.println("threadAnonymous: " + threadAnonymous.getState());

        threadRunnable.start();

        System.out.println("threadRunnable: " + threadRunnable.getState());
        System.out.println("threadAnonymous: " + threadAnonymous.getState());

        threadAnonymous.start();

        System.out.println("threadRunnable: " + threadRunnable.getState());
        System.out.println("threadAnonymous: " + threadAnonymous.getState());

        threadRunnable.join();

        System.out.println("threadRunnable: " + threadRunnable.getState());
        System.out.println("threadAnonymous: " + threadAnonymous.getState());


        /*
         * Si llamamos al método threadRunnable.join() dentro de main, pondrá a main en un estado de espera hasta que threadRunnable haya terminado la ejecución.
         * Llamar al método estático Thread.sleep(long timeInMilliSeconds) pondrá el hilo actual en un estado de espera cronometrada. 
         */
    }
}
