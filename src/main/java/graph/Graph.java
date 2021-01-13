package graph;

import graph.realistion.SimpleGraph;
import graph.serv.IncidentNode;
import graph.serv.Node;

import java.util.*;

public abstract class Graph {
    protected Map<Node, List<IncidentNode>> nodes;

    public Graph() {
        nodes = new HashMap<Node, List<IncidentNode>>();
    }

    public void insert(String name) {
        nodes.put(new Node(name), new ArrayList<IncidentNode>());
    }

    public void delete(String name) {
        for (List<IncidentNode> item : nodes.values()) {
            for (int i = 0; i < item.size(); i++) {
                if (item.get(i).node.name.equals(name)) {
                    item.remove(item.get(i));
                }
            }
        }
        nodes.remove(new Node(name));
    }

    public void deleteConnection(String node1, String node2) {
        Node n1 = new Node(node1);
        Node n2 = new Node(node2);
        List<IncidentNode> ln1 = nodes.get(n1);
        List<IncidentNode> ln2 = nodes.get(n2);
        if (ln1 != null) {
            for (IncidentNode item : ln1) {
                if (item.node.equals(n2)) {
                    ln1.remove(item);
                    break;
                }
            }
        }
        if (ln2 != null) {
            for (IncidentNode item : ln2) {
                if (item.node.equals(n1)) {
                    ln2.remove(item);
                    break;
                }
            }
        }
    }

    public List<String> getIncidents(String node) {
        List<String> list = new ArrayList<>();
        for (IncidentNode item : nodes.get(new Node(node))) {
            list.add(item.node.name);
        }
        return list;
    }

    public List<IncidentNode> getIncidentsWithWeight(String node) {
        return new ArrayList<>(nodes.get(new Node(node)));
    }

    public Set<String> depthFirstWalk(String node) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(node);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                for (IncidentNode v : nodes.get(new Node(current))) {
                    stack.push(v.node.name);
                }
            }
        }
        return visited;
    }

    public Set<String> breadthFirstWalk(String node) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(node);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (!visited.contains(current)) {
                visited.add(current);
                for (IncidentNode v : nodes.get(new Node(current))) {
                    queue.add(v.node.name);
                }
            }
        }
        return visited;
    }

    public Map<Node, List<IncidentNode>> getNodes() {
        return nodes;
    }
}
