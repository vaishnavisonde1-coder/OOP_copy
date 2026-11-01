/*Create a class Interest.
•	Input Principal, Rate, and Time. 
•	Calculate the Simple Interest. 
Formula: SI = (P × R × T) / 100
*/

#include<iostream>
using namespace std;

class si
{
public:
int principal, rate, time;

  float simpleInterest(){
    return ((float)(principal*rate*time))/100;
  }

  void printDetails(){
    cout<<"The simple interest is: "<<simpleInterest()<<endl;
    }

};

int main(){
 si s;
 cout<<"Enter Principal: ";
 cin>>s.principal;
 cout<<"Enter rate: ";
 cin>>s.rate;
 cout<<"Enter time: ";
 cin>>s.time;
 s.printDetails();
 cout<<endl;
 return 0;
}

