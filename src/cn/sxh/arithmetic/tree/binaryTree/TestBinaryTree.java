package cn.sxh.arithmetic.tree.binaryTree;

import org.junit.Test;

public class TestBinaryTree {
	@Test
	public void test() {
		BinaryTree tree = new BinaryTree();
		tree.insert(10);
		tree.insert(8);
		tree.insert(15);
		tree.insert(4);
		tree.insert(9);
		tree.insert(20);
		tree.insert(11);
		tree.insert(5);
		
		Node node = tree.find(10);
		System.out.println(node.display());
		tree.infixOrder(node);
		System.out.println();
		tree.preOrder(node);
		System.out.println();
		tree.postOrder(node);
		System.out.println();
		
		tree.draw();
		
		System.out.println(tree.findMax().display());
		System.out.println(tree.findMin().display());
		
		tree.delete(9);
		tree.draw();
		tree.delete(4);
		tree.draw();
		tree.delete(15);
		tree.draw();
	}
}
