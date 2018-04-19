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
import javafx.scene.paint.Color;
import javafx.stage.Modality;
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
    private void LoadAddNewPage(ActionEvent e) {

        try {
            Stage home = new Stage();

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CreateNewSupplier.fxml"));
            Scene scene = new Scene(root);

            home.setTitle("Create New Supplier");

            home.setScene(scene);
            home.setResizable(false);

            scene.setFill(Color.TRANSPARENT); //Makes scene background transparent

            home.initModality(Modality.APPLICATION_MODAL);

            home.showAndWait();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


    @FXML
    private void updatePage(ActionEvent e) {

        try {
            Stage home = new Stage();

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/updateSupplier.fxml"));
            Scene scene = new Scene(root);

            home.setTitle("Create New Supplier");

            home.setScene(scene);
            home.setResizable(false);

            scene.setFill(Color.TRANSPARENT); //Makes scene background transparent

            home.initModality(Modality.APPLICATION_MODAL);

            home.showAndWait();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


}
