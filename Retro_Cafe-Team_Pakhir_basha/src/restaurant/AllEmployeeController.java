
package restaurant;

import conpkg.concls;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

public class AllEmployeeController implements Initializable {

    @FXML
    private TableColumn<Employee, Integer> EmployeeID;
    @FXML
    private TableColumn<Employee, String> Designation;
    @FXML
    private TableColumn<Employee, Date> JoinDate;
    @FXML
    private TableColumn<Employee, Double> Salary;
    @FXML
    private TableView<Employee> EmployeeTable;
    @FXML
    private TextField search1;

    /**
     * Initializes the controller class.
     */
    
    
    concls connectionClass=new concls();
    Connection con=connectionClass.getConnection();
    static ObservableList<Employee> list1 = FXCollections.observableArrayList();
    static ObservableList<Employee> list2 = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //At First clear Value from JAVA FX Table
        //EmployeePanelController.emplist2.clear();
        EmployeePanelController.emplist.clear();
        
        
        //This Function Only For Employee Table
        //Create Multiple Row Selected option
        EmployeeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //EmployeeDetailsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        //Database Action
        DBAction dbaction = new DBAction();  
               
        
        try {
            EmployeePanelController.emplist = dbaction.getAllEmployee();
        } catch (SQLException ex) {
            Logger.getLogger(AllEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        EmployeeID.setCellValueFactory(new PropertyValueFactory<>("EmployeeID"));
        Designation.setCellValueFactory(new PropertyValueFactory<>("Designation"));
        JoinDate.setCellValueFactory(new PropertyValueFactory<>("JoinDate"));
        Salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        
        
        EmployeeTable.setItems(EmployeePanelController.emplist);  
    }    



    @FXML
    private void DeleteEmployee(ActionEvent event) throws SQLException {
        //Create Observable List for get Selected item        
        ObservableList<Employee> SelectedEmployee = FXCollections.observableArrayList();
        SelectedEmployee = EmployeeTable.getSelectionModel().getSelectedItems();
        
        //Remove Selected Item From Database
        DBAction dbaction = new DBAction();
        dbaction.DeleteEmployes(SelectedEmployee);
        
        //Remove Selected Item from Javafx Table
        EmployeePanelController.emplist.removeAll(SelectedEmployee);
        list1.removeAll(SelectedEmployee);
        list2.removeAll(SelectedEmployee);
        
        JOptionPane.showMessageDialog(null, "Employee have Successfully Delate");
        
    }
    
   
    @FXML
    private void SearchEmployee(ActionEvent event) throws SQLException {
        
        list1.clear();
        
        try{
            
        String search = search1.getText();
        if(search.equals("")){
            initialize(null,null);
            
        }
        else{
            
            DBAction dbaction = new DBAction();        
            list1 = dbaction.SearchEmployee(Integer.parseInt(search));
            EmployeeID.setCellValueFactory(new PropertyValueFactory<>("EmployeeID"));
            Designation.setCellValueFactory(new PropertyValueFactory<>("Designation"));
            JoinDate.setCellValueFactory(new PropertyValueFactory<>("JoinDate"));
            Salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        
            EmployeeTable.setItems(list1);
            
        }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Please Type Correct Employee ID");
        }
        
        
    }

}