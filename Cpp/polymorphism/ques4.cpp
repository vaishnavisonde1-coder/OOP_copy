#include <iostream>
using namespace std;

class SmartDevice {
public:
    virtual void turn_on() = 0;
    virtual void turn_off() = 0;
    virtual void get_status() = 0;

    virtual ~SmartDevice() {
    }
};


class SmartLight : public SmartDevice {
private:
    bool status;

public:
    SmartLight() {
        status = false;
    }

    void turn_on() override {
        status = true;
        cout << "Smart Light turned ON." << endl;
    }

    void turn_off() override {
        status = false;
        cout << "Smart Light turned OFF." << endl;
    }

    void get_status() override {
        cout << "Smart Light Status: "
             << (status ? "ON" : "OFF") << endl;
    }
};


class Thermostat : public SmartDevice {
private:
    bool status;

public:
    Thermostat() {
        status = false;
    }

    void turn_on() override {
        status = true;
        cout << "Thermostat turned ON." << endl;
    }

    void turn_off() override {
        status = false;
        cout << "Thermostat turned OFF." << endl;
    }

    void get_status() override {
        cout << "Thermostat Status: "
             << (status ? "ON" : "OFF") << endl;
    }
};


class SmartLock : public SmartDevice {
private:
    bool status;

public:
    SmartLock() {
        status = false;
    }

    void turn_on() override {
        status = true;
        cout << "Smart Lock is LOCKED." << endl;
    }

    void turn_off() override {
        status = false;
        cout << "Smart Lock is UNLOCKED." << endl;
    }

    void get_status() override {
        cout << "Smart Lock Status: "
             << (status ? "LOCKED" : "UNLOCKED") << endl;
    }
};


class CentralHub {
private:
    SmartDevice* devices[3];
    int deviceCount;

public:
    CentralHub() {
        deviceCount = 0;
    }

    void addDevice(SmartDevice* device) {
        if (deviceCount < 3) {
            devices[deviceCount] = device;
            deviceCount++;
        }
    }

    void morningRoutine() {
        cout << "\n===== MORNING ROUTINE =====" << endl;

        for (int i = 0; i < deviceCount; i++) {
            devices[i]->turn_on();
        }
    }

    void eveningRoutine() {
        cout << "\n===== EVENING ROUTINE =====" << endl;

        for (int i = 0; i < deviceCount; i++) {
            devices[i]->turn_off();
        }
    }

    void displayAllStatus() {
        cout << "\n===== DEVICE STATUS =====" << endl;

        for (int i = 0; i < deviceCount; i++) {
            devices[i]->get_status();
        }
    }
};


int main() {

    SmartLight light;
    Thermostat thermostat;
    SmartLock lock;

    CentralHub hub;

    // Connecting devices to Central Hub
    hub.addDevice(&light);
    hub.addDevice(&thermostat);
    hub.addDevice(&lock);

    cout << "===== SMART HOME SYSTEM =====" << endl;

    // Morning routine
    hub.morningRoutine();

    hub.displayAllStatus();

    // Evening routine
    hub.eveningRoutine();

    hub.displayAllStatus();

    return 0;
}