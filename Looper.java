public class Looper {

    // a thread-safe shared flag
    private volatile int counter = 0;

    Object lock = new Object();

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        final Looper looper = new Looper();

        Runnable task = () -> {
            synchronized (looper.lock) {
                for (int i = 0; i < 1000; i++) {
                    looper.increment();
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter value: " + looper.getCounter());

        /*
         * Anteponiendo volatile a la definición de la variable counter estamos diciendo
         * al compilador que el valor contenido en esa dirección
         * de memoria puede modificarse en cualquier momento, y queremos que dicha
         * modificación sea visible inmediatamente para todos los hilos que
         * están accediendo a ella, no queremos que su valor sea copiado en la caché del
         * procesador.
         * 
         * Haciendo nuestras variable volátiles obligamos a los hilos a leerlas de la
         * memoria
         * principal, y no del caché, garantizando que el valor leído siempre es el
         * último valor escrito en ellas.
         */
    }
}