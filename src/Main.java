import Model.supplierTransaction;

/**
 * Created by ahmed mar3y on 19/04/2018.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(supplierTransaction.insert("ahmed" ,"01201288779","tanta").get("_id"));


    }

}
