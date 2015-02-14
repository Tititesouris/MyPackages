package tool.math;

import java.util.ArrayList;

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
        this(new ArrayList<Node>(), new ArrayList<Edge>(), isDirected, isWeighted);
    }

    public Graph(ArrayList<Node> nodes, ArrayList<Edge> edges, boolean isDirected, boolean isWeighted) {
        this.nodes = nodes;
        this.edges = edges;
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
    }

	public Graph copy() {
        Object[] save = save();
        Graph graph = new Graph(isDirected, isWeighted);
        graph.load(((Integer) save[0]).intValue(), (int[][]) save[1]);
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

    public Object[] save() {
        int[][] edges = new int[this.edges.size()][2];
        int i = 0;
        for(Edge edge : this.edges) {
            edges[i][0] = nodes.indexOf(edge.getParent());
            edges[i][1] = nodes.indexOf(edge.getChild());
            i++;
        }
        Object[] save = new Object[2];
        save[0] = nodes.size();
        save[1] = edges;
        return save;
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

    public boolean hasNode() {
        return nodes.size() > 0;
    }

    public boolean hasEdge() {
        return edges.size() > 0;
    }
/*
    public boolean isConnected() {
        if(hasNode()) {
            Node node = nodes.get(0);
        }
    }

    public boolean hasEulerianPath() {
        if (hasNode()) { // TODO: Is that true?
            if (isDirected) {
                Graph graph = copy();
                Node node = graph.nodes.get(0);
                while(node.getOutDegree() > 0) {
                    node.popOut();
                }
            }
        }
    }

    public boolean hasEulerianPath() {
        if(!isDirected) {
            int nbOdds = 0;
            for (Node node : nodes) {
                if (node.getDegree() % 2 != 0) {
                    if (++nbOdds > 2) {
                        return false;
                    }
                }
            }
            return true;
        }
        int nbInOut = 0, nbOutIn = 0;
        for (Node node : nodes) {
            if (node.getInDegree() - node.getOutDegree() == 1) {
                nbInOut++;
            }
            else if (node.getOutDegree() - node.getInDegree() == 1) {
                nbOutIn++;
            }
            if(nbInOut > 1 || nbOutIn > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean hasEulerianCycle() {
        if(!isDirected) {
            for (Node node : nodes) {
                if (node.getDegree() % 2 != 0) {
                    return false;
                }
            }
            return true;
        }
        for (Node node : nodes) {
            if (node.getInDegree() != node.getOutDegree()) {
                return false;
            }
        }
        return true;
    }
*/
}