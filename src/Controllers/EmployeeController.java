/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.employeeTransaction;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.mongodb.DBObject;
import dialogs.dialog;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import static Model.employeeTransaction.selectAllEmployees;

/**
 * FXML Controller class
 *
 * @author Zi-D-aN
 */

public class EmployeeController implements Initializable {

    @FXML
    private JFXTreeTableView treeView;

    @FXML
    private JFXButton addNewBtn;
    @FXML
    private JFXButton updateBtn;

    @FXML
    private TreeTableView<EmployeeController.EmployeeTable> employeeTable;

    @FXML
    private TreeTableColumn<EmployeeController.EmployeeTable, String> employeeTable_name;

    @FXML
    private TreeTableColumn<EmployeeController.EmployeeTable, String> employeeTable_phone;

    @FXML
    private TreeTableColumn<EmployeeController.EmployeeTable, String> employeeTable_address;

    @FXML
    private TreeTableColumn<EmployeeController.EmployeeTable, String> employeeTable_email;




    ObservableList<EmployeeController.EmployeeTable> employeeTable_data = FXCollections.observableArrayList();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        // table column initlaizton

        employeeTable_name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EmployeeTable , String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<EmployeeTable, String> param) {
                return param.getValue().getValue().name;
            }

        });

        employeeTable_phone.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures< EmployeeTable, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<EmployeeTable, String> param) {
                return param.getValue().getValue().phone;
            }

        });

        employeeTable_address.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures< EmployeeTable, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<EmployeeTable, String> param) {
                return param.getValue().getValue().address;
            }

        });

        employeeTable_email.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures< EmployeeTable, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<EmployeeTable, String> param) {
                return param.getValue().getValue().email;
            }

        });

//        get All Employess from employee Model
     List<DBObject> AllEmployess_DbObjectes  = employeeTransaction.selectAllEmployees();

     //Iteatre overThem
     AllEmployess_DbObjectes.stream().forEach(dbObject ->{
         employeeTable_data.add(new EmployeeTable(
                 dbObject.get("_id").toString(),
                 dbObject.get("name").toString(),
                 dbObject.get("phone").toString(),
                 dbObject.get("email").toString(),

                 dbObject.get("address").toString()));

             }
         );


        final TreeItem<EmployeeTable> root = new RecursiveTreeItem<EmployeeTable>(employeeTable_data, RecursiveTreeObject::getChildren);

        employeeTable.setRoot(root);
        employeeTable.setShowRoot(false);

    }

     @FXML
    private  void LoadAddNewPage(ActionEvent e){
        
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CreateNewEmployee.fxml"));
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
    private void updatePage(ActionEvent events) {

        // check Selection


        RecursiveTreeItem selectedItem = (RecursiveTreeItem) employeeTable.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {

            try {

                Stage Update_page = new Stage();

                Parent root = FXMLLoader.load(getClass().getResource("/fxml/updateEmployee.fxml"));
                Scene scene = new Scene(root);

                Update_page.setTitle("Update Supplier");

                Update_page.setScene(scene);
                Update_page.setResizable(false);

                scene.setFill(Color.TRANSPARENT); //Makes scene background transparent

                Update_page.initModality(Modality.APPLICATION_MODAL);

                Update_page.showAndWait();

            } catch (Exception exp) {
                exp.printStackTrace();
            }


        } else {
            dialog warning = new dialog(Alert.AlertType.WARNING, "خظأ", "اختر الموظف للتعديل");

        }


    }

    class EmployeeTable extends RecursiveTreeObject<EmployeeTable>{

        SimpleStringProperty id;
        SimpleStringProperty name;
        SimpleStringProperty phone;
        SimpleStringProperty address;
        SimpleStringProperty email;


        // create constructor
        public EmployeeTable(String id , String name , String phone , String address , String email){
            this.id = new SimpleStringProperty(id);

            this.address = new SimpleStringProperty(address);
            this.name = new SimpleStringProperty(name);
            this.phone = new SimpleStringProperty(phone);
            this.email = new SimpleStringProperty(email);

        }

        //setter and getter
        public String getId() {
            return id.get();
        }

        public SimpleStringProperty idProperty() {
            return id;
        }

        public void setId(String id) {
            this.id.set(id);
        }

        public String getName() {
            return name.get();
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public String getPhone() {
            return phone.get();
        }

        public SimpleStringProperty phoneProperty() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone.set(phone);
        }

        public String getAddress() {
            return address.get();
        }

        public SimpleStringProperty addressProperty() {
            return address;
        }

        public void setAddress(String address) {
            this.address.set(address);
        }

        public String getEmail() {
            return email.get();
        }

        public SimpleStringProperty emailProperty() {
            return email;
        }

        public void setEmail(String email) {
            this.email.set(email);
        }
    }

}
