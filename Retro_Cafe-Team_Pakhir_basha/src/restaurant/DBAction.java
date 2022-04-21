
package restaurant;

import conpkg.concls;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;

public class DBAction {
    void InsertEmployee(Employee employee) throws SQLException
    {
        concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
        Statement state = con.createStatement();
        
        //Query for insert Employee
        String query = "INSERT INTO employee(Employee_ID,Designation,Join_Date,Salary) VALUES("+employee.EmployeeID+",'"+employee.Designation+"','"+employee.JoinDate+"',"+employee.Salary+")";
        state.executeUpdate(query);
        con.close();
        state.close();
    }
      
    
    
    //Create Method for get All Employe from employee table
    ObservableList<Employee> getAllEmployee() throws SQLException{
        
        
        ObservableList<Employee> employelist = FXCollections.observableArrayList();
        
        concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
        String query = "SELECT Employee_ID,Designation,Join_Date,Salary FROM employee";
        Statement statement = con.createStatement();
        ResultSet resultset = statement.executeQuery(query);
        
        while(resultset.next())
        {
            //Get data from Database
            int id = resultset.getInt("Employee_ID");
            String des = resultset.getString("Designation");
            Date date = resultset.getDate("Join_Date");
            double sal = resultset.getDouble("Salary");
            
            
            
            //Initialize data in Employee object
            Employee empoyee  = new Employee(id,des,date,sal);            
            
            employelist.add(empoyee);
            
        }   
        
        return employelist;        
        
        
    }

     //Delete Employee
     
     void DeleteEmployes(ObservableList<Employee> SelectedEmployes) throws SQLException
     {
         concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
         Statement statement = con.createStatement();
         
         for(Employee employee : SelectedEmployes)
         {
            String Query = "DELETE FROM employee WHERE Employee_ID = "+employee.getEmployeeID();
            statement.executeUpdate(Query);
         }
         con.close();
         statement.close();
     }
     
     
     
     //Srach Method for Employee Table
     ObservableList<Employee> SearchEmployee(int EmployeeId) throws SQLException{
         
         
         ObservableList<Employee> list = FXCollections.observableArrayList();
         
         concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
         Statement statement = con.createStatement();
         String Query = "SELECT Employee_ID, Designation,Join_Date,Salary FROM employee WHERE Employee_ID = "+EmployeeId;
         
         ResultSet resultset = statement.executeQuery(Query);
         
         while(resultset.next())
         {
             int id = resultset.getInt("Employee_ID");
            String des = resultset.getString("Designation");
            Date date = resultset.getDate("Join_Date");
            double sal = resultset.getDouble("Salary");
            
            
            
            //Initialize data in Employee object
            Employee empoyee  = new Employee(id,des,date,sal);            
            
            list.add(empoyee);
             
         }
         return list;
     }   
     
     
      //List For Country
     ObservableList<Floor> getAllTable() throws SQLException{
         
         
         ObservableList<Floor> list = FXCollections.observableArrayList();         
         
         concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
         Statement statement = con.createStatement();
         
         String Query = "SELECT Table_Id, Status FROM floor1 WHERE Status = 'UnBooked'";
         
         ResultSet resultset = statement.executeQuery(Query);
         
         while(resultset.next())
         {
             int id = resultset.getInt("Table_Id");
             String status = resultset.getString("Status");
             
             Floor floor = new Floor(id,status);
             list.add(floor);             
         }
         return list;
     }
}
