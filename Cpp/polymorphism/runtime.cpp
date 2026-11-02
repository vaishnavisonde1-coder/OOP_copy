#include <iostream>
#include <string>
using namespace std;

class Media {
protected:
    string title;
    double price;

public:
    Media(string t, double p) {
        title = t;
        price = p;
    }

    virtual void display() {
        cout << "Title: " << title << endl;
        cout << "Price: " << price << endl;
    }

    virtual ~Media() {
    }
};


class Book : public Media {
private:
    int page_count;

public:
    Book(string t, double p, int pages)
        : Media(t, p) {
        page_count = pages;
    }

    void display() override {
        cout << "\n--- BOOK DETAILS ---" << endl;
        cout << "Title: " << title << endl;
        cout << "Price: " << price << endl;
        cout << "Page Count: " << page_count << endl;
    }
};


class Tape : public Media {
private:
    double play_time;

public:
    Tape(string t, double p, double time)
        : Media(t, p) {
        play_time = time;
    }

    void display() override {
        cout << "\n--- TAPE DETAILS ---" << endl;
        cout << "Title: " << title << endl;
        cout << "Price: " << price << endl;
        cout << "Play Time: " << play_time << " minutes" << endl;
    }
};


int main() {

    string title;
    double price;
    int pages;
    double playTime;

    cout << "Enter Book Details" << endl;

    cout << "Enter title: ";
    getline(cin, title);

    cout << "Enter price: ";
    cin >> price;

    cout << "Enter page count: ";
    cin >> pages;

    Book book(title, price, pages);
    cin.ignore();

    cout << "\nEnter Tape Details" << endl;

    cout << "Enter title: ";
    getline(cin, title);

    cout << "Enter price: ";
    cin >> price;

    cout << "Enter play time (in minutes): ";
    cin >> playTime;

    Tape tape(title, price, playTime);
    Media *ptr;

    cout << "\n-MEDIA DETAILS" << endl;

    ptr = &book;
    ptr->display();

    ptr = &tape;
    ptr->display();

    return 0;
}