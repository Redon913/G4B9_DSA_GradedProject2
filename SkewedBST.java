class ND {
	int data;
	ND left, right;

	public ND(int data) {
		this.data = data;
		left = right = null;
	}
}

class SkewedBST {
	ND node;
	ND prevNode = null;
	ND headNode = null;

	void convertToSkewed(ND root) {

		if (root == null) {
			return;
		}

		convertToSkewed(root.left);

		ND rightNode = root.right;
		ND leftNode = root.left;

		if (this.headNode == null) {
			this.headNode = root;
			root.left = null;
			this.prevNode = root;
		} else {
			this.prevNode.right = root;
			root.left = null;
			this.prevNode = root;
		}

		convertToSkewed(rightNode);

	}

	void printAscending(ND root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		printAscending(root.right);
	}

	public static void main(String[] args) {

		SkewedBST tree = new SkewedBST();
		tree.node = new ND(50);
		tree.node.left = new ND(30);
		tree.node.right = new ND(60);
		tree.node.left.left = new ND(10);
		tree.node.right.left = new ND(55);

		tree.convertToSkewed(tree.node);
		tree.printAscending(tree.headNode);
	}
}