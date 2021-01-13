package graph.realistion;

import graph.Graph;
import graph.serv.IncidentNode;
import graph.serv.Node;

import java.util.ArrayList;
import java.util.List;

public class SimpleGraph extends Graph {

    public void createConnection(String node1, String node2) {
        Node n1 = new Node(node1);
        Node n2 = new Node(node2);
        if (!nodes.get(n1).contains(new IncidentNode(n2))) {
            nodes.get(n1).add(new IncidentNode(n2));
        }
        if (!nodes.get(n2).contains(new IncidentNode(n1))) {
            nodes.get(n2).add(new IncidentNode(n1));
        }
    }

    public void createConnection(String node1, String node2, double weight) {
        Node n1 = new Node(node1);
        Node n2 = new Node(node2);
        if (!nodes.get(n1).contains(new IncidentNode(n2, weight))) {
            nodes.get(n1).add(new IncidentNode(n2, weight));
        }
        if (!nodes.get(n2).contains(new IncidentNode(n1, weight))) {
            nodes.get(n2).add(new IncidentNode(n1, weight));
        }
    }

    public void createRandomGraph(int size) {
        List<String> listExistings = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            listExistings.add("node" + i);
            insert(listExistings.get(i));
        }
        for (int i = 0; i < (int) (size / 2 + Math.random() * size); i++) {
            createConnection(listExistings.get((int) (Math.random() * size)),
                    listExistings.get((int) (Math.random() * size)),
                    Math.random() * 100);
        }
    }
}
