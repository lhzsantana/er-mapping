package org.ufsc.wardf.mapping.access;

import java.util.UUID;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.session.Session;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Statement;

public class CassandraAccessor {

    private String keyspace = UUID.randomUUID().toString();


    private boolean checkIfTableExists(RDFNode predicate){

        String query = "SELECT table_name \n" +
                "FROM system_schema.tables WHERE keyspace_name='"+keyspace+"';";

        try (CqlSession session = CqlSession.builder().build()) {

            ResultSet rs = session.execute(query);
            Row row = rs.one();
        }

        return true;
    }

    private boolean createTable(RDFNode predicate){

        String query = "CREATE TABLE "+predicate.toString()+"( "
                + "subject text, "
                + "object text, )";

        try (CqlSession session = CqlSession.builder().build()) {

            ResultSet rs = session.execute(query);
            Row row = rs.one();
        }

        return true;
    }

    public void storeTriple(RDFNode subject, RDFNode predicate, RDFNode object) {

        if(!checkIfTableExists(predicate)){
            createTable(predicate);
        }



    }
}
