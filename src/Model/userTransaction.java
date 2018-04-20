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
}
