package flight;
import java.util.Scanner;
import java.util.*;

public class Flight {
    ArrayList<String> pnrList;

    public Flight(int seats) {
        this.pnrList = new ArrayList<String>(seats);
    }   

    public void cancelTicket(String PNR) {
        //use of exceptional handling
        try{
           int index=pnrList.indexOf(PNR);
            pnrList.remove(index); 
            System.out.println("\t\t\tTicket cancelled succesfully");
        }
        catch(Exception e){
            System.out.println("\t\t\t!!INVALID PNR!!!  TRY AGAIN!!!");
            System.out.println("\t\t\tTicket cancel unsuccesfull");
        }           
    }
    public void getBaggageLimit(String pnr){
//        System.out.println(pnr);
        if(pnrList.contains(pnr)){
           int index;
           index=pnrList.indexOf(pnr); 
           String arrOfStr[] = pnr.split("[.]");
           System.out.println("your baggage limit is :- "+arrOfStr[3]+"Kgs");
        }
        else{
            System.out.println("\t\t\t!!INVALID PNR!!!  TRY AGAIN!!!");
        }
    }
    
    public String getdetails(){
        Scanner sc = new Scanner(System.in);
        //object of passenger
        System.out.println("\tENTER DETAILS:-");
                System.out.printf("From:- ");
                String from=sc.nextLine();
                System.out.printf("destination:- ");
                String dest=sc.nextLine();
                
                System.out.printf("Firstname:- ");
                String fn=sc.nextLine();
                System.out.printf("lastname:- ");
                String ln=sc.nextLine();
                
                //ticket type and seat type
                System.out.printf("ticket type(eg:- type1 or 2 or 3):- ");
                String tic_type=sc.nextLine();
  
                tic_type=tic_type.toLowerCase();
                
                String pnr="0";
                
        if(null != tic_type)
        switch (tic_type) {
            case "type1":{
                type1 t1 = new type1();
                System.out.printf("select class of travel:- ");
                String class_of_travel=sc.nextLine();
                String seat_no=t1.reservation(class_of_travel);
                pnr = t1.generatePnr(fn, ln, tic_type, seat_no,t1.eco_luggage);
                passenger p1=new passenger(fn,ln,from,dest,tic_type,seat_no,
                        class_of_travel,pnr,t1.eco_luggage);
                p1.passengerDetails();//list_of_PNR.add(pnr);
                    break;
                }
            case "type2":{
                type2 t2 = new type2();
                System.out.printf("select class of travel:- ");
                String class_of_travel=sc.nextLine();
                String seat_no=t2.reservation(class_of_travel);
                if("business".equals(class_of_travel)){
                    pnr = t2.generatePnr(fn, ln, tic_type, seat_no,t2.busi_luggage);
                    passenger p1=new passenger(fn,ln,from,dest,tic_type,
                            seat_no,class_of_travel,pnr,t2.busi_luggage);
                    p1.passengerDetails();//list_of_PNR.add(pnr);
                }
                else{
                    pnr = t2.generatePnr(fn, ln, tic_type, seat_no,t2.eco_luggage);
                    passenger p1=new passenger(fn,ln,from,dest,tic_type,seat_no,
                            class_of_travel,pnr, t2.eco_luggage);
                    p1.passengerDetails();//list_of_PNR.add(pnr);
                }
                    break;
                }
            case "type3":{
                type3 t3 = new type3();
                System.out.printf("select class of travel:- ");
                String class_of_travel=sc.nextLine();
                String seat_no=t3.reservation(class_of_travel);
                if("firstclass".equals(class_of_travel)){
                    pnr = t3.generatePnr(fn, ln, tic_type, seat_no,t3.first_luggage);
                    passenger p1=new passenger(fn,ln,from,dest,tic_type,
                            seat_no,class_of_travel,pnr,t3.first_luggage);
                    p1.passengerDetails();//list_of_PNR.add(pnr);
                }
                else if("business".equals(class_of_travel)){
                    pnr = t3.generatePnr(fn, ln, tic_type, seat_no,t3.busi_luggage);
                    passenger p1=new passenger(fn,ln,from,dest,tic_type,
                            seat_no,class_of_travel,pnr,t3.busi_luggage);
                    p1.passengerDetails();
                    //list_of_PNR.add(pnr);
                }
                else{
                   pnr = t3.generatePnr(fn, ln, tic_type, seat_no,t3.eco_luggage);
                    passenger p1=new passenger(fn,ln,from,dest,tic_type,seat_no,
                            class_of_travel,pnr, t3.eco_luggage);
                    p1.passengerDetails();
                    //list_of_PNR.add(pnr);
                }
                    break;
                }
            default:
                break;
        }
    pnrList.add(pnr);
    return pnr;
    }
    
    public static void main(String[] args) {   
        Scanner sc1 = new Scanner(System.in);
        //flight object
        Flight f1 =new Flight(10);//total tickets assumed as 10
        //pnr list
        ArrayList<String> pnrList = new ArrayList<String>(10);
        OUTER:
        while (true) {
            System.out.println("\t\t\t\t MENU:-");
            System.out.println("\t\t\t\t\t 1: BOOK TICKETS ");
            System.out.println("\t\t\t\t\t 2:  GET BAGGAGE LIMIT BY PNR");
            System.out.println("\t\t\t\t\t 3: CANCEL TICKETS ");
            System.out.println("\t\t\t\t\t 4: EXIT ");
            System.out.println("enter your choice:- ");
            int num = sc1.nextInt();
            int choice=num;
            switch (choice) {
                case 1:
                    String p1=f1.getdetails();
                    break;
                case 2:
                    System.out.println("ENTER PNR:- ");
                    sc1.nextLine();
                    String pnr1=sc1.nextLine();
                    f1.getBaggageLimit(pnr1);
                    break;
                case 3:
                    System.out.printf("ENTER PNR:- ");
                    sc1.nextLine();
                    String pnr2=sc1.nextLine();
                    f1.cancelTicket(pnr2);
                    break;
                default:
                    break OUTER;
            }
        }
    }    
}

/*    //list of economy
    ArrayList<String> eco_List_t1=new ArrayList<String>(10);
    ArrayList<String> eco_List_t2=new ArrayList<String>(10);
    ArrayList<String> eco_List_t3=new ArrayList<String>(10);
    
    //list of business
    ArrayList<String> bui_List_t2=new ArrayList<String>(10);
    ArrayList<String> bui_List_t3=new ArrayList<String>(10);
    // list of first class
    ArrayList<String> first_List=new ArrayList<String>(10);
*/