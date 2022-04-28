//=================================================  HEADER SECTION
#include<bits/stdc++.h>
#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
#include <conio.h>
#include <stdlib.h>
#include"Admin.h"
#include"Teacher.h"
#include"password.h"
#include "Menu.h"

//================================================= DEFINING STANDARD NAMESPACE
using namespace std;


int main()
{
	string n;
	Teacher_functionality te;
	Password d;
	Admin ad;

	Student s;
	dis();

top1:							// ----> defining label for first screen
	dis1();
	cin >> n;
	if (n == "1")
	{	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		// ADMIN MODE
		if (d.isLogin() == 1)
		{
		top2:
			system("cls");
			dis2();
			cin >> n;
			if (n == "1")
			{
				ad.add();
				goto top2;
			}
			if (n == "2")
			{
				ad.del();
				goto top2;
			}
			if (n == "3")
			{
				te.add_t();
				goto top2;
			}
			if (n == "4")
			{
				te.del_t();
				goto top2;
			}
			if (n == "5")
			{
				ad.add_admin1();
				goto top2;
			}
			if (n == "6")
			{
				ad.show_d();
				goto top2;
			}
			if (n == "7")
			{
				te.show_d();
				goto top2;
			}

			if (n == "8")
			{
				system("cls");
				goto top1;
			}
			if (n == "9")
			{
				goto exit;
			}
			else
			{
				cout << "\n Invalid Entry. Please try again. \n\n";
				system("pause");
				goto top2;
			}
		}
		else
		{
			if (d.isLoginTry() == 1)
			{
				goto top2;
			}
		}
	}

	if (n == "2")
	{
		if (d.isLogin1() == 1)
		{
		top3:
			system("cls");
			dis3();
			cin >> n;
			if (n == "1")
			{
				s.see_assigned();
				goto top3;
			}

			if (n == "2")
			{
				s.showc();
				goto top3;
			}

			if (n == "3")
			{
				system("cls");
				goto top1;
			}
			if (n == "4")
			{
				goto exit;
			}
			else
			{
				cout << "\n Invalid Entry. Please try again. \n\n";
				system("pause");
				goto top3;
			}
		}
		else
		{
			if (d.isLoginTry1() == 1)
			{
				goto top3;
			}
		}
	}

	if (n == "3")
	{
		if (d.isLogin2() == 1)
		{
		top4:
			system("cls");
			dis4();
			cin >> n;
			if (n == "1")
			{
				te.enter_marks();
				goto top4;
			}
			if (n == "2")
			{
				te.see_assigned_t();
				goto top4;
			}
			if (n == "3")
			{
				system("cls");
				goto top1;
			}
			if (n == "4")
			{
				goto exit;
			}
			else
			{
				cout << "\n Invalid Entry. Please try again. \n\n";
				system("pause");
				goto top4;
			}
		}
		else
		{
			if (d.isLoginTry2() == 1)
			{
				goto top4;
			}
		}

	}

	if (n == "4")
	{
		goto exit;
	}
	else
	{
		cout << "\n Invalid Entry. Please try again. \n\n";
		system("pause");
		system("cls");
		goto top1;
	}

exit:
	system("pause");
}

