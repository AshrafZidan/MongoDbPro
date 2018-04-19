/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Model.employeeTransaction;
import Model.supplierTransaction;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mongodb.BasicDBObject;
import dialogs.dialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Zi-D-aN
 */
public class CreateNewEmployeeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField EmployeeName;

    @FXML
    private JFXTextField EmployeePhone;

    @FXML
    private JFXButton addEmployee;

    @FXML
    private JFXTextField EmployeeAddress;

    @FXML
    private JFXTextField EmployeeEmail;


    @FXML
    void addEmployee(ActionEvent event) {

        if (EmployeeName.getText().trim().isEmpty()
                || EmployeePhone.getText().trim().isEmpty()
                || EmployeeAddress.getText().trim().isEmpty()
                || EmployeeEmail.getText().trim().isEmpty()

                ) {

            dialog Warning = new dialog(Alert.AlertType.WARNING, "خظأ", "ادخل جميع البيانات");


        } else {


            BasicDBObject object = employeeTransaction.insertEmployee(EmployeeName.getText(), EmployeePhone.getText(), EmployeeAddress.getText() , EmployeeEmail.getText());
            if (object != null) {
                dialog Done = new dialog(Alert.AlertType.CONFIRMATION, "تم", "تم حفظ العميل");


            }

        }


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
