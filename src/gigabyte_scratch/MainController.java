/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gigabyte_scratch;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author jaski
 */
public class MainController implements Initializable {

    @FXML
    private Button btnRes;
    @FXML
    private Button btnNxt;
    
     @FXML
     private void handleButtonAction(ActionEvent event) throws Exception {
        
        
        System.out.println("You clicked me!");
        System.out.println(event.getSource());
        if(event.getSource()==btnNxt)
        {
            System.out.println("Jazz nextButton was clicked");
        }
        else if(event.getSource()==btnRes){
            System.out.println("Jazz resetButton was clicked");
        }
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TableScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        //window.setWidth(800);
        //window.setHeight(600);
        window.setScene(tableViewScene);
        window.show();

    }
    @FXML 
    private void goMenu(ActionEvent event) throws Exception
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("NewUser.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}
