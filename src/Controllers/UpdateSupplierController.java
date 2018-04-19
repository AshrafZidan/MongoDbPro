/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Zi-D-aN
 */
public class UpdateSupplierController implements Initializable {


    @FXML
    private JFXTextField supplierName;

    @FXML
    private JFXTextField supplierPhone;

    @FXML
    private JFXButton supplierUpdate;

    @FXML
    private JFXTextField supplierAddress;

    @FXML
    void supplierUpdateAction(ActionEvent event) {


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
