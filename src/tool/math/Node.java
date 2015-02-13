package tool.math;

import java.util.ArrayList;

class Node {

	private ArrayList<Edge> ins;
	private ArrayList<Edge> outs;
	private String value;

	public Node() {
		ins = new ArrayList<Edge>();
		outs = new ArrayList<Edge>();
		value = "A";
	}

	public Node(String value) {
		this();
        this.value = value;
	}

	public String toString() {
		return "("+value+")";
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

	public String getValue() { return value; }

    public Edge popIn() {
        if(ins.size() > 0) {
            return ins.remove(0);
        }
        return null;
    }

    public Edge popOut() {
        if(outs.size() > 0) {
            return outs.remove(0);
        }
        return null;
    }

    public int getInDegree() { return ins.size(); }

    public int getOutDegree() { return outs.size(); }

    public int getDegree() { return getInDegree()+getOutDegree(); }

}