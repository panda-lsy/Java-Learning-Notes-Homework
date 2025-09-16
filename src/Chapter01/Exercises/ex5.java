package Chapter01.Exercises;

class Reservation {
    int TicketID;

    void ShowTicket(){
        System.out.println("TicketID: " + TicketID);
    }

    public static void main(String[] args) {
        Reservation obj = new Reservation();
        obj.ShowTicket();
    }
}
