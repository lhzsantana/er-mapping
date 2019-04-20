package org.ufsc.wardf.mapping.implement;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.ufsc.wardf.mapping.AbstractMapper;
import redis.clients.jedis.Jedis;

public class TriplePartsPermutationToRedisMapper extends AbstractMapper {

    Jedis jedis = new Jedis();

    @Override
    protected void store(Statement stmt) {

        RDFNode subject = stmt.getSubject();
        RDFNode predicate = stmt.getPredicate();
        RDFNode object = stmt.getObject();

        //sp_o
        jedis.set(subject.toString()+predicate.toString(), object.toString());

        //po_s
        jedis.set(predicate.toString()+object.toString(), subject.toString());

        //so_p
        jedis.set(subject.toString()+object.toString(), predicate.toString());

        //p_so
        jedis.set(predicate.toString(), subject.toString()+object.toString());

        //o_sp
        jedis.set(object.toString(), subject.toString()+predicate.toString());

        //s_po
        jedis.set(subject.toString(), predicate.toString()+object.toString());
    }
}
