/*Create a class Temperature.
•	Input temperature in Celsius. 
•	Convert it to Fahrenheit. 
Formula: Fahrenheit = (C × 9/5) + 32
*/

#include<iostream>
using namespace std;

class temperature
{

public:
    int temp;

    float convertToFahrenheit(){
        return (((float)temp*9/5)+32);
    }

    void print(){
        cout<<"The temprerature in Fahrenheit: "<<convertToFahrenheit()<<endl;
    }
};

int main(){
    temperature t;
    
    cout<<"Enter the temperature in Celsius: ";
    cin>>t.temp;
    
    t.print();
    return 0;
}
