package flight;
public class type3 extends type2{
    //define intial luggage weight
    int first_luggage=30;
    
    public void display_firstclass_seats(){
        System.out.println("");
        for(int i=1;i<=10;i++){
            System.out.println("\t\t"+i+": A \t\t B ");
        }
        System.out.println("");
    }
    @Override
    public void buyExcessBaggage(int k){
        int price=k*4000;
        System.out.println("Your additional charges are: "+price+" Rs");
        makePayment(price);
        
        first_luggage= k+30;
    }
    public void buyExcessBaggage_busi(int k){
        int price=k*3000;
        System.out.println("Your additional charges are: "+price+" Rs");
        makePayment(price);
        
        busi_luggage=k+25;
    }
    
    @Override
    public String reservation(String class_of_Travel){
        class_of_Travel=class_of_Travel.toLowerCase();
        String seat_no="0";
        if("firstclass".equals(class_of_Travel)){
            System.out.println("\nChoose your seat:-");
            display_firstclass_seats();
            
            System.out.printf("Mention selected seat:- ");
            seat_no=sc.nextLine();
            
            //for additional baggage
            System.out.println("Your current baggage limit is "+first_luggage+"Kgs ");
            System.out.printf("Would you like to increase weight( Y or N):- ");
            char c5 = sc.next().charAt(0); 
            if(c5=='Y'){
                System.out.printf("\nMention additional weight(allowance=10kg):- ");
                int w=sc.nextInt();
                
                System.out.println("");
                buyExcessBaggage(w);
            }
        }
        else if("business".equals(class_of_Travel)){
            System.out.println("\nChoose your seat:-");
            display_business_seats(1,10);
            
            System.out.printf("Mention selected seat:- ");
            seat_no=sc.nextLine();
            
            //for additional baggage
            System.out.println("Your current baggage limit is "+busi_luggage+"Kgs ");
            System.out.printf("Would you like to increase weight( Y or N):- ");
            char c5 = sc.next().charAt(0); 
            if(c5=='Y'){
                System.out.printf("\nMention additional weight(allowance=10kg):- ");
                int w=sc.nextInt();
                
                System.out.println("");
                buyExcessBaggage_busi(w);
            }
        } 
        else if("economic".equals(class_of_Travel)){
            System.out.println("\nChoose your seat:-");
            display_economic_seats(11,30);
            
            System.out.printf("Mention selected seat:- ");
            seat_no=sc.nextLine();
            
            //additional luggage
            System.out.println("Your current baggage limit is "+eco_luggage+"Kgs ");
            System.out.printf("Would you like to increase weight( Y or N):- ");
            char c6 = sc.next().charAt(0); 
            if(c6=='Y'){
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
