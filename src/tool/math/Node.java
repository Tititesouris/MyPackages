package tool.math;

import java.util.ArrayList;

class Node {

	private static int nbNodes;

	private ArrayList<Edge> ins;
	private ArrayList<Edge> outs;
	private int id;

	public Node() {
		ins = new ArrayList<Edge>();
		outs = new ArrayList<Edge>();
		id = nbNodes++;
	}

	public Node(ArrayList<Edge> ins, ArrayList<Edge> outs) {
		this();
		this.ins = ins;
		this.outs = outs;
	}

	public String toString() {
		return "("+id+")";
	}

    public Edge join(Node node) {
        Edge edge = new Edge(this, node);
        addOut(edge);
        node.addIn(edge);
        return edge;
    }

	private void addIn(Edge edge) {
        if(!ins.contains(edge)) {
            ins.add(edge);
        }
	}

	private void addOut(Edge edge) {
        if(!outs.contains(edge)) {
            outs.add(edge);
        }
	}

	public int getId() { return id; }

    public int getInDegree() { return ins.size(); }

    public int getOutDegree() { return outs.size(); }

    public int getDegree() { return getInDegree()+getOutDegree(); }

}