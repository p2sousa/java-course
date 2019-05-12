import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

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

        peopleCollection.find().forEach(showBlock);

    }

    public static void createNewDocument(MongoCollection<Document> collection, String name, Integer age) {

        Person person = new Person(name, age);
        Document document = new Document();

        document.append("name", person.getName());
        document.append("age", person.getAge());

        collection.insertOne(document);
    }
}
