//package
package org.jgrapht.own;

import java.io.FileInputStream;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.Graph;
import org.jgrapht.alg.NaiveLcaFinder;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.io.DOTImporter;
import org.jgrapht.io.GraphImporter;


public class Solver {


    public static String commAncestor(String fName,String vOne,String vTwo) throws Exception{

        GraphImporter<String, DefaultEdge> importer = new DOTImporter<>((label, attributes) -> label, (from, to, label, attributes) -> new DefaultEdge());
        Graph<String, DefaultEdge> result = new SimpleDirectedGraph<>(DefaultEdge.class);
        importer.importGraph(result, new FileInputStream(fName));
        NaiveLcaFinder<String, DefaultEdge> LCAFinder = new NaiveLcaFinder<String, DefaultEdge>(result);
        String res =(String)LCAFinder.findLca(vOne,vTwo);
        return res;

    }


    public static void main(String args[]) throws Exception{

        String fileAddress= args[0];
        String first= args[1];
        String second= args[2];
        System.out.println(commAncestor(fileAddress,first,second));

    }


}
