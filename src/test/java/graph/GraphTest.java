package graph;

import graph.realistion.SimpleGraph;
import graph.serv.IncidentNode;
import graph.serv.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class GraphTest {


    @Test
    void insert() {
        Graph graph;
        List<String> list = new ArrayList<String>();
        graph = new SimpleGraph();
        graph.insert("a");
        graph.insert("b");
        graph.insert("c");
        graph.insert("d");
        graph.insert("e");
        for (Node node : graph.getNodes().keySet()) {
            list.add(node.name);
        }
        Assertions.assertEquals("[a, b, c, d, e]", list.toString());
    }

    @Test
    void delete() {
        SimpleGraph graph;
        List<String> list = new ArrayList<String>();
        graph = new SimpleGraph();
        graph.insert("a");
        graph.insert("b");
        graph.insert("c");
        graph.insert("d");
        graph.insert("e");
        graph.delete("b");
        for (Node node : graph.getNodes().keySet()) {
            list.add(node.name);
        }
        Assertions.assertEquals("[a, c, d, e]", list.toString());
    }

    @Test
    void deleteConnection() {
        SimpleGraph graph = new SimpleGraph();
        List<Double> list = new ArrayList<Double>();
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

        graph.deleteConnection("a","b");

        Assertions.assertEquals("[d, a, e]", graph.getIncidents("c").toString());
        Assertions.assertEquals("[c]", graph.getIncidents("a").toString());
        for(IncidentNode item: graph.getIncidentsWithWeight("b")) {
            list.add(item.weight);
        }
        Assertions.assertEquals("[3.0]", list.toString());
    }

    @Test
    void getIncidents() {
        SimpleGraph graph = new SimpleGraph();
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
    }

    @Test
    void getIncidentsWithWeight() {
        SimpleGraph graph = new SimpleGraph();
        List<Double> list = new ArrayList<Double>();
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
        for(IncidentNode item: graph.getIncidentsWithWeight("b")) {
            list.add(item.weight);
        }
        Assertions.assertEquals("[23.0, 3.0]", list.toString());
    }

    @Test
    void depthFirstWalk() {
        SimpleGraph graph = new SimpleGraph();
        List<String> list = new ArrayList<String>();
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
        Assertions.assertEquals("[a, c, e, d, b]",graph.depthFirstWalk("a").toString());
    }

    @Test
    void breadthFirstWalk() {
        SimpleGraph graph = new SimpleGraph();
        List<String> list = new ArrayList<String>();
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
        Assertions.assertEquals("[a, b, c, d, e]",graph.breadthFirstWalk("a").toString());
    }
}