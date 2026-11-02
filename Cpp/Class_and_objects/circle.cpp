/*Create a class Circle.
•	Input radius. 
•	Calculate and display the area. 
Formula: Area = 3.14 × r × r
*/

#include<iostream>
using namespace std;

class circle
{

public:
    int radius;
    float areaOfCircle(){
        return 3.14 * radius*radius;
    }
};

int main(){
    
    circle c;
    cout<<"Enter radius of the circle: ";
    cin>>c.radius;
    cout<<"The area of the circle is: "<<c.areaOfCircle();
    return 0;
}