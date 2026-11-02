/*Create a class Car with:
•	Brand 
•	Model 
•	Color 
Display the car details.
*/

#include<iostream>
using namespace std;

class car
{

public:
   string Brand;
   string color;
   int model;

   void getDetails(string bran, string col, int mod){
     Brand = bran;
     color = col;
     model = mod;
   }
   void printDetails(){
        cout<<"The car is "<<Brand<<" of color "<<color<<" & has model number: "<<model<<endl;
   }
};

int main(){
    car c1;
    cout<<"The details of the car is: \n";
    c1.getDetails("BMW", "Brown", 5785);
    c1.printDetails();
    return 0;
}