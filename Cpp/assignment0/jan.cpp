#include <iostream>
using namespace std;

bool isLeapYear(int year)
{
    if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
        return true;
    return false;
}

int main(){
    int year;
    cout << "Enter the year: ";
    cin >> year;
    string days[] = {
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    };
    int totalDays = 0;
    if(year>=1901){
    for (int i = 1901; i < year; i++)
    {
        if (isLeapYear(i))
            totalDays += 366;
        else
            totalDays += 365;
    }

    cout << "1st January " << year << " is "
         << days[totalDays % 7] << "." << endl;
    }

    else{
        for(int i=year; i<1901; i++){
             if (isLeapYear(i))
            totalDays += 366;
            else
            totalDays += 365;
        }
        cout << "1st January " << year << " is "
         << days[6-(totalDays % 7)] << "." << endl;
    }

    return 0;
}