/*Problem Statement: Design an Order class and an Invoice class such that every object, upon construction, creates a matching Order Invoice using values passed through from the order's own constructor parameters. Requirements: Order with order ID, item name, and amount. Invoice with invoice number (derived from order ID) and amount. Order 's constructor initializes its Invoice member using an initializer list. Demonstrate for 2 different orders. Input Assumptions: Sample order data. Expected Output: Each order shows a correctly derived invoice number and amount.*/

#include <iostream>
#include <string>
using namespace std;

class Invoice {
protected:
    int invoiceNumber;
    double amount;

public:
    Invoice(int invNo, double amt)
        : invoiceNumber(invNo), amount(amt) {}

    void displayInvoice() {
        cout << "Invoice Number: " << invoiceNumber << endl;
        cout << "Amount: " << amount << endl;
    }
};

class Order : public Invoice {
private:
    int orderId;
    string itemName;

public:
    Order(int id, string item, double amt)
        : Invoice(id + 1000, amt),
          orderId(id),
          itemName(item) {}

    void displayOrder() {
        cout << "Order ID: " << orderId << endl;
        cout << "Item Name: " << itemName << endl;
        displayInvoice();
    }
};

int main() {

    Order order1(101, "Laptop", 55000);
    Order order2(102, "Mobile", 25000);

    cout << "Order 1" << endl;
    order1.displayOrder();

    cout << "\nOrder 2" << endl;
    order2.displayOrder();

    return 0;
}