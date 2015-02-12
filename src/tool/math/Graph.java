package tool.math;

import java.util.ArrayList;

public class Graph {

	private ArrayList<Node> nodes;
    private boolean isDirected;
    private boolean isWeighted;

    public Graph() {
        this(new ArrayList<Node>(), false, false);
    }

    public Graph(ArrayList<Node> nodes) {
        this(nodes, false, false);
    }

    public Graph(boolean isDirected) {
        this(new ArrayList<Node>(), isDirected, false);
    }

    public Graph(boolean isDirected, boolean isWeighted) {
        this(new ArrayList<Node>(), isDirected, isWeighted);
    }

    public Graph(ArrayList<Node> nodes, boolean isDirected, boolean isWeighted) {
        this.nodes = nodes;
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
    }

	public Graph copy() {
		Graph graph = new Graph();
        graph.nodes = nodes;
        return graph;
	}

	public String toString() {
        String str = "{ ";
        for(Node node : nodes) {
            str += node.toString();
            if(nodes.indexOf(node) < nodes.size()-1) {
                str += ", ";
            }
        }
        return str+" }";
	}

    public void add() {
        nodes.add(new Node());
    }

    public boolean add(Node node) {
        if(!nodes.contains(node)) {
            nodes.add(node);
            return true;
        }
        return false;
    }

    public boolean join(int a, int b) {
        if(0 <= a && a <= b && b < nodes.size()) {
            nodes.get(a).join(nodes.get(b));
            return true;
        }
        return false;
    }

}