package com.example.treedatastructure;

// tree in which each node have at max two children
// no children node :  is leaf node
// level start from 0 .. to n .. level 0 us  top node
public class BinarySearchTree {
	
	private TreeNode root;
	
	public TreeNode find(int data) {
		if (root!=null)
			return root.search(data);
		else
			return null;
	}
	
	public void inOrderTraversal() {
		this.root.traversalInOrder();
	}
	
	public void setTreeNode() {
		TreeNode x = new TreeNode(1);
		TreeNode y = new TreeNode(2);
		y.setLeftNode(new TreeNode(4));
		y.setRightNode(new TreeNode(5));
		TreeNode z = new TreeNode(3);
		z.setLeftNode(new TreeNode(6));
		z.setRightNode(new TreeNode(7));
		x.setLeftNode(y);
		x.setRightNode(z);
		this.root = x;
		
	}
	
	public void breadthTreeTraversal() {
		this.root.breadthTreeTraversal(root);
	}
	
	
	

}
