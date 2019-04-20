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

        //spo

        //sop

        //pso

        //pos

        //ops

        //osp


    }
}
