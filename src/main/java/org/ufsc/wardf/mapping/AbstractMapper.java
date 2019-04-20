package org.ufsc.wardf.mapping;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

public abstract class AbstractMapper {

    final static Log logger = LogFactory.getLog(AbstractMapper.class);

    public void mapAll(Model model){

        int runs = 0;
        long sum = 0;

        StmtIterator it =  model.listStatements();

        for(int i=0;i<10;i++){
            while (it.hasNext()) {
                Statement stmt = it.next();

                //logger.info(stmt.toString());

                long tStart = System.nanoTime();
                store(stmt);
                long tEnd = System.nanoTime();
                sum += tEnd - tStart;

                runs++;
            }
        }

        logger.info("Elapsed time "+sum/runs);
    }

    abstract protected void store(Statement stmt );
}
