/*A library wants to computerize its book-issuing counter. Every book in the system must have a title, author, and ISBN. However, newly acquired books that haven't been catalogued yet may be entered with just a title, in which case the author should default to "Unknown" and the ISBN should default to "NOT_ASSIGNED".
Design the Book class such that:
•	A librarian can create a book object by supplying all three details.
•	A librarian can also create a book object by supplying only the title.
*/
#include<iostream>
using namespace std;

class Book{
    public:
      string title;
      string author;
      string ISBN;
 
      Book(string t, string a, string num){
             cout<<"Details of the book is: \n";
            cout<<"Title: "<<t;
            cout<<"\nAuthor: "<<a<<"\nISBN: "<<num<<"\n";
      }
      Book(string t){
          cout<<"Details of the book is: \n";
            cout<<"Title: "<<t;
            cout<<"\nAuthor: Unknown \nISBN: NOT_ASSIGNED\n";
      }
 
};

int main(){
    string t;
    string a;
    string num;
    char ans;
 
    cout<<"Enter title of the book: ";
    getline(cin, t);
 
    cout<<"Do you know the author and ISBN number(y/n): ";
    cin>>ans;
    if(ans == 'Y' || ans == 'y'){
        cout<<"Enter author's name: ";
        cin.ignore();
        getline(cin, a);

        cout<<"Enter the ISBN number: ";
        cin>>num;

        Book b1(t, a, num);
    }
    else if(ans=='N' || ans=='n'){
        Book b2(t);
    }
    else{
        cout<<"Invalid choice..";
    }
    return 0;
}

