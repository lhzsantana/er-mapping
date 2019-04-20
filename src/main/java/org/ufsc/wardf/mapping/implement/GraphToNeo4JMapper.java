package org.ufsc.wardf.mapping.implement;

import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Statement;
import org.neo4j.driver.v1.*;
import org.ufsc.wardf.mapping.AbstractMapper;

public class GraphToNeo4JMapper extends AbstractMapper {

    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "rdf"));

    @Override
    protected void store(Statement stmt) {

        RDFNode subject = stmt.getSubject();
        RDFNode predicate = stmt.getPredicate();
        RDFNode object = stmt.getObject();

        try (Session session = driver.session()) {

            String statement = "CREATE (a:RDFNode { name: '"+subject.toString()+"' })" +
                    "CREATE (b:RDFNode { name: '"+object.toString()+"' })" +
                    "CREATE (a)-[r:RELTYPE { name: '"+predicate.toString()+"' }]->(b)";

            StatementResult rs = session.run(statement);
        }

    }
}
