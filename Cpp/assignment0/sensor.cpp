#include <iostream>
#include <vector>
#include <string>
#include <iomanip>

using namespace std;

struct Sensor
{
    int sensorID;
    string zone;
    string timestamp;
    float reading;
};

int main()
{
    int n;

    cout << "Enter the number of sensors: ";
    cin >> n;

    vector<Sensor> sensors(n);

    for (int i = 0; i < n; i++)
    {
        cout << "\nEnter details of Sensor " << i + 1 << endl;

        cout << "Sensor ID: ";
        cin >> sensors[i].sensorID;

        cin.ignore();

        cout << "Zone (North/South/East/West): ";
        getline(cin, sensors[i].zone);

        cout << "Timestamp: ";
        getline(cin, sensors[i].timestamp);

        cout << "Sensor Reading: ";
        cin >> sensors[i].reading;
    }

    cout << "\n---- SENSOR DETAILS ----\n";

    for (int i = 0; i < n; i++)
    {
        cout << "\nSensor " << i + 1 << endl;
        cout << "Sensor ID : " << sensors[i].sensorID << endl;
        cout << "Zone      : " << sensors[i].zone << endl;
        cout << "Timestamp : " << sensors[i].timestamp << endl;
        cout << "Reading   : " << sensors[i].reading << endl;
    }

    vector<string> zones = {"North", "South", "East", "West"};

    cout << "\n---- ZONE-WISE AGGREGATION ----\n";

    for (int i = 0; i < zones.size(); i++)
    {
        float total = 0;
        int count = 0;

        for (int j = 0; j < n; j++)
        {
            if (sensors[j].zone == zones[i])
            {
                total += sensors[j].reading;
                count++;
            }
        }

        cout << zones[i] << " Zone : ";

        if (count > 0)
        {
            cout << "Sensors = " << count
                 << ", Average Reading = "
                 << fixed << setprecision(2)
                 << total / count << endl;
        }
        else
        {
            cout << "No Sensors" << endl;
        }
    }

    return 0;
}