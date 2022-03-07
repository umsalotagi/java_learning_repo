package com.example.treedatastructure;

public class TreeNode {
	private int data;
	private TreeNode leftNode;
	private TreeNode rightNode;
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public TreeNode getLeftNode() {
		return leftNode;
	}
	public TreeNode getRightNode() {
		return rightNode;
	}
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	
	public TreeNode search(int data) {
		if (this.data==data) {
			return this;
		} else if (this.data>data && leftNode!=null) {
			return leftNode.search(data);
		} else if (this.data<data) {
			return rightNode.search(data);
		} else {
			return null;
		}
	}
	
	// these are depth first tree traversal algorithm
	public void traversalInOrder() {
		if (this.leftNode!=null) {
			leftNode.traversalInOrder();
		}
		System.out.print(this.data+" ");
		if (this.rightNode!=null) {
			rightNode.traversalInOrder();
		}
	}
	
	public int treeHeight(TreeNode x) {
		if (x!=null) {
			int h1 = treeHeight(x.leftNode);
			int h2 = treeHeight(x.rightNode);
			if (h1>h2) {
				return 1+h1;
			} else {
				return 1+h2;
			}
		} else {
			return 0;
		}
	}
	
	// breadth first algorithm
	public void breadthTreeTraversal(TreeNode root) {
		int dept = treeHeight(root);
		for (int i=0; i<=dept; i++) {
			levelTreeTraversal(root, i);
		}
	}
	
	public void levelTreeTraversal(TreeNode root, int level) {
		if (root==null)
			return;
		if (level==1)
			System.out.print(root.data + " ");
		else if (level>0) {
			levelTreeTraversal(root.leftNode, level-1);
			levelTreeTraversal(root.rightNode, level-1);
		}
	}
	
	
	

}
