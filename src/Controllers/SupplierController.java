/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

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

    @FXML
    private TreeTableView<supplierTable> supplierTable;

    @FXML
    private TreeTableColumn<supplierTable, String> supplierTable_name;

    @FXML
    private TreeTableColumn<supplierTable, String> supplierTable_phone;

    @FXML
    private TreeTableColumn<supplierTable, String> supplierTable_address;

    ObservableList<supplierTable> supplierTable_data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        // table column initlaize
        supplierTable_name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<supplierTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<supplierTable, String> param) {
                return param.getValue().getValue().name;
            }

        });


        supplierTable_phone.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<supplierTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<supplierTable, String> param) {
                return param.getValue().getValue().phone;
            }

        });
        supplierTable_address.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<supplierTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<supplierTable, String> param) {
                return param.getValue().getValue().address;
            }

        });

        supplierTable_data.add(new supplierTable(1, "ahmed", "123456", "tanta"));
        final TreeItem<supplierTable> root = new RecursiveTreeItem<supplierTable>(supplierTable_data, RecursiveTreeObject::getChildren);
//        tableview.getColumns().setAll(NaklTable_date, NaklTable_bolisa, NaklTable_carNum, NaklTable_weight, NaklTable_nawlon, NaklTable_ohda, NaklTable_agz, NaklTable_added, NaklTable_mezan, NaklTable_discount, NaklTable_office, NaklTable_clear, NaklTable_type, NaklTable_notes);
        supplierTable.setRoot(root);
        supplierTable.setShowRoot(false);


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

    class supplierTable extends RecursiveTreeObject<supplierTable> {
        SimpleIntegerProperty id;
        SimpleStringProperty name;
        SimpleStringProperty phone;
        SimpleStringProperty address;

        public supplierTable(int id, String name, String phone, String address) {
            this.id = new SimpleIntegerProperty(id);
            this.name = new SimpleStringProperty(name);
            this.phone = new SimpleStringProperty(phone);
            this.address = new SimpleStringProperty(address);
        }


        public int getId() {
            return id.get();
        }

        public SimpleIntegerProperty idProperty() {
            return id;
        }

        public void setId(int id) {
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
    }


}
