package Controllers;

import Controllers.LoginMainController;
import Model.employeeTransaction;
import Model.storeTransaction;
import Model.supplierTransaction;
import Model.userTransaction;
import com.mongodb.BasicDBObject;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

/**
 * Created by ahmed mar3y on 19/04/2018.
 */
public class MainStart extends Application {

//    public static void main(String[] args) {
//
////        System.out.println(supplierTransaction.insertSupplier("ahmed" ,"01201288779","tanta").get("_id"));
////        System.out.println(supplierTransaction.SelectSupplierById("5ad889e2fe4aa930e4e376f3"));
////        System.out.println(supplierTransaction.SelectAllSuppliers());
//
//        //update operations
////        BasicDBObject newDocument = new BasicDBObject();
////        newDocument.put("name", "eslam mohamed");
////        newDocument.put("phone", "123456");
////        newDocument.put("address", "ssssssss");
////        newDocument.put("available", false);
////        System.out.println(supplierTransaction.updateSupplier("5ad889e2fe4aa930e4e376f3", newDocument));
//
////        System.out.println(supplierTransaction.insertSupplier("Ashraf","01003196789","Tanta"));
////        System.out.println(supplierTransaction.SelectAllSuppliers());
//
////        System.out.println(userTransaction.SelectAllSuppliers().toString());
//
//
//    }
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setController(new LoginMainController());
      Parent root =  loader.load(getClass().getResource("/fxml/loginMain.fxml"));




        Scene scene = new Scene(root);


        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


}
