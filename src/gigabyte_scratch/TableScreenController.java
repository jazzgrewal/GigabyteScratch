/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gigabyte_scratch;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author jaski
 */
public class TableScreenController implements Initializable {

    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable, String> col_Name;
    @FXML
    private TableColumn<ModelTable, String> col_Number;
    //now observable list is similar to arraylist
     ObservableList<ModelTable> tupleList= FXCollections.observableArrayList();
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       DbConnector obj=new DbConnector(); 
       Statement stmt;
       Connection conn = null;
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
                   //STEP 6: Clean-up environment
                        rs.close();
                        stmt.close();
                        conn.close();
                }
                catch(Exception e)
                {
                System.out.print("Do not connect to DB - Error:"+e);
                }
        
        col_Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        col_Number.setCellValueFactory(new PropertyValueFactory<>("Number"));
        
        table.setItems(tupleList);
    }
    
    
}
