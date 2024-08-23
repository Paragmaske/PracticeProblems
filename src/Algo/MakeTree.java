package Algo;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class MakeTree {
	public static void main(String[] args) {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };

		Map<Integer, Integer> inPosMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inPosMap.put(inorder[i], i);
		}
		makeorder(preorder, inorder, inPosMap, 0, inorder.length, 0);
	}

	private static TreeNode makeorder(int[] preorder, int[] inorder, Map<Integer, Integer> inPosMap, int start, int end,
			int curr) {
		if (curr >= preorder.length || start > end) return null;
		int rootIndex = inPosMap.get(preorder[curr]);
		TreeNode t = new TreeNode(preorder[curr]);
		t.left = makeorder(preorder, inorder, inPosMap, start, rootIndex - 1, curr + 1);
		t.right = makeorder(preorder, inorder, inPosMap, rootIndex + 1, end, curr+ rootIndex + 1 - start);
		return t;

	}

}
