/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import Model.employeeTransaction;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import dialogs.dialog;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Zi-D-aN
 */
public class UpdateEmployeeController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private JFXTextField employeeName;
    @FXML
    private JFXTextField employeeEmail;
    @FXML
    private JFXTextField employeephone;
    @FXML
    private JFXTextField employeeAddress;

    @FXML
    private JFXButton updateBtn;

    public static String employeeId;


    @FXML
    void employeepdateAction(javafx.event.ActionEvent event) {


        if (employeeName.getText().trim().isEmpty()
                || employeeAddress.getText().trim().isEmpty()
                || employeephone.getText().trim().isEmpty()
                || employeeEmail.getText().trim().isEmpty()
                ) {

            dialog dd = new dialog(Alert.AlertType.WARNING, "خظأ", "ادخل جميع البيانات");


        } else {
            BasicDBObject basicDBObject = new BasicDBObject();

            basicDBObject.put("address", employeeAddress.getText());

            basicDBObject.put("name", employeeName.getText());
            basicDBObject.put("email", employeeEmail.getText());
            basicDBObject.put("phone", employeephone.getText());

            BasicDBObject basicDBObjectUpdated = employeeTransaction.updateEmployee(employeeId, basicDBObject);
            if (basicDBObjectUpdated != null) {
                dialog dd = new dialog(Alert.AlertType.CONFIRMATION, "تم", "تم التعديل");


            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

////         get supplierBy Id
        DBObject dbObject = employeeTransaction.SelectEmployeeById(employeeId);
        // set values
//        System.out.println(employeeId +" from Updated Control");
        this.employeeAddress.setText(dbObject.get("address").toString());
        this.employeephone.setText(dbObject.get("phone").toString());
        this.employeeEmail.setText(dbObject.get("email").toString());
        this.employeeName.setText(dbObject.get("name").toString());

    }

}
