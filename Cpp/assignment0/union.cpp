#include <iostream>
using namespace std;

struct Engine {
    int rpm;
    float oilTemp;
};

struct Brake {
    float pressure;
    float wearLevel;
};

struct Battery {
    float voltage;
    float chargeLevel;
};

union ErrorData {
    Engine engine;
    Brake brake;
    Battery battery;
};

int main() {
    ErrorData data;
    int choice;

    cout << "Select Error Type:\n";
    cout << "1. Engine\n2. Brake\n3. Battery\n";
    cout << "Enter choice: ";
    cin >> choice;

    switch (choice) {
        case 1:
            cout << "Enter RPM: ";
            cin >> data.engine.rpm;
            cout << "Enter Oil Temperature: ";
            cin >> data.engine.oilTemp;

            cout << "\n--- Engine Error Data ---\n";
            cout << "RPM: " << data.engine.rpm << endl;
            cout << "Oil Temperature: " << data.engine.oilTemp << endl;
            break;

        case 2:
            cout << "Enter Brake Pressure: ";
            cin >> data.brake.pressure;
            cout << "Enter Wear Level: ";
            cin >> data.brake.wearLevel;

            cout << "\n--- Brake Error Data ---\n";
            cout << "Pressure: " << data.brake.pressure << endl;
            cout << "Wear Level: " << data.brake.wearLevel << endl;
            break;

        case 3:
            cout << "Enter Battery Voltage: ";
            cin >> data.battery.voltage;
            cout << "Enter Charge Level: ";
            cin >> data.battery.chargeLevel;

            cout << "\n--- Battery Error Data ---\n";
            cout << "Voltage: " << data.battery.voltage << endl;
            cout << "Charge Level: " << data.battery.chargeLevel << endl;
            break;

        default:
            cout << "Invalid choice!";
    }

    return 0;
}