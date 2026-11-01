#include <iostream>
using namespace std;

class Shape {
protected:
    double dimension1;
    double dimension2;

public:
    void get_data() {
        cout << "Enter dimension 1: ";
        cin >> dimension1;

        cout << "Enter dimension 2: ";
        cin >> dimension2;
    }

    virtual void display_area() = 0;
};


class Triangle : public Shape {
public:
    void display_area() override {
        double area = 0.5 * dimension1 * dimension2;

        cout << "Area of Triangle: " << area << endl;
    }
};


class Rectangle : public Shape {
public:
    void display_area() override {
        double area = dimension1 * dimension2;

        cout << "Area of Rectangle: " << area << endl;
    }
};


int main() {

    Triangle triangle;
    Rectangle rectangle;

    Shape *ptr;

    cout << "-TRIANGLE-" << endl;
    triangle.get_data();

    ptr = &triangle;
    ptr->display_area();


    cout << "\n -RECTANGLE-" << endl;
    rectangle.get_data();

    ptr = &rectangle;
    ptr->display_area();

    return 0;
}