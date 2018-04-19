/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Zi-D-aN
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Pane holderPane;

    AnchorPane homepage;

    @FXML
    private Text welcome;

    @FXML
    private JFXButton SupplierBtn;

    @FXML
    private JFXButton employeeBtn;
    @FXML
    private JFXButton productBtn;

    @FXML
    private JFXButton usersBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            createPage();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));

        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);

        ft.setAutoReverse(false);
        ft.play();
    }

    private void createPage() throws IOException {
        try {
            homepage = FXMLLoader.load(getClass().getResource("/fxml/Employee.fxml"));
            setNode(homepage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    @FXML
    private void SupplierPage(ActionEvent event) throws IOException {
        try {
            homepage = FXMLLoader.load(getClass().getResource("/fxml/supplier.fxml"));
            setNode(homepage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    @FXML
    private void productPage(ActionEvent event) throws IOException {
        try {
            homepage = FXMLLoader.load(getClass().getResource("/fxml/products.fxml"));
            setNode(homepage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    @FXML
    private void usersPage(ActionEvent event) throws IOException {
        try {
            homepage = FXMLLoader.load(getClass().getResource("/fxml/Users.fxml"));
            setNode(homepage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    @FXML
    private void employPage(ActionEvent event) throws IOException {
        try {
            homepage = FXMLLoader.load(getClass().getResource("/fxml/Employee.fxml"));
            setNode(homepage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    @FXML
    private void profilePage(ActionEvent event) throws IOException {
        try {
            homepage = FXMLLoader.load(getClass().getResource("/fxml/Profile.fxml"));
            setNode(homepage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }


}
