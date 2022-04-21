
package restaurant;

import java.sql.Date;

public class Employee {

public int EmployeeID;
public String Designation;
public Date JoinDate;
public double Salary;

    public Employee() {
    }

    public Employee(int EmployeeID, String Designation, Date JoinDate, double Salary) {
        this.EmployeeID = EmployeeID;
        this.Designation = Designation;
        this.JoinDate = JoinDate;
        this.Salary = Salary;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public String getDesignation() {
        return Designation;
    }

    public Date getJoinDate() {
        return JoinDate;
    }

    public double getSalary() {
        return Salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "EmployeeID=" + EmployeeID + ", Designation=" + Designation + ", JoinDate=" + JoinDate + ", Salary=" + Salary + '}';
    }

   
    
}
