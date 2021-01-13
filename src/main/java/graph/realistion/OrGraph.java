package graph.realistion;

import graph.Graph;
import graph.serv.IncidentNode;
import graph.serv.Node;

import java.util.ArrayList;
import java.util.List;

public class OrGraph extends Graph {

    public void createConnection(String node1, String node2) {
        if(!nodes.get(new Node(node1)).contains(new IncidentNode(new Node(node2)))) {
            nodes.get(new Node(node1)).add(new IncidentNode(new Node(node2)));
        }
    }

    public void createConnection(String node1, String node2, double weight) {
        if(!nodes.get(new Node(node2)).contains(new IncidentNode(new Node(node1)))) {
            nodes.get(new Node(node1)).add(new IncidentNode(new Node(node2), weight));
        }
    }

    public void createRandomGraph(int size) {
        List<String> listExistings = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            listExistings.add("node" + i);
            insert(listExistings.get(i));
        }
        for (int i = 0; i < (int)(size/2 + Math.random()*size);i++) {
            createConnection(listExistings.get((int)(Math.random()*size)),
                    listExistings.get((int)(Math.random()*size)),
                    Math.random()*100);
        }
    }
}
