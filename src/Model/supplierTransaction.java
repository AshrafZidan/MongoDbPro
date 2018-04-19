package Model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

/**
 * Created by ahmed mar3y on 19/04/2018.
 */
public class supplierTransaction {


    public static BasicDBObject insert(String name, String phone, String address) {

        DBCollection collection = MongoConnection.getDatabae().getCollection("suppliers");
        BasicDBObject document = new BasicDBObject();
        document.put("name", name);
        document.put("phone", phone);
        document.put("address", address);
        document.put("available", true);

        collection.insert(document);

        return document;


    }


}
