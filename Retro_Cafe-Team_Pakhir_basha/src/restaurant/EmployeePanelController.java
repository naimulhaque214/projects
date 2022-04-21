
package restaurant;

import conpkg.concls;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class EmployeePanelController implements Initializable {

    @FXML
    private TextField EmployeeID1;
    @FXML
    private TextField Designation;
    @FXML
    private TextField Salary;
    @FXML
    private DatePicker JoinDate;
    

    static ObservableList<Employee> emplist = FXCollections.observableArrayList();
    
  
    
    DBAction dbaction = new DBAction();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    
    
    //Employee Table Value Get And Insert Method
    @FXML
    private void AddEmployee(ActionEvent event) {
        
        try{
            int id = Integer.parseInt(EmployeeID1.getText());
            String designation = this.Designation.getText();
            Date Jdate = Date.valueOf(JoinDate.getValue());
            double salary = Double.parseDouble(Salary.getText());
            
            String i = EmployeeID1.getText();
            String s= Salary.getText();
            if(i.equals("") || designation.equals("") || Jdate.equals("") || s.equals("") )
            {
                JOptionPane.showMessageDialog(null, "Please fill up all field!");
                
            }else{
        
            
            //Create Employee Object to get Insert Value For Employee Table
            Employee employee = new Employee(id,designation,Jdate,salary);
            dbaction.InsertEmployee(employee);
            
            
            
            
            JOptionPane.showMessageDialog(null, "Congrats! Employee has been Added");
            //Clear All Field Text After Added
            EmployeeID1.clear();
            Designation.clear();
            Salary.clear();
            JoinDate.setValue(null);
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Wrong! Please Check All Information!");
        }
               
    }

    @FXML
    private void UpdateEmployee(ActionEvent event) throws SQLException {
        
            String i = EmployeeID1.getText();
            String s = Salary.getText();
            if(i.equals("") && s.equals(""))return;
        
            int id = Integer.parseInt(EmployeeID1.getText());
            double salary = Double.parseDouble(Salary.getText());
            
            String designation = this.Designation.getText();
            Date Jdate = Date.valueOf(JoinDate.getValue());
            if(Designation.equals("") && Jdate.equals(""))return;
            
            concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
            Statement statement = con.createStatement();
            
            String Query = "UPDATE employee SET Designation = '"+designation+"', Join_Date='"+Jdate+"', Salary = "+salary+" WHERE Employee_ID = "+id;
            
            statement.executeUpdate(Query);
            
            JOptionPane.showMessageDialog(null,"Congrats!! Employee has been Update!");
            
            EmployeeID1.clear();
            Designation.clear();
            Salary.clear();
            JoinDate.setValue(null);
        
        
    }

    @FXML
    private void Search1(ActionEvent event) throws SQLException {
                
        try{
        String Id = EmployeeID1.getText();
        if(Id.equals(""))return;
        
        concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
        Statement statement = con.createStatement();
        String Query = "SELECT  Designation,Join_Date,Salary FROM employee WHERE Employee_ID = "+Integer.parseInt(Id);
         
        ResultSet resultset = statement.executeQuery(Query);
         
         while(resultset.next())
         {
            String des = resultset.getString("Designation");
            String date = resultset.getDate("Join_Date").toString();
            double sal = resultset.getDouble("Salary");
            
            
            //Set Item in All Text Field
            Designation.setText(des);
            JoinDate.setValue(LocalDate.parse(date, DateTimeFormatter.ISO_DATE));
            Salary.setText(""+sal);
            
             
         }
         
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "Please Type Correct Employee ID");
        }
         
         
    }
  
}
