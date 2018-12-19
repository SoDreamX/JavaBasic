package cn.sxh.arithmetic.tree.rbTree;

import org.junit.Test;

public class TestRBTree {
	@Test
	public void rbTree() {
		RBTree<Integer> tree = new RBTree<>();
		int[] keys = {13,8,17,1,11,15,25,6,22,27};
		for(int key:keys) {
			tree.insert(key);
		}
		tree.infixOrder(tree.getRoot());
		//≤Â»Î21
		tree.insert(21);
		System.out.println();
		tree.infixOrder(tree.getRoot());
	}
}
