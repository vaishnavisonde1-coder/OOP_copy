/*Create a class Book with:
•	Book Name 
•	Author Name 
•	Price 
Display the book details.
*/

#include<iostream>
using namespace std;

class Book
{
public:
  string bookName, authorName;
  int price;

  void getDetails(string book, string author, int p){
    bookName = book;
    authorName = author;
    price = p;
  }
  void printDetails(){
    cout<<"Book: "<<bookName<<endl;
    cout<<"Author: "<<authorName<<endl;
    cout<<"Price: "<<price<<endl;
  }
};


int main(){
    Book b1, b2;
    b1.getDetails("GenZ", "CJP", 500);
    b2.getDetails("Shamchi Aai","Sane Guruji", 600);
    cout<<"The book details are as follows: \n";
    b1.printDetails();
    b2.printDetails();
    return 0;
}