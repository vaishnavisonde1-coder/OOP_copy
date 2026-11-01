/*Design a class for a hostel room allotment record with constructor overloading — one version accepting only a room number (for provisional allotment) and another accepting both room number and student name (for confirmed allotment).*/

#include<iostream>
using namespace std;

class hostel{
    public:
     int roomNo ;
     string name = "";
    hostel(int rn){
        roomNo = rn;
    }
    hostel(int rn, string student){
        roomNo = rn;
        name = student;
    }
    void displayAllotment(){
        if(name==""){
            cout<<"The provisional allotment is in room no. "<<roomNo;
        }
        else{
            cout<< name<< " is alloted the room: "<<roomNo;
        }
    }
};

int main(){
    int roomNo;
    cout<<"Enter the room number alloted: ";
    cin>>roomNo;
    char choice;
    cout<<"Whether the candidate has confirmed his/her seat?(y/n): ";
    cin>>choice;
    cin.ignore();
    string name;
    if(choice=='y'||choice=='Y'){
        cout<<"Please Enter the candidate name: ";
        getline(cin, name);
        hostel d2(roomNo, name);
        d2.displayAllotment();
    }
    else if(choice=='n'||choice=='N'){
    hostel d1(roomNo);
    d1.displayAllotment();
    }
    else{
    cout<<"Invalid choice.";
    }
    return 0;
}