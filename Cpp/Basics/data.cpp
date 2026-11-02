#include <iostream>
#include <vector>
using namespace std;

union SensorData
{
    struct
    {
        float temp1;
        float temp2;
    } thermal;

    struct
    {
        float press;
        int altitude;
    } pressure;

    float velocity[3];
};

struct TelemetryPacket
{
    int packetID;
    int type; // 1-Thermal, 2-Pressure, 3-Velocity
    SensorData data;
};

int main()
{
    int n;

    cout << "Enter number of telemetry packets: ";
    cin >> n;

    vector<TelemetryPacket> packet(n);

    for (int i = 0; i < n; i++)
    {
        cout << "\nPacket " << i + 1 << endl;

        cout << "Enter Packet ID: ";
        cin >> packet[i].packetID;

        cout << "Select Type\n";
        cout << "1. Thermal\n";
        cout << "2. Pressure\n";
        cout << "3. Velocity\n";
        cout << "Choice: ";
        cin >> packet[i].type;

        switch (packet[i].type)
        {
        case 1:
            cout << "Enter two thermal readings: ";
            cin >> packet[i].data.thermal.temp1
                >> packet[i].data.thermal.temp2;
            break;

        case 2:
            cout << "Enter pressure reading: ";
            cin >> packet[i].data.pressure.press;

            cout << "Enter altitude: ";
            cin >> packet[i].data.pressure.altitude;
            break;

        case 3:
            cout << "Enter three velocity readings: ";
            for (int j = 0; j < 3; j++)
                cin >> packet[i].data.velocity[j];
            break;

        default:
            cout << "Invalid Type!\n";
            i--;
        }
    }

    cout << "\n========== TELEMETRY DATA ==========\n";

    for (int i = 0; i < n; i++)
    {
        cout << "\nPacket ID: " << packet[i].packetID << endl;

        switch (packet[i].type)
        {
        case 1:
            cout << "Type : Thermal" << endl;
            cout << "Reading 1 : " << packet[i].data.thermal.temp1 << endl;
            cout << "Reading 2 : " << packet[i].data.thermal.temp2 << endl;
            break;

        case 2:
            cout << "Type : Pressure" << endl;
            cout << "Pressure : " << packet[i].data.pressure.press << endl;
            cout << "Altitude : " << packet[i].data.pressure.altitude << endl;
            break;

        case 3:
            cout << "Type : Velocity" << endl;
            cout << "Velocity Readings : ";
            for (int j = 0; j < 3; j++)
                cout << packet[i].data.velocity[j] << " ";
            cout << endl;
            break;
        }
    }

    return 0;
}