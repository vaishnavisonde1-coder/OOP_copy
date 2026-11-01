/*Problem Statement: Design Flight , Hotel , and TripPackage classes where TripPackage contains one 
object of each as members, all initialized together via constructor chaining, and destroyed in the
 correct reverse order upon cancellation. 
Requirements: Flight class with flight number and departure time. Hotel class with hotel name and 
number of nights. TripPackage with both as member objects, initialized via initializer list, plus its 
own booking ID. Demonstrate booking and cancelling (destruction) of one full package*/


#include <iostream>
#include <string>
using namespace std;

class Flight {
public:
    string flightNumber;
    string time;

    Flight(string f, string t) {
        flightNumber = f;
        time = t;
    }

    void displayFlight() {
        cout << "\tFlight Details:" << endl;
        cout << "\t\tFlight Number: " << flightNumber << endl;
        cout << "\t\tDeparture Time: " << time << endl;
    }

    ~Flight() {
        cout << "\tFlight details destroyed." << endl;
    }
};

class Hotel {
public:
    string hotelName;
    int stayDays;

    Hotel(string h, int s) {
        hotelName = h;
        stayDays = s;
    }

    void displayHotel() {
        cout << "\tHotel Details:" << endl;
        cout << "\t\tHotel Name: " << hotelName << endl;
        cout << "\t\tStay Period: " << stayDays << " days" << endl;
    }

    ~Hotel() {
        cout << "\tHotel details destroyed." << endl;
    }
};

class TripPackage : public Flight, public Hotel {
public:
    int bookingID;

    TripPackage(int b, int s, string h, string f, string t)
        : Flight(f, t), Hotel(h, s) {
        
        bookingID = b;

        cout << "\nBooking Details:" << endl;
        cout << "\tBooking ID: " << bookingID << endl;

        displayFlight();
        displayHotel();
    }

    void cancelTrip(int book) {
        if (book == bookingID) {
            cout << "\nCancelling Trip..." << endl;
            cout << "\tBooking ID: " << bookingID << endl;
            displayFlight();
            displayHotel();
        }
        else {
            cout << "\nInvalid Booking ID!" << endl;
        }
    }

    ~TripPackage() {
        cout << "\nTrip Package destroyed." << endl;
        cout << "Thanks for using our service! Visit Again..." << endl;
    }
};

int main() {

    char choice;

    cout << "Do you want to book a flight (b) or cancel flight (c)? ";
    cin >> choice;

    if (choice == 'b' || choice == 'B') {

        int b, s;
        string h, f, t;

        cout << "Enter Booking ID: ";
        cin >> b;

        cout << "Enter the number of days you are staying: ";
        cin >> s;

        cin.ignore();

        cout << "Enter hotel name you want to stay: ";
        getline(cin, h);

        cout << "Enter flight number: ";
        getline(cin, f);

        cout << "Enter the time of departure: ";
        getline(cin, t);

        {
            TripPackage t1(b, s, h, f, t);

            char choice2;

            cout << "\nDo you want to cancel the trip? (y/n): ";
            cin >> choice2;

            if (choice2 == 'Y' || choice2 == 'y') {
                t1.cancelTrip(b);
            }
            else {
                cout << "\nTrip remains booked." << endl;
            }
        }
        

    }
    else if (choice == 'c' || choice == 'C') {

        cout << "\nCancellation requires an existing booking." << endl;

    }
    else {
        cout << "\nInvalid choice entered!" << endl;
    }

    return 0;
}