/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.userTransaction;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import dialogs.dialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author Zi-D-aN
 */
public class ProfileController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXButton createNewUserBtn;


    @FXML
    private JFXTextField UserName;

    @FXML
    private JFXTextField Useraddress;

    @FXML
    private JFXPasswordField confirmPass;

    @FXML
    private JFXPasswordField newPass;

    @FXML
    private JFXTextField Userphone;

    @FXML
    private JFXButton loadInfoBtn;

    @FXML
    private JFXTextField UserEmail;

    @FXML
    private JFXPasswordField oldPass;

    @FXML
    private JFXButton saveBtn;
    
    String recivedPass ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void loadNewUserPage(ActionEvent e){
     try{
            
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/createNewUser.fxml"));
            Scene scene =  new Scene(root);
            
            Stage home = new Stage();
               home.setTitle("Create New USer");
       
            home.setScene(scene);
            home.show();
            home.setResizable(false);
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    
    }

    @FXML
    void saveAction(ActionEvent event) {
        if (UserName.getText().trim().isEmpty()
                || Useraddress.getText().trim().isEmpty()
                || Userphone.getText().trim().isEmpty()
                || UserEmail.getText().trim().isEmpty()
                || oldPass.getText().trim().isEmpty()
                || newPass.getText().trim().isEmpty()
                || confirmPass.getText().trim().isEmpty()
                ) {

            dialog dd = new dialog(Alert.AlertType.WARNING, "خظأ", "ادخل جميع البيانات");


        }


        else if (! password.checkPassword(oldPass.getText().toString(),recivedPass)){
            dialog dd = new dialog(Alert.AlertType.WARNING, "خظأ", "كلمه السر غير صحيحه");

        }
        else if (! newPass.getText().toString().toLowerCase().equals(  confirmPass.getText().toString().toLowerCase())){
            dialog dd = new dialog(Alert.AlertType.WARNING, "خظأ", "كلمه السر غير مطابقة");
        }
        else {
            BasicDBObject basicDBObject = new BasicDBObject();
            basicDBObject.put("name", UserName.getText());
            basicDBObject.put("address", Useraddress.getText());
            basicDBObject.put("phone", Userphone.getText());
            basicDBObject.put("email", UserEmail.getText());

            String newHasedPass = password.hashPassword(newPass.getText().toString());
            basicDBObject.put("pass", newHasedPass);


            BasicDBObject basicDBObjectUpdated = userTransaction.updateUser( "5ada0428c466192c246b9179" , basicDBObject);
            if (basicDBObjectUpdated != null) {
                dialog dd = new dialog(Alert.AlertType.CONFIRMATION, "تم", "تم التعديل");


            }

        }



    }

    @FXML
    void loadInfoAction(ActionEvent event) {


        DBObject userObj =  userTransaction.SelectbyID("5ada0428c466192c246b9179");
        UserName.setText(userObj.get("name").toString());
        UserEmail.setText(userObj.get("email").toString());
        Useraddress.setText(userObj.get("address").toString());
        Userphone.setText(userObj.get("phone").toString());
        recivedPass = userObj.get("pass").toString();
    }



}

