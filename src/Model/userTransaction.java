package Model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.List;

public class userTransaction {

    static DBCollection collection = MongoConnection.getDatabae().getCollection("users");

    // select All
    public static List<DBObject> SelectAllSuppliers() {
        BasicDBObject searchQuery = new BasicDBObject();
        DBCursor cursor = collection.find();

        return cursor.toArray();


    }

    public  static  BasicDBObject insertUser(String Name , String Address , String Email ,String phone , String pass , String role){


        BasicDBObject document = new BasicDBObject();
        document.put("name", Name);
        document.put("phone", phone);
        document.put("address", Address);
        document.put("email", Email);
        document.put("pass", pass);
        document.put("role", role);

        collection.insert(document);
        return document;
    }
}
