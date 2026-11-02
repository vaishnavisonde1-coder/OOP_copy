/*Create a class BankAccount with:
•	Account Number 
•	Account Holder Name 
•	Balance 
Display the account details.
*/

#include<iostream>
using namespace std;

class BankAccount{
    private: 
      int balance;
    public:
      int accNumber;
      string accHolder;
    
    void getDetails(string name, int number, int bal){
        accNumber = number;
        accHolder = name;
        balance = bal;
    }
    void viewBalance(){
        
    }
    void printDetails(){
        cout<<"Account Holder Name: "<<accHolder<<endl;
        cout<<"Account Number: "<<accNumber<<endl;
        cout<<"Balance amount in your account is: "<<balance<<endl;
    }

};

int main(){
    BankAccount user1, user2;
    cout<<"--Account Details--\n";
    user1.getDetails("Vidya Balan", 55874, 550000);
    user1.printDetails();
    user2.getDetails("Jiya Attar", 65236, 6950);
    user2.printDetails();

    return 0;
}