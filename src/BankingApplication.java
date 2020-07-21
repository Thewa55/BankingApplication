import java.util.ArrayList;
import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        String customerN = "";
        String customerI = "";
        ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
        char option = '\0';
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("Welcome to Kenny's bank");
            System.out.println("A. Add an account");
            System.out.println("B. View an account");
            System.out.println("C. Exit");
            System.out.println("What would you like to do?");
            option = keyboard.next().charAt(0);
            switch (option) {
                case 'A':
                    System.out.println("What is the customer's name?");
                    customerN = keyboard.next();
                    System.out.println("What is the customer's ID?");
                    customerI = keyboard.next();
                    BankAccount account1 = new BankAccount(customerN, customerI);
                    bankAccounts.add(account1);
                    break;
                case 'B':
                    if(bankAccounts.size() > 0){
                        int index = 1;
                        System.out.println("Here are the customers:");
                        for(BankAccount bankAccount: bankAccounts){
                            System.out.println(index+") "+bankAccount.customerName + " --- " + bankAccount.customerId);
                            index++;
                        }
                        System.out.println(index+") Exit");
                        if(keyboard.hasNextInt()){
                            int customerSelected = keyboard.nextInt();
                            if(customerSelected -1 < bankAccounts.size() && customerSelected > 0){
                                bankAccounts.get(customerSelected-1).getMenu();
                            } else if (customerSelected == index){
                                break;
                            } else {
                                System.out.println("Invalid option");
                            }
                        } else {
                            System.out.println("Please enter a valid option");
                            keyboard.next();
                        }
                    } else {
                        System.out.println("There are currently no accounts");
                    }
                    break;
                case 'C':
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;

//            BankAccount account1 = new BankAccount("XYZ", "BA001");
//            account1.getMenu();
            }
        }while (option != 'C');
        System.out.println("Thank you for using Kenny's bank");
    }
}
