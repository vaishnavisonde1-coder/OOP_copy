/*Problem Statement: Design Flight , Hotel , and TripPackage classes where TripPackage contains one object of each as members, all initialized together via constructor chaining, and destroyed in the correct reverse order upon cancellation. Requirements: Flight class with flight number and departure time. Hotel class with hotel name and number of nights. TripPackage with both as member objects, initialized via initializer list, plus its own booking ID. Demonstrate booking and cancelling (destruction) of one full package*/

#include <iostream>
#include <string>
using namespace std;

// Base class
class TravelComponent {
protected:
    string componentType;

public:
    TravelComponent(string type)
        : componentType(type) {
        cout << componentType << " component created" << endl;
    }

    virtual ~TravelComponent() {
        cout << componentType << " component destroyed" << endl;
    }
};

// Derived class - Flight
class Flight : public TravelComponent {
private:
    string flightNumber;
    string departureTime;

public:
    Flight(string fNo, string time)
        : TravelComponent("Flight"),
          flightNumber(fNo),
          departureTime(time) {
        cout << "Flight created: " << flightNumber << endl;
    }

    ~Flight() {
        cout << "Flight destroyed: " << flightNumber << endl;
    }

    void displayFlight() {
        cout << "Flight Number: " << flightNumber << endl;
        cout << "Departure Time: " << departureTime << endl;
    }
};

// Derived class - Hotel
class Hotel : public TravelComponent {
private:
    string hotelName;
    int nights;

public:
    Hotel(string name, int n)
        : TravelComponent("Hotel"),
          hotelName(name),
          nights(n) {
        cout << "Hotel created: " << hotelName << endl;
    }

    ~Hotel() {
        cout << "Hotel destroyed: " << hotelName << endl;
    }

    void displayHotel() {
        cout << "Hotel Name: " << hotelName << endl;
        cout << "Number of Nights: " << nights << endl;
    }
};

// TripPackage contains Flight and Hotel objects
class TripPackage {
private:
    int bookingId;
    Flight flight;
    Hotel hotel;

public:
    // Initializer list
    TripPackage(int id, string fNo, string time,
                string hName, int n)
        : bookingId(id),
          flight(fNo, time),
          hotel(hName, n) {
        cout << "Trip Package created: " << bookingId << endl;
    }

    ~TripPackage() {
        cout << "Trip Package cancelled: " << bookingId << endl;
    }

    void displayPackage() {
        cout << "\nBooking ID: " << bookingId << endl;

        flight.displayFlight();
        hotel.displayHotel();
    }
};

int main() {
    {
        TripPackage trip(501, "AI202", "10:30 AM",
                         "Taj Hotel", 3);

        cout << "\n--- Booking Details ---" << endl;
        trip.displayPackage();

        cout << "\n--- Cancelling Trip ---" << endl;
    }

    cout << "\nAll objects destroyed successfully." << endl;

    return 0;
}