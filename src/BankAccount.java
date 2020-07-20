public class BankAccount {
    int balance;
    int previousBalance;
    String customerName;
    String customerId;

    BankAccount(String custName, String custId){
        this.customerName = custName;
        this.customerId = custId;
    }

    void deposit(int amount){
        if(amount != 0){
            balance = balance + amount;
            previousBalance = amount;
        }
    }

    void withdraw(int amount){
        if(amount !=0){
            if(balance - amount > 0){
                balance = balance - amount;
                previousBalance = -amount;
            } else {
                System.out.println("You've over withdrawn");
            }
        }
    }

    void getPreviousBalance(){
        if(previousBalance > 0){
            System.out.println("Deposited : $" + previousBalance );
        } else if(previousBalance < 0){
            System.out.println("Withdrew: $"+ Math.abs(previousBalance));
        } else{
            System.out.println("No transaction recorded.");
        }
    }
}
