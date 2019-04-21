import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.ufsc.wardf.mapping.implement.*;

import java.io.InputStream;

public class Main {

    private static FlatTripleToMongoDBMapper flatTripleToMongoDBMapper = new FlatTripleToMongoDBMapper();
    private static TriplePartsPermutationToRedisMapper triplePartsPermutationMapper = new TriplePartsPermutationToRedisMapper();
    //private static GraphToNeo4JMapper graphToNeo4JMapper = new GraphToNeo4JMapper();
    private static VerticalPartitioningToCassandraMapper verticalPartitioningToCassandraMapper = new VerticalPartitioningToCassandraMapper();
    private static HierarchicalToCassandraMapper hierarchicalToCassandraMapper = new HierarchicalToCassandraMapper();
    private static PreProcessedToCassandraMapper preProcessedToCassandraMapper = new PreProcessedToCassandraMapper();



    static final String inputFileName  = "vc-db-1.rdf";

    public static void main (String args[]) {
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open( inputFileName );
        if (in == null) {
            throw new IllegalArgumentException( "File: " + inputFileName + " not found");
        }

        // read the RDF/XML file
        model.read(in, "");

        //flatTripleToMongoDBMapper.mapAll(model);
        //triplePartsPermutationMapper.mapAll(model);
        //graphToNeo4JMapper.mapAll(model);
        //verticalPartitioningToCassandraMapper.mapAll(model);
        //hierarchicalToCassandraMapper.mapAll(model);
        preProcessedToCassandraMapper.mapAll(model);

    }

}
