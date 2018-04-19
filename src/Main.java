import Model.supplierTransaction;
import com.mongodb.BasicDBObject;

/**
 * Created by ahmed mar3y on 19/04/2018.
 */
public class Main {

    public static void main(String[] args) {

//        System.out.println(supplierTransaction.insertSupplier("ahmed" ,"01201288779","tanta").get("_id"));
//        System.out.println(supplierTransaction.SelectSupplierById("5ad889e2fe4aa930e4e376f3"));
//        System.out.println(supplierTransaction.SelectAllSuppliers());

        //update operations
//        BasicDBObject newDocument = new BasicDBObject();
//        newDocument.put("name", "eslam mohamed");
//        newDocument.put("phone", "123456");
//        newDocument.put("address", "ssssssss");
//        newDocument.put("available", false);
//        System.out.println(supplierTransaction.updateSupplier("5ad889e2fe4aa930e4e376f3", newDocument));

        System.out.println(supplierTransaction.SelectAllSuppliers());

    }

}
