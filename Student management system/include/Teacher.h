#ifndef TEACHER_H
#define TEACHER_H
#include "Student.h"
#include <bits/stdc++.h>
#include <fstream>
#include <iomanip>
#include"User.h"
using namespace std;

class Teacher : public User
{
public:
    char courses[50];
    int t_course;
};

class Teacher_functionality
{
    Teacher t;
    Student stude;
    fstream tea, temp, marks, temp1;
    string x[10], x1[10];

    void append(Teacher t);


    void display();


    void erasee();

    void see_assigned1();
    void enter_m();
    char choice;

public:
    Teacher_functionality(){}
    Teacher_functionality(Teacher_functionality &tf){}

    void add_t()
    {
        this->append(t);
        cout << " Do u want to see it ? (y/n) ";
        cin >> choice;
        if (choice == 'Y' || choice == 'y')
        {
            this->display();
            system("pause");
        }
    }
    void show_d()
    {
        this->display();
        system("pause");
    }
    void del_t()
    {
        cout << " Do u want to see the list of teachers ? (y/n) ";
        cin >> choice;
        if (choice == 'Y' || choice == 'y')
        {
            this->display();
            system("pause");
        }

        this->erasee();
        cout << " Do u want to see the changes ? (y/n) ";
        cin >> choice;
        if (choice == 'Y' || choice == 'y')
        {
            this->display();
            system("pause");
        }
    }
    void see_assigned_t()
    {
        this->see_assigned1();
        system("pause");
    }
    void enter_marks()
    {
        this->enter_m();
        system("pause");
    }
};

#endif // TEACHER_H
