package graph.realistion;

import graph.Graph;
import graph.serv.IncidentNode;
import graph.serv.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleGraphTest {

    @Test
    void createConnection() {
        SimpleGraph graph;
        List<Double> list = new ArrayList<Double>();
        graph = new SimpleGraph();
        graph.insert("a");
        graph.insert("b");
        graph.insert("c");
        graph.insert("d");
        graph.insert("e");
        graph.createConnection("a","b",23);
        graph.createConnection("b","d",3);
        graph.createConnection("d","c",2);
        graph.createConnection("a","c",2);
        graph.createConnection("e","c",2);

        Assertions.assertEquals("[d, a, e]", graph.getIncidents("c").toString());
        Assertions.assertEquals("[b, c]", graph.getIncidents("a").toString());
        for(IncidentNode item: graph.getIncidentsWithWeight("b")) {
            list.add(item.weight);
        }
        Assertions.assertEquals("[23.0, 3.0]", list.toString());
    }

    @Test
    void createRandomGraph() {
        SimpleGraph graph = new SimpleGraph();
        graph.createRandomGraph(10);
    }
}