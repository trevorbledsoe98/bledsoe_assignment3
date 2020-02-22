package bledsoe_problem2;

public class SavingsAccount {
	
	//variables
	static private double annualInterestRate;
    private double savingBalance;

    //method for savings account
    public SavingsAccount(){
    }

    //using savings balance
    public SavingsAccount(double savingBalance){
    	this.savingBalance=savingBalance;
    }

    //Get the savings balance
    public double getSavingBalance(){
        return this.savingBalance;
     }
    
    //Setting annual interest rate to a new value
    public static void modifyInterestRate(double newInterestRate){
        annualInterestRate=newInterestRate;
    }

    //Method to calculate monthly interest
    public void calculateMonthlyInterest(){
        double monthlyI;
        monthlyI= (double)(this.savingBalance*annualInterestRate/12);
        this.savingBalance+=monthlyI;
    }
	
}
