package tool.math;

class Edge {

	private Node parent;
	private Node child;
    private double value;

	public Edge(Node parent, Node child) {
		this.parent = parent;
		this.child = child;
        this.value = 0.0;
	}

	public String toString() {
		return parent.toString()+"-["+value+"]-"+child.toString();
	}

	public Node getParent() {
		return parent;
	}

	public Node getChild() {
		return child;
	}

}