/*Create a class Employee with:
•	Employee ID 
•	Employee Name 
•	Salary 
Display the employee details.
*/

#include<iostream>
#include<string.h>
using namespace std;

class employee
{
private:
   int salary;
public:
    string name;
    int id ;
    void getInfo(string n, int identity){
        name = n;
        id = identity;
    }
    void getSalary(int s){
        salary = s;
    }
    void printDetails(){
        cout<<"ID:\t"<<id<<endl;
        cout<<"NAME: "<<name<<endl;
        cout<<"Your salary of amount "<<salary<<" credited to your account.\n";
    }
};


int main(){
    employee e1, e2;
    e1.getInfo("Vaishnavi Sonde", 25);
    cout<<"Employee details\n";
    e1.getSalary(15000);
    e1.printDetails();
    e2.getInfo("Gunjan Chaware", 15);
    cout<<"\n";
    e2.getSalary(10000);
    e2.printDetails();

    return 0;
}