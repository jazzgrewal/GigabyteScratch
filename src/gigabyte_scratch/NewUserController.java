/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gigabyte_scratch;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jaski
 */
public class NewUserController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField numberField;
    @FXML
    private Button subForm;
    @FXML
    private Button bck;
    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable, String> colName;
    @FXML
    private TableColumn<ModelTable, String> colNumber;
    
    ObservableList<ModelTable> tupleList= FXCollections.observableArrayList();
    ObservableList<ModelTable> emptyList= FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    //Database part
       DbConnector obj=new DbConnector();
       Connection conn=obj.ConnectDB();
        Statement stmt,stmt1;
        String sql,sql1;
    
    @FXML
    public void submitData(ActionEvent event) throws SQLException{
             

            stmt = conn.createStatement();
            String Name=nameField.getText();
            String Number=numberField.getText();
            System.out.println(Name);
            sql = "INSERT INTO `users` (`Name`, `Number`) VALUES (?, ?);";
            
            PreparedStatement prpstmt=conn.prepareStatement(sql);
            prpstmt.setString(1, Name);
            prpstmt.setString(2, Number);
            
            prpstmt.execute();
            
            //stmt.executeUpdate(sql);
            //to update the table eveery time we click submit
          //  tableLoader();
        if(event.getSource()==subForm){
            System.out.println("Submit was clicked");
            subForm.setDisable(true);
        }

    }
    
    @FXML
    public void refreshList(ActionEvent event)
    {
        System.out.println("Refresh was clicked");
        tupleList.clear();
        tableLoader();
    }
    
    @FXML
    public void backToMain(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public void tableLoader(){
             try
                {
                    conn=obj.ConnectDB();
                    stmt = conn.createStatement();
                    String sql;
                    sql = "SELECT * FROM users";
                    ResultSet rs = stmt.executeQuery(sql);
                 //STEP 5: Extract data from result set
                    while(rs.next()){
                       tupleList.add(new ModelTable(rs.getString("Name"),rs.getInt("Number")));      
                    }
                 //we wont close the conn connection
                }
                catch(Exception e)
                {
                System.out.print("Do not connect to DB - Error:"+e);
                }
        
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        
        table.setItems(tupleList);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //this is something that will definately happen when the screen loads
        //calling the tableLoader so that we get the table at beginning
        tableLoader();   
        
    }    
    
    
}
