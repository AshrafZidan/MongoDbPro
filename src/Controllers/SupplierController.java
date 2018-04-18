/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zi-D-aN
 */
public class SupplierController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton addNewBtn;
      @FXML
    private JFXButton updateBtn;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private  void LoadAddNewPage(ActionEvent e){
        
        try{
            
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CreateNewSupplier.fxml"));
            Scene scene =  new Scene(root);
            
            Stage home = new Stage();
               home.setTitle("Create New Supplier");
       
            home.setScene(scene);
            home.show();
            home.setResizable(false);
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    
    
        
    }
    
    
    @FXML
    private  void updatePage(ActionEvent e){
            
        try{
            
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/updateSupplier.fxml"));
            Scene scene =  new Scene(root);
            
            Stage home = new Stage();
               home.setTitle("Create New Supplier");
       
            home.setScene(scene);
            home.show();
            home.setResizable(false);
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    
    
    
    
        
    }
    
    
    
}
