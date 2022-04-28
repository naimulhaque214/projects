#ifndef ADMIN_H
#define ADMIN_H
#include"Student.h"
#include"User.h"
#include<bits/stdc++.h>
#include<fstream>
#include<iomanip>
using namespace std;

class Admin:public User
{
protected:
    fstream stu,temp,marks,temp1,adf,req;
    string x[10],x1[10];
    void append(Student d);
    void display();

    void erase_std();

    void add_course();



    void add_admin();

    char choice;
    Student d;
public:
    void show_d()
    {
        this->display();
        system("pause");
    }
    void add()
    {
        this->append(d);
        cout << " Do u want to see it ? (y/n) ";
        cin >> choice;
        if (choice == 'Y' || choice == 'y')
        {
            this->display();
            system("pause");
        }
    }
    void del()
    {
        cout << " Do u want to see the list of students ? (y/n) ";
        cin >> choice;
        if (choice == 'Y' || choice == 'y')
        {
            this->display();
            system("pause");
        }

        this->erase_std();

        cout << " Do u want to see the changes ? (y/n) ";
        cin >> choice;
        if (choice == 'Y' || choice == 'y')
        {
            this->display();
            system("pause");
        }
    }
    void addc()
    {
        this->add_course();
        system("pause");
    }
    void add_admin1()
    {
        this->add_admin();
        system("pause");
    }

};

#endif // ADMIN_H
