#ifndef STUDENT_H
#define STUDENT_H
#include"User.h"
#include<bits/stdc++.h>
using namespace std;
class Student : public User
{
public:
    int batch;
    char degree[10];
    int t_course;
    char courses[50];
    int sess;
    int mid;
    int final_m;
    string x1[10],x[10];
    void see_assigned()
    {
        this->see_assigned1();
        system("pause");

    }

   void showc()
    {
        this->show();
        system("pause");
    }
    fstream marks;
    Student(Student &s){}
    Student(){}
protected:
    void show();
    void see_assigned1();

};

#endif // STUDENT_H
