import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class App {
    public static void main(String[] args) {

        MongoDatabase connection = new Connection().getConnection();
//        connection.createCollection("people");

        MongoCollection<Document> peopleCollection = connection.getCollection("people");

        Block<Document> showBlock = new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        };
//        createNewDocument(peopleCollection, "Pablo", 26);
        findAll(peopleCollection).forEach(showBlock);

//        findBy(peopleCollection, "name", "Pablo").forEach(showBlock);
//        peopleCollection.deleteOne(eq("name", "Pablo"));
    }

    public static void createNewDocument(MongoCollection<Document> collection, String name, Integer age) {

        Person person = new Person(name, age);
        Document document = new Document();

        document.append("name", person.getName());
        document.append("age", person.getAge());

        collection.insertOne(document);
    }

    public static FindIterable<Document> findAll(MongoCollection<Document> collection) {
        return collection.find();
    }

    public static FindIterable<Document> findBy(MongoCollection<Document> collection, String key, Object value) {
        return collection.find(eq(key, value));
    }
}
