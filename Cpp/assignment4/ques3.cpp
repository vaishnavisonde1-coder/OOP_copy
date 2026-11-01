#include <iostream>
using namespace std;

class Account {
protected:
    int account_number;
    double balance;

public:
    Account(int number, double bal) {
        account_number = number;
        balance = bal;
    }

    virtual void deposit(double amount) {
        balance += amount;
        cout << "Amount deposited successfully." << endl;
    }

    virtual void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            cout << "Amount withdrawn successfully." << endl;
        }
        else {
            cout << "Insufficient balance!" << endl;
        }
    }

    virtual void display() {
        cout << "Account Number: " << account_number << endl;
        cout << "Balance: " << balance << endl;
    }

    virtual ~Account() {
    }
};


class SavingsAccount : public Account {
private:
    double interestRate;

public:
    SavingsAccount(int number, double bal, double rate)
        : Account(number, bal) {
        interestRate = rate;
    }

    void deposit(double amount) override {
        balance += amount;
        cout << "Amount deposited in Savings Account." << endl;
    }

    void withdraw(double amount) override {
        if (amount <= balance) {
            balance -= amount;
            cout << "Amount withdrawn from Savings Account." << endl;
        }
        else {
            cout << "Insufficient balance!" << endl;
        }
    }

    void display() override {
        cout << "\n--- SAVINGS ACCOUNT ---" << endl;
        cout << "Account Number: " << account_number << endl;
        cout << "Balance: " << balance << endl;
        cout << "Interest Rate: " << interestRate << "%" << endl;
    }

    void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;

        cout << "Interest applied: " << interest << endl;
    }
};


class CurrentAccount : public Account {
private:
    double minimumBalance;

public:
    CurrentAccount(int number, double bal, double minBal)
        : Account(number, bal) {
        minimumBalance = minBal;
    }

    void deposit(double amount) override {
        balance += amount;
        cout << "Amount deposited in Current Account." << endl;
    }

    void withdraw(double amount) override {
        if (balance - amount >= minimumBalance) {
            balance -= amount;
            cout << "Amount withdrawn from Current Account." << endl;
        }
        else {
            cout << "Withdrawal not allowed!" << endl;
            cout << "Minimum balance must be maintained." << endl;
        }
    }

    void display() override {
        cout << "\n--- CURRENT ACCOUNT ---" << endl;
        cout << "Account Number: " << account_number << endl;
        cout << "Balance: " << balance << endl;
        cout << "Minimum Balance: " << minimumBalance << endl;
    }
};


int main() {

    int number;
    double balance;
    double amount;

    cout << "Enter Savings Account Number: ";
    cin >> number;

    cout << "Enter Initial Balance: ";
    cin >> balance;

    double rate;

    cout << "Enter Interest Rate (%): ";
    cin >> rate;

    SavingsAccount savings(number, balance, rate);

    cout << "\nEnter Current Account Number: ";
    cin >> number;

    cout << "Enter Initial Balance: ";
    cin >> balance;

    double minBalance;

    cout << "Enter Minimum Balance: ";
    cin >> minBalance;

    CurrentAccount current(number, balance, minBalance);

    Account *ptr;

    cout << "\n-SAVINGS ACCOUNT TRANSACTION-" << endl;

    ptr = &savings;

    ptr->display();

    cout << "\nEnter amount to deposit: ";
    cin >> amount;
    ptr->deposit(amount);

    cout << "\nEnter amount to withdraw: ";
    cin >> amount;
    ptr->withdraw(amount);

    ptr->display();

    savings.applyInterest();
    ptr->display();

    cout << "\n-CURRENT ACCOUNT TRANSACTION-" << endl;

    ptr = &current;

    ptr->display();

    cout << "\nEnter amount to deposit: ";
    cin >> amount;
    ptr->deposit(amount);

    cout << "\nEnter amount to withdraw: ";
    cin >> amount;
    ptr->withdraw(amount);

    ptr->display();


    return 0;
}