package dissertation.routetracker;

import java.util.ArrayList;

public class Nav_Graph {
    private ArrayList<Node> nodes;
    public Nav_Graph() {
        this.nodes = new ArrayList<>();
    }
    public void addNode(Node node) {
        this.nodes.add(node);
    }
    public Node getNode(String ID) {
        Node node = null;
        for (Node n : nodes) {
            if (n.getID().equals(ID)) {
                node = n;
                break;
            }
        }
        return node;
    }
    public boolean hasNode(String s) {
        boolean node = false;
        for (Node n : nodes) {
            if (n.getID().equals(s)) {
                node = true;
                break;
            }
        }
        return node;
    }
}
