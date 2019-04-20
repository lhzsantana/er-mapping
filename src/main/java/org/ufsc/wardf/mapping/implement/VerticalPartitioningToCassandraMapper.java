package org.ufsc.wardf.mapping.implement;


import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Statement;
import org.ufsc.wardf.mapping.AbstractMapper;
import org.ufsc.wardf.mapping.access.CassandraAccessor;

public class VerticalPartitioningToCassandraMapper extends AbstractMapper {

    CassandraAccessor cassandraAccessor = new CassandraAccessor();

    @Override
    protected void store(Statement stmt) {

        RDFNode subject = stmt.getSubject();
        RDFNode predicate = stmt.getPredicate();
        RDFNode object = stmt.getObject();

        cassandraAccessor.storeTriple(subject, predicate, object);
    }

}
