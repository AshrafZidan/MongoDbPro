/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.MongoConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.javaws.progress.Progress;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zi-D-aN
 */
public class LoginMainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton login;
  
    @FXML
    private JFXTextField userName;
      
      
    @FXML
    private JFXPasswordField pass;
       
    @FXML
    private JFXCheckBox  remember;
    
    @FXML
      AnchorPane loginpage;
      
    
    String name , password ; 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        MongoConnection.createMongoConnection();


    }
    
    
   @FXML
   public void loginFunc(ActionEvent e) throws IOException{
       
       if (true) {
         
         try{
            loginpage.getScene().getWindow().hide();
            Stage home = new Stage();
            
             Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
             Scene  scene = new Scene(root);
             home.setScene(scene);
             home.show();
             
            
   
        }catch(Exception ex){
            ex.printStackTrace();
        }

           
       }
       
       else{

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        //alert.setHeaderText("Look, an Error Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Ooops, there was an error!");

        alert.showAndWait();
              }

   }
   
}
