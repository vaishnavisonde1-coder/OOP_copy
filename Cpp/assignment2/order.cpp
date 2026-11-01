/*Design an Order class and an Invoice class such that every object, upon construction, creates a matching Order Invoice using values passed through from the order's own constructor parameters. Requirements: Order with order ID, item name, and amount. Invoice with invoice number (derived from order ID) and amount. Order 's constructor initializes its Invoice member using an initializer list. Demonstrate for 2 different orders
*/
#include <iostream>
#include <string>
using namespace std;

class Invoice {
public:
    string invoiceNumber; 
    float amount;

    Invoice(string orderId, float amt) {
       
        invoiceNumber = "INV-" + orderId; 
        amount = amt;
    }

    void displayInvoice() const {
        cout << "  [Invoice Number: " << invoiceNumber 
             << " | Billing Amount: " << amount << "]" << endl;
    }
};

class Order {
private:
    string orderID;
    string itemName;
    float amount;
    Invoice matchingInvoice; 

public:
    Order(string id, string name, float amt) 
        : orderID(id), itemName(name), amount(amt), matchingInvoice(id, amt) {
      
    }

    void displayOrderDetails() const {
        cout << "Order ID: " << orderID 
             << " | Item: " << itemName 
             << " | Price: " << amount << endl;
       
        matchingInvoice.displayInvoice();
        cout <<endl;
    }
};

int main() {
    cout << "Order and Invoice Generation Bill\n" << endl;

    Order order1("ORD101", "Gaming Laptop", 85000.00);
    order1.displayOrderDetails();

    Order order2("ORD102", "Wireless Headphones", 3500.50);
    order2.displayOrderDetails();

    return 0;
}
