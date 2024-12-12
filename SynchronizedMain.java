public class SynchronizedMain {

    public static void main(String[] args) {
        final Ticket obj = new Ticket();// only one object

        Thread t1 = new Thread(() -> {
            obj.bookticket("t1", 1);
        });
        Thread t2 = new Thread(() -> {
            obj.bookticket("t2", 2);
        });
        Thread t3 = new Thread(() -> {
            obj.bookticket("t3", 3);
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
