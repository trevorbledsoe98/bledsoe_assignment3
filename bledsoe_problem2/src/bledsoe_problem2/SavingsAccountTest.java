package bledsoe_problem2;

public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1, saver2;
        saver1 = new SavingsAccount (2000.0);
        saver2= new SavingsAccount (3000.0);
      
        int total = 0;

        
        SavingsAccount.modifyInterestRate (0.04);
        System.out.println("Balance for Saver 1\n");
        for(int i=0; i<12; i++) {
        
        saver1.calculateMonthlyInterest();            
        
        System.out.println("Month " + (i+1)+" : "+ String.format("%.2f",saver1.getSavingBalance()));
        }
        System.out.println("\nBalance for Saver 2\n");
        for(int i=0; i<12; i++) {
        
        saver2.calculateMonthlyInterest();
        System.out.println("Month " + (i+1)+" : "+ String.format("%.2f",saver2.getSavingBalance()));
        }
        
        SavingsAccount.modifyInterestRate(0.05);
        System.out.println("\nNew balance for Saver 1 with new interest rate\n");
       
        for(int i=0; i<12; i++) {
    	   saver1.calculateMonthlyInterest();            
       
    	   System.out.println("Month " + (i+1)+" : "+ String.format("%.2f",saver1.getSavingBalance()));
        }
        System.out.println("\nNew balence for Saver 2 with new interest rate\n");
       
        for(int i=0; i<12; i++) {
    	   saver2.calculateMonthlyInterest();
       
    	   System.out.println("Month " + (i+1)+" : "+ String.format("%.2f",saver2.getSavingBalance()));
       }

}
}


