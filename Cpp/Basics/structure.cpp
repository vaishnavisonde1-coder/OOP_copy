#include <iostream>
#include <string>
#include <vector>

using namespace std;

struct Student
{
    int id;
    string name;
    float marks[5];
    float totalmarks;
    string result;
};

void Grade(Student &s)
{
    s.totalmarks = 0;

    for (int j = 0; j < 5; j++)
    {
        s.totalmarks += s.marks[j];
    }

    if (s.totalmarks >= 200)
        s.result = "Passed";
    else
        s.result = "Failed";
}

int main()
{
    int number;
    cout << "Enter the number of students you want to enroll: ";
    cin >> number;

    vector<Student> s(number);

    for (int i = 0; i < number; i++)
    {
        cout << "\nDetails of Student " << i + 1 << endl;

        cout << "Enter ID number: ";
        cin >> s[i].id;

        cin.ignore();

        cout << "Enter name of student: ";
        getline(cin, s[i].name);

        cout << "Enter marks of 5 subjects (0-100):" << endl;

        for (int j = 0; j < 5; j++)
        {
            cin >> s[i].marks[j];

            while (s[i].marks[j] < 0 || s[i].marks[j] > 100)
            {
                cout << "Invalid marks! Enter again: ";
                cin >> s[i].marks[j];
            }
        }

        Grade(s[i]);
    }

    int iden;
    cout << "\nEnter ID of student to check details: ";
    cin >> iden;

    bool found = false;

    for (int i = 0; i < number; i++)
    {
        if (s[i].id == iden)
        {
            found = true;

            cout << "\n----- Student Record -----" << endl;
            cout << "Name          : " << s[i].name << endl;
            cout << "ID            : " << s[i].id << endl;

            cout << "Marks         : ";
            for (int j = 0; j < 5; j++)
            {
                cout << s[i].marks[j] << " ";
            }

            cout << "\nTotal Marks   : " << s[i].totalmarks;
            cout << "\nPercentage    : " << s[i].totalmarks / 5 << "%";
            cout << "\nResult        : " << s[i].result << endl;

            break;
        }
    }

    if (!found)
    {
        cout << "\nStudent is not enrolled!!" << endl;
    }

    return 0;
}