package org.ufsc.wardf.mapping.implement;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Statement;
import org.bson.Document;
import org.ufsc.wardf.mapping.AbstractMapper;

public class FlatTripleToMongoDBMapper extends AbstractMapper {

    static MongoClient mongoClient = MongoClients.create("mongodb://historical-data:1gdupF1DiZsDj6QrQcmdbXojchgjO1kGYK6gK5KFJ7TCyjmv1BH35jKoDU7hIA499lxX6UEHYCoPMhCOhQ9kiw==@historical-data.documents.azure.com:10255/?ssl=true&replicaSet=globaldb");
    static MongoDatabase db = mongoClient.getDatabase("wa-rdf");
    static MongoCollection<Document> triplesCollection = db.getCollection("triples");

    @Override
    protected void store(Statement stmt) {

        RDFNode subject = stmt.getSubject();
        RDFNode predicate = stmt.getPredicate();
        RDFNode object = stmt.getObject();

        Document triple = new Document();
        triple.put("subject", subject);
        triple.put("predicate", predicate);
        triple.put("object", object);

        //triplesCollection.insertOne(triple);
    }
}
