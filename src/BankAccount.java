import java.util.Scanner;

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
                System.out.println("Withdrawn successfully");
            } else {
                System.out.println("You've over withdrawn, withdraw canceled");
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

    void addAccount(){
        Scanner keyboard = new Scanner(System.in);

    }

    void getMenu(){
        char choice = '\0';
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome "+customerName);
        System.out.println("Your ID is "+customerId);
        System.out.println("\n");
        do{
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous transaction");
            System.out.println("E. Exit");
            System.out.println("Please enter a choice");
            choice = keyboard.next().charAt(0);
            switch (choice){
                case 'A':
                    System.out.println("----------------------");
                    System.out.println("Your current balance is "+balance);
                    System.out.println("----------------------");
                    break;
                case 'B' :
                    System.out.println("----------------------");
                    System.out.println("How much would you like to deposit?");
                    int amount2 = keyboard.nextInt();
                    deposit(amount2);
                    System.out.println("$"+amount2+ " has been deposited");
                    break;
                case 'C':
                    System.out.println("----------------------");
                    System.out.println("How much would you like to withdraw?");
                    amount2 = keyboard.nextInt();
                    withdraw(amount2);
                    break;
                case 'D':
                    System.out.println("----------------------");
                    getPreviousBalance();
                    break;
                case 'E':
                    System.out.println("---------------------");
                    break;
                default:
                    System.out.println("Invalid option, please input a valid option");
                    break;
            }
        } while (choice != 'E');
//        System.out.println("");
    }
}
