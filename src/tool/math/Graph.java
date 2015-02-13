package tool.math;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;
    private boolean isDirected;
    private boolean isWeighted;

    public Graph() {
        this(false, false);
    }

    public Graph(boolean isDirected) {
        this(isDirected, false);
    }

    public Graph(boolean isDirected, boolean isWeighted) {
        this.nodes = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
    }

	public Graph copy() {
		Graph graph = new Graph();
        graph.nodes = nodes;
        graph.edges = edges;
        return graph;
	}

    public void load(int nbNodes, int[][] edges) {
        nodes = new ArrayList<Node>();
        for(int i = 0; i < nbNodes; i++) {
            add();
        }
        
        for(int i = 0; i < edges.length; i++) {
            this.edges.add(nodes.get(edges[i][0]).join(nodes.get(edges[i][1])));
        }
    }

	public String toString() {
        String str = "{ ";
        for(Edge edge : edges) {
            str += edge.toString();
            if(edges.indexOf(edge) < edges.size()-1) {
                str += " ";
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
            edges.add(nodes.get(a).join(nodes.get(b)));
            return true;
        }
        return false;
    }

    

}