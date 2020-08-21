package flight;
//use of inheritance
public class type2 extends type1{
    //define intial luggage weight
    int busi_luggage=25;
    public void display_business_seats(int start,int end){
        System.out.println("");
        for(int i=start;i<=end;i++){
            System.out.println("\t\t"+i+": A | B \t\tC | D ");
        }
        System.out.println("");
    }
    @Override
    public void buyExcessBaggage(int k){
        int price=k*3000;
        System.out.println("Your additional charges are: "+price+" Rs");
        makePayment(price);
        
        busi_luggage=k+25;
    }
    public void buyExcessBaggage_eco(int k){
        int price=k*2000;
        System.out.println("Your additional charges are: "+price+" Rs");
        makePayment(price);
        
        eco_luggage=k+15;
    }
    
    @Override
    public String reservation(String class_of_Travel){
        class_of_Travel=class_of_Travel.toLowerCase();
        String seat_no="0";
        if("business".equals(class_of_Travel)){
            System.out.println("\nChoose your seat:-");
            display_business_seats(1,10);
            
            System.out.printf("Mention selected seat:- ");
            seat_no=sc.nextLine();
            
            //for additional baggage
            System.out.println("Your current baggage limit is "+busi_luggage+"Kgs ");
            System.out.printf("Would you like to increase weight( Y or N):- ");
            char c3 = sc.next().charAt(0); 
            if(c3=='Y'){
                System.out.printf("\nMention additional weight(allowance=10kg):- ");
                int w=sc.nextInt();
                
                System.out.println("");
                buyExcessBaggage(w);
            }
        }
        else if(!"economic".equals(class_of_Travel)){
            System.out.println("\nChoose your seat:-");
            display_economic_seats(11,30);
            
            System.out.printf("Mention selected seat:- ");
            seat_no=sc.nextLine();
            
            //additional luggage
            System.out.println("Your current baggage limit is "+eco_luggage+"Kgs ");
            System.out.printf("Would you like to increase weight( Y or N):- ");
            char c4 = sc.next().charAt(0); 
            if(c4=='Y'){
                System.out.printf("\nMention additional weight(allowance=5kg):- ");
                int w=sc.nextInt();
                
                System.out.println("");
                buyExcessBaggage_eco(w);
            }
        } 
        else {
            System.out.println(" INVALID CLASS OF TRAVEL");
        }
        return seat_no;
    }
}
