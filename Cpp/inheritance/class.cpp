#include <iostream>
#include <string>
using namespace std;

class account {
protected:
    string customerName;
    int accountNumber;
    string accountType;
    double balance;

public:
    void initialize(string name, int number, string type, double bal) {
        customerName = name;
        accountNumber = number;
        accountType = type;
        balance = bal;
    }

    void deposit(double amount) {
        balance += amount;
        cout << "Amount deposited successfully.\n";
    }

    void displayBalance() {
        cout << "\nCustomer Name: " << customerName << endl;
        cout << "Account Number: " << accountNumber << endl;
        cout << "Account Type: " << accountType << endl;
        cout << "Balance: " << balance << endl;
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            cout << "Amount withdrawn successfully.\n";
        }
        else {
            cout << "Insufficient balance!\n";
        }
    }
};


class savings_acct : public account {
public:
    void initializeSavings(string name, int number, double bal) {
        initialize(name, number, "Savings Account", bal);
    }

    void computeInterest(double rate) {
        double interest = balance * rate / 100;
        balance += interest;

        cout << "Interest deposited: " << interest << endl;
    }
};


class current_acct : public account {
private:
    double minimumBalance;
    double serviceCharge;

public:
    void initializeCurrent(string name, int number, double bal,
                           double minBal, double charge) {
        initialize(name, number, "Current Account", bal);
        minimumBalance = minBal;
        serviceCharge = charge;
    }

    void chequeBook() {
        cout << "Cheque book facility is available.\n";
    }

    void checkMinimumBalance() {
        if (balance < minimumBalance) {
            cout << "Balance is below minimum balance.\n";
            cout << "Service charge imposed: " << serviceCharge << endl;

            balance -= serviceCharge;

            cout << "Balance after service charge: "
                 << balance << endl;
        }
        else {
            cout << "Minimum balance maintained.\n";
        }
    }
};

int main() {

    savings_acct savings;
    current_acct current;

    string name;
    int number;
    double amount;
    double balance;

    int choice;

    cout << "Select which account you want to open:\n";
    cout << "1. Savings account\n";
    cout << "2. Current account\n";
    cout << "Enter your choice: ";
    cin >> choice;

    if(choice == 1) {

        cout << "\n-SAVINGS ACCOUNT-" << endl;
        cin.ignore();

        cout << "Enter customer name: ";
        getline(cin, name);

        cout << "Enter account number: ";
        cin >> number;

        cout << "Enter initial balance: ";
        cin >> balance;

        savings.initializeSavings(name, number, balance);

        savings.displayBalance();

        cout << "\nEnter amount to deposit: ";
        cin >> amount;
        savings.deposit(amount);

        savings.displayBalance();

        double rate;

        cout << "\nEnter interest rate (%): ";
        cin >> rate;

        savings.computeInterest(rate);
        savings.displayBalance();

        cout << "\nEnter amount to withdraw: ";
        cin >> amount;

        savings.withdraw(amount);
        savings.displayBalance();
    }

    else if(choice == 2) {

        cout << "\n-CURRENT ACCOUNT-" << endl;
        cin.ignore();

        cout << "Enter customer name: ";
        getline(cin, name);

        cout << "Enter account number: ";
        cin >> number;

        cout << "Enter initial balance: ";
        cin >> balance;

        double minBalance, charge;

        cout << "Enter minimum balance: ";
        cin >> minBalance;

        cout << "Enter service charge: ";
        cin >> charge;

        current.initializeCurrent(name, number, balance,
                                  minBalance, charge);

        current.displayBalance();

        current.chequeBook();

        cout << "\nEnter amount to deposit: ";
        cin >> amount;

        current.deposit(amount);
        current.displayBalance();

        cout << "\nEnter amount to withdraw: ";
        cin >> amount;

        current.withdraw(amount);
        current.displayBalance();

        cout << "\nChecking minimum balance..." << endl;

        current.checkMinimumBalance();

        current.displayBalance();
    }

    else {
        cout << "Invalid choice entered.";
    }

    return 0;
}