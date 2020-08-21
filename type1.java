package flight;
import java.util.*;
public class type1 {
    //define intial luggage weight
    int eco_luggage=15;
    
    Scanner sc = new Scanner(System.in);
    public void display_economic_seats(int start,int end){
        System.out.println("");
        for(int i=start;i<=end;i++){
            System.out.println("\t\t"+i+": A | B | C\t\tD | E | F");
        }
        System.out.println("");
    }
    public String reservation(String class_of_Travel){
        class_of_Travel=class_of_Travel.toLowerCase();
        String seat_no="0";
        if("economic".equals(class_of_Travel)){
            System.out.println("\nChoose your seat:-");
            display_economic_seats(1,30);
            System.out.printf("Mention selected seat:- ");
            seat_no=sc.nextLine();
            
            //ask for additional baggage
            System.out.println("Your current baggage limit is "+eco_luggage+"Kgs ");
            System.out.printf("Would you like to increase weight( Y or N):- ");
            char c1 = sc.next().charAt(0); 
            if('Y'==c1){
                System.out.printf("\nMention additional weight(allowance=5kg):- ");
                int w=sc.nextInt();
                
                System.out.println("");
                buyExcessBaggage(w);
            }
        }
        else{
            System.out.println(" INVALID CLASS OF TRAVEL");
        }
        return seat_no;
    }
    public void buyExcessBaggage(int k){
        int price=k*2000;
        System.out.println("Your additional charges are: "+price+" Rs");
        makePayment(price);
        
         eco_luggage=k+15;
    }
    public void makePayment(int r){
        System.out.printf("Proceed for payment of "+r+" rupees ( Y or N):- ");
        char c2 = sc.next().charAt(0); 
            if(c2=='Y'){
             System.out.println("\n\t\tBaggage limit increased succesfully!!!");   
            }
        
    }
    
    public String generatePnr(String f_name,String l_name,String t_type,String seatNo,int bag){
        StringBuilder pnr = new StringBuilder();
        pnr.append(f_name.charAt(0));
        pnr.append(l_name.charAt(0));
        pnr.append('.');
        pnr.append(t_type);
        pnr.append('.');
        pnr.append(seatNo);
        pnr.append('.');
        pnr.append(bag);
        
        return pnr.toString();
        
    }
    

//    String generatePnr(String fn, String ln, String tic_type, String seat) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
