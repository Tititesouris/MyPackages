package tool.math;

class Edge {

	private Node parent;
	private Node child;
    private double value;

	public Edge(Node parent, Node child) {
		this(parent, child, 0.0);
	}

    public Edge(Node parent, Node child, double value) {
        this.parent = parent;
        this.child = child;
        this.value = value;
    }

	public String toString() {
		return parent.toString()+"-["+value+"]-"+child.toString();
	}

	public Node getParent() {
		return parent;
	}

	public Node getChild() { return child; }

	public double getValue() {
		return value;
	}

}