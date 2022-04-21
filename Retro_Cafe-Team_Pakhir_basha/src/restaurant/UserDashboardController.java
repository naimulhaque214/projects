
package restaurant;

import conpkg.concls;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class UserDashboardController implements Initializable {

    @FXML
    private TableColumn<OrderFood, Integer> OrderIdC;
    @FXML
    private TableColumn<OrderFood, String> FoodNameC;
    @FXML
    private TableColumn<OrderFood, Integer> QuantityC;
    @FXML
    private TableColumn<OrderFood, String> OrderTypeC;
    @FXML
    private TableColumn<OrderFood, Double> PriceC;
    @FXML
    private TextField OrderId;
    @FXML
    private TextArea OutPut;
    @FXML
    private TableView<OrderFood> OrderTable;
    
    public Stage stage;    
    private final Label jobStatus = new Label();
    
    DBAction dbaction = new DBAction();
    
    ObservableList<OrderFood> AllOrder = FXCollections.observableArrayList();
    @FXML
    private Label GrandTotalLabel;

    
    
    Double TotalFPrice;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddOutputAction(ActionEvent event) throws SQLException {
         
        OutPut.clear();
        
         String orderid = OrderId.getText();
         if(orderid.equals(""))return;        
         int oid = Integer.parseInt(orderid);

         
         Date d = new Date();
         String date = d.toString();
         
         
        concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
         
         
         Statement st1 = con.createStatement();
         String quer = "SELECT Table_Id FROM purchase WHERE Order_ID = "+oid;
         ResultSet re = st1.executeQuery(quer);
         
         
         
         
         OutPut.appendText("\t\t      Cafe Retro\n\t\t   47/k Gulshan\n\t         Dhaka Bangladesh\n\t  retrocafe290@gmail.com"
         
                 +"\n  - - - - - - - - - - - - - - - - - - - - - - - -"
                 +"\nOrder ID : "+oid+"\t Table : "
                 
         ); 
         
         String tab = new String();
         while(re.next())
         {
             tab = re.getString("Table_Id");
             
             OutPut.appendText(""+tab+"");
             break;
         }
         
         
         OutPut.appendText(
         
         
                 "\nOrder Time : "+date
                 +"\n  - - - - - - - - - - - - - - - - - - - - - - - -"
                 +"\nFood Name\t Rate\t Qty\t Price"
                 
         );
         
         
        
         
        String query = "SELECT food.Food_Name,food.Selling_Price, purchase.Quantity,  purchase.Sub_Total FROM purchase join food ON purchase.Food_Id = food.Food_Id WHERE purchase.Order_ID ="+oid;
        Statement statement = con.createStatement();
        ResultSet resultset = statement.executeQuery(query);
        
        
        Statement statement2 = con.createStatement();
        String Query2 = "SELECT order_table.Order_Type FROM order_table WHERE Order_ID = "+oid;
        ResultSet result = statement2.executeQuery(Query2);
        
        String ordertype = "";
        while(result.next())
        {
            ordertype = result.getString("order_table.Order_Type");
        }
        
        while(resultset.next())
        {
            //Get data from Database    
            String foodname = resultset.getString("food.Food_Name");
            Double SellingPrice = resultset.getDouble("food.Selling_Price");
            int quantity = resultset.getInt("purchase.Quantity");
            double totalprice = resultset.getDouble("purchase.Sub_Total");
           
            //Initialize data in Employee object
            OutPut.appendText("\n  "+foodname+"\t\t "+SellingPrice+"\t "+quantity+"\t "+totalprice); 
            
        }   
        
        double round = Math.ceil(TotalFPrice);
        double r = round - TotalFPrice;
        
        OutPut.appendText("\n  - - - - - - - - - - - - - - - - - - - - - - - -"
        
                +"\nOrder Total : "+TotalFPrice
                +"\nRounding    : "+r
                +"\nTotal Amount: "+round
                +"\n  - - - - - - - - - - - - - - - - - - - - - - - -"
                +"\nThank you for coming!"
        );
         
       
         
        
    }


    @FXML
    private void OrderIdAction(ActionEvent event) throws SQLException {
        
         String orderid = OrderId.getText();
        if(orderid.equals(""))return;
        
        int oid = Integer.parseInt(orderid);
        
         AllOrder.clear();
         
          
          AllOrder = getAllOrder(oid);
          
          OrderIdC.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
          FoodNameC.setCellValueFactory(new PropertyValueFactory<>("FoodName"));
          QuantityC.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
          OrderTypeC.setCellValueFactory(new PropertyValueFactory<>("OrderType"));
          PriceC.setCellValueFactory(new PropertyValueFactory<>("TotalPrice"));

          OrderTable.setItems(AllOrder);
          
          concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
          
          Statement st = con.createStatement();
          String query = "SELECT Total FROM order_table WHERE Order_ID = "+oid;
          ResultSet rs = st.executeQuery(query);
          
          double Total = 0;
          while(rs.next())
          {
              Total = rs.getDouble("Total");
          }
          GrandTotalLabel.setText(""+Total);
            TotalFPrice = Total;
    }
    
    
    //Get All Food Order For Specific Order Table
    
   ObservableList<OrderFood> getAllOrder(int OrderId) throws SQLException{
        
        
        ObservableList<OrderFood> Orderlist = FXCollections.observableArrayList();
        
        concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
        Statement statement = con.createStatement();
        String query = "SELECT purchase.Order_ID, food.Food_Name, purchase.Quantity,  purchase.Sub_Total FROM purchase join food ON purchase.Food_Id = food.Food_Id WHERE purchase.Order_ID ="+OrderId;
        
        ResultSet resultset = statement.executeQuery(query);
        
        
        Statement statement2 = con.createStatement();
        String Query2 = "SELECT order_table.Order_Type FROM order_table WHERE Order_ID = "+OrderId;
        ResultSet result = statement2.executeQuery(Query2);
        
        String ordertype = "";
        while(result.next())
        {
            ordertype = result.getString("order_table.Order_Type");
        }
        
        while(resultset.next())
        {
            //Get data from Database    
            int orderid = resultset.getInt("purchase.Order_ID");
            String foodname = resultset.getString("food.Food_Name");
            int quantity = resultset.getInt("purchase.Quantity");
            double totalprice = resultset.getDouble("purchase.Sub_Total");
           
            //Initialize data in Employee object
            OrderFood orderfood = new OrderFood(orderid, foodname,quantity,totalprice,ordertype);            
            
            Orderlist.add(orderfood);
            
        }   
        
        return Orderlist;        
        
    }
   
    
    
}
