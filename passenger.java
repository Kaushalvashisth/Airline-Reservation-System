package flight;
public class passenger {
    String firstname,lastname,from,destination;
    String ticketType;
    String seatNo;
    String seatType;
    String pnr;
    int bag;

    public passenger(String firstname, String lastname, String from, String destination,
            String ticketType, String seatNo, String seatType, String pnr, int bag) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.from = from;
        this.destination = destination;
        this.ticketType = ticketType;
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.pnr = pnr;
        this.bag = bag;
    }
   public void passengerDetails(){
       System.out.println("\t---------------------------------------------------------------");
       System.out.println("");        
       System.out.println("\t" +"Flight details are:- ");
       System.out.println("\t\t\t |Passenger name: "+firstname+" "+lastname);
       System.out.println("\t\t\t |From: "+from+"\t To: "+destination);
       System.out.println("\t\t\t |TicketType: "+ticketType+"\t SeatType: "+seatType);
       System.out.println("\t\t\t |SeatNo: "+seatNo+"\t Luggage: "+bag+" kgs");
       System.out.println("\t\t\t |Your PNR: "+pnr);
       System.out.println("");
       System.out.println("\t---------------------------------------------------------------");
   }
}
