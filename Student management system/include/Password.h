#ifndef PASSWORD_H
#define PASSWORD_H
#include<bits/stdc++.h>
#include<fstream>
#include<iomanip>
using namespace std;

class Password
{
    private:
    int ad_id;
	char ad_name[30];				// ----> admin names
	char ad_pass[30];				// ----> admin passwords
	string t_name;									// ----> strings to hold input credentials
	string t_pw;
	string try_top;
	fstream admin;
	ifstream stu,marks;
	ofstream mar;

	bool login;
	bool log;
public:
	bool isLogin();											// ----> Function for authenticating the admin login through saved credentials in a file.
																	// ----> returning the login value to the function

	bool isLoginTry();


	bool isLogin1();											// ----> Function for authenticating the admin login through saved credentials in a file.

																	// ----> returning the login value to the function

	bool isLoginTry1();





	bool isLogin2();											// ----> Function for authenticating the admin login through saved credentials in a file.

																	// ----> returning the login value to the function

	bool isLoginTry2();
};

#endif // PASSWORD_H
