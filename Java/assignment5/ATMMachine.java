/*1.	An ATM machine needs to authenticate a user via a PIN before letting them perform transactions. Once logged in, the user can check their balance, deposit money, or withdraw money. The program must validate that withdrawals do not exceed the current balance and handle incorrect PIN attempts */
package assignment5;
import java.util.Scanner;

class ATM {
    private double balance;
    private final int correctPin;
    private int pinAttempts;
    private static final int MAX_ATTEMPTS = 3;
    private boolean isLocked;

    public ATM(double initialBalance, int defaultPin) {
        this.balance = initialBalance;
        this.correctPin = defaultPin;
        this.pinAttempts = 0;
        this.isLocked = false;
    }

    public boolean authenticate(int enteredPin) {
        if (isLocked) {
            System.out.println("❌ Account Status: Locked. Contact customer care.");
            return false;
        }

        if (enteredPin == correctPin) {
            pinAttempts = 0; 
            System.out.println("✅ Access Granted. Welcome!");
            return true;
        } else {
            pinAttempts++;
            int remaining = MAX_ATTEMPTS - pinAttempts;
            System.out.println("❌ Incorrect PIN!");
            
            if (remaining <= 0) {
                isLocked = true;
                System.out.println("🚨 Warning: Too many incorrect attempts. Your account is now LOCKED.");
            } else {
                System.out.println("You have " + remaining + " attempt(s) remaining.");
            }
            return false;
        }
    }

    public void checkBalance() {
        System.out.printf("💰 Your current balance is: ₹%.2f%n", balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Error: Invalid deposit amount. Must be greater than zero.");
            return;
        }
        balance += amount;
        System.out.printf("✅ Successfully deposited ₹%.2f. New Balance: ₹%.2f%n", amount, balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Error: Invalid withdrawal amount. Must be greater than zero.");
            return;
        }
        
        if (amount > balance) {
            System.out.printf("❌ Transaction Denied: Insufficient Funds! (Current Balance: ₹%.2f)%n", balance);
            return;
        }
        
        balance -= amount;
        System.out.printf("✅ Successfully withdrew ₹%.2f. New Balance: ₹%.2f%n", amount, balance);
    }

    public boolean isAccountLocked() {
        return isLocked;
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ATM myATM = new ATM(25000.00, 1234);
        boolean authenticated = false;

        System.out.println("========================================");
        System.out.println("      WELCOME TO THE SECURITAS ATM      ");
        System.out.println("========================================");

        while (!authenticated) {
            if (myATM.isAccountLocked()) {
                System.out.println("\nSystem shutting down due to security lock.");
                scanner.close();
                return;
            }

            System.out.print("Please enter your 4-digit PIN: ");
            int inputPin = scanner.nextInt();
            authenticated = myATM.authenticate(inputPin);
            System.out.println(); // Formatter spacer
        }

        while (true) {
            System.out.println("\n--- TRANSACTION MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit / Remove Card");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    myATM.checkBalance();
                    break;
                    
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depAmount = scanner.nextDouble();
                    myATM.deposit(depAmount);
                    break;
                    
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withAmount = scanner.nextDouble();
                    myATM.withdraw(withAmount);
                    break;
                    
                case 4:
                    System.out.println("Thank you for choosing our banking services. Goodbye!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid selection! Please choose a valid operation (1-4).");
            }
        }
    }
}
