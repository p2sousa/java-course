import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class Connection {

    public MongoDatabase getConnection() {

        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("java_mongo");

        return database;
    }

}
