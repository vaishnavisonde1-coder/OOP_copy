/*Create a class Student.
•	Input marks of 3 subjects. 
•	Calculate: 
o	Total Marks 
o	Average Marks 
*/

#include<iostream>
using namespace std;

class student
{

public:
   int marks[3];

   
   int totalMarks(){
        return (marks[0]+marks[1]+marks[2]);
   }
   float averageMarks(){
    return (float)(marks[0]+marks[1]+marks[2])/3;
   }

   void printDetails(){
    cout<<"Total marks obtained: "<<totalMarks();
    cout<<"\nThe average marks of the student is: "<<averageMarks();
    cout<<endl<<endl;
    
   }

};

int main(){
  student s;
  cout<<"Enter the marks of all three subjects: ";
  for(int i=0; i<3; i++){
    cin>>s.marks[i];
  }

  cout<<"Marks of student: \n";
  s.printDetails();

  return 0;

}
