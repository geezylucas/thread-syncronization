public class Ticket {

    volatile int tickets = 3;

    public synchronized void bookticket(String name, int wantedtickets) {
        if (wantedtickets <= tickets) {
            System.out.println(wantedtickets + " booked to " + name);
            tickets = tickets - wantedtickets;
        } else {
            System.out.println("No tickets to book");
        }
    }
}
