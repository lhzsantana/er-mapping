package org.ufsc.wardf.mapping.implement;

import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Statement;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.ufsc.wardf.mapping.AbstractMapper;
import org.neo4j.graphdb.GraphDatabaseService;

public class GraphToNeo4JMapper extends AbstractMapper {
    GraphDatabaseService db = null;
    @Override
    protected void store(Statement stmt) {

        RDFNode subject = stmt.getSubject();
        RDFNode predicate = stmt.getPredicate();
        RDFNode object = stmt.getObject();

        try(Transaction tx=db.beginTx()){
            Node nod=db.createNode();
            nod.setProperty("name", "comp");
        }

    }
}
