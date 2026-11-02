/*A vehicle rental company maintains vehicle booking records.

Create a class VehicleRental with

Vehicle Number 
Customer Name 
Vehicle Type (Bike/Car/SUV) 
Rental Days 
Rent Per Day 
Security Deposit 

Functionality used 
Implement overloaded constructors. 
The constructor should automatically determine security deposit:

Vehicle Type	Deposit
Bike	₹2000
Car	₹5000
SUV	₹8000

Tasks
Calculate rental amount. 
Apply 10% discount if rental days exceed 7. 
Display final payable amount. 
*/
 
#include<iostream>
using namespace std;

class VehicalRental{
  public:
  int Vehicalnumber;
  string customerName;
  string VehicleType; //(Bike/Car/SUV)
  int rentalDays;
  int rentPerDay;
  int securityDeposit;

    
    VehicalRental() {
        Vehicalnumber= 0;
        customerName = "Unknown";
        VehicleType = "Bike";
        rentalDays = 0;
        rentPerDay = 0;
        securityDeposit = 2000;
    }


    VehicalRental(int vn, string cm, string vt, int rd, int rpd){
        Vehicalnumber = vn;
        customerName = cm;
        VehicleType = vt;
        rentalDays = rd;
        rentPerDay = rpd;

        if(VehicleType == "Bike"){
            securityDeposit = 2000;
        }
        else if(VehicleType == "Car"){
            securityDeposit = 5000;
        }
        else if(VehicleType == "SUV"){
            securityDeposit = 8000;
        }
        else{
            cout<<"Invalid vehical type entered....";
        }

    };

        float RentalAmount(){
            if(rentalDays>7){
                return 0.9*rentalDays*rentPerDay;
            }
            return rentalDays*rentPerDay;
        }

        float payableAmount(){
            return (securityDeposit + RentalAmount());
        }

        void printReceipt(){
            cout<<"\nThe Reciept is: \n";
            cout<<"Customer Name: "<<customerName;
            cout<<"\nVehical Number: "<<Vehicalnumber;
            cout<<"\nVehical Type: "<<VehicleType;
            cout<<"\nRental days: "<<rentalDays;
            cout<<"\nRent Per Days: $"<<rentPerDay;
            cout<<"\nTotal Rent: $"<<RentalAmount();
            cout<<"\nSecurity Deposits: $"<<securityDeposit;
            cout<<"\n\nTotal Payable Amount: $"<<payableAmount()<<endl;
        }
};

int main(){
    int vn;
    string cm; 
    string vt;
    int rd;
    int rpd;
    cout<<"Enter Vehical Number: ";
    cin>>vn;
    cin.ignore();
    cout<<"Enter Customer Name: ";
    getline(cin, cm);
    cout<<"Enter Vehical Type(Bike/Car/SUV): ";
    cin>>vt;
    cout<<"Enter Rental Days: ";
    cin>>rd;
    rpd = 100;
    VehicalRental v(vn, cm, vt, rd, rpd);
    v.printReceipt();
    return 0;
}