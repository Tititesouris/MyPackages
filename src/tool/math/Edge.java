package tool.math;

class Edge {

	private Node parent;
	private Node child;

	public Edge(Node parent, Node child) {
		this.parent = parent;
		this.child = child;
	}

	public String toString() {
		return parent.toString()+"---"+child.toString();
	}

	public Node getParent() {
		return parent;
	}

	public Node getChild() {
		return child;
	}

}