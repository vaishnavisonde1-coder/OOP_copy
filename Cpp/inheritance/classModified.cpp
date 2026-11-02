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
    account(string name, int number, string type, double bal) {
        customerName = name;
        accountNumber = number;
        accountType = type;
        balance = bal;
    }

    void deposit(double amount) {
        balance += amount;
        cout << "Amount deposited successfully." << endl;
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
            cout << "Amount withdrawn successfully." << endl;
        }
        else {
            cout << "Insufficient balance!" << endl;
        }
    }
};


class savings_acct : public account {
public:
   
    savings_acct(string name, int number, double bal)
        : account(name, number, "Savings Account", bal) {
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
   
    current_acct(string name, int number, double bal,
                 double minBal, double charge)
        : account(name, number, "Current Account", bal) {

        minimumBalance = minBal;
        serviceCharge = charge;
    }

    void chequeBook() {
        cout << "Cheque book facility is available." << endl;
    }

    void checkMinimumBalance() {
        if (balance < minimumBalance) {
            cout << "Balance is below minimum balance." << endl;

            cout << "Service charge imposed: "
                 << serviceCharge << endl;

            balance -= serviceCharge;

            cout << "Balance after service charge: "
                 << balance << endl;
        }
        else {
            cout << "Minimum balance maintained." << endl;
        }
    }
};


int main() {

    string name;
    int number;
    double amount;
    double balance;

    int choice;

    cout << "Select which account you want to open:" << endl;
    cout << "1. Savings account" << endl;
    cout << "2. Current account" << endl;
    cout << "Enter your choice: ";
    cin >> choice;

    if (choice == 1) {

        cout << "\n-SAVINGS ACCOUNT-" << endl;

        cin.ignore();

        cout << "Enter customer name: ";
        getline(cin, name);

        cout << "Enter account number: ";
        cin >> number;

        cout << "Enter initial balance: ";
        cin >> balance;

        savings_acct savings(name, number, balance);

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

    else if (choice == 2) {

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

        current_acct current(name, number, balance,
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
        cout << "Invalid choice entered." << endl;
    }

    return 0;
}