package Algo;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	static int maxLength;
	TreeNode root;

	static class TreeNode {

		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		TreeNode rootTreeNode = new TreeNode(1);
		rootTreeNode.left = new TreeNode(2);
		rootTreeNode.left.left = new TreeNode(4);
		rootTreeNode.left.right = new TreeNode(5);

		rootTreeNode.right = new TreeNode(3);
		rootTreeNode.right.left = new TreeNode(6);
		rootTreeNode.right.right = new TreeNode(7);
		System.out.println(countPairs(rootTreeNode, 3));
	}

	public static int countPairs(TreeNode root, int distance) {
		int ans=0;
		List<Integer> leafTreeNodes = new ArrayList<Integer>();
		countPairs1(root, distance, leafTreeNodes);
		for (int i = 0; i < leafTreeNodes.size(); i++) {
			for (int j = i + 1; j < leafTreeNodes.size(); j++) {
				TreeNode commonAncestor = commonAncestor(leafTreeNodes.get(i), leafTreeNodes.get(j), root);
				Integer cdist = calDistance(commonAncestor.data, root, 0);
				Integer first = calDistance(leafTreeNodes.get(i), root, 0);
				Integer second = calDistance(leafTreeNodes.get(j), root, 0);
				int cu=first + second - (2 * cdist) ;
				if(cu<=distance)
				{
					ans=ans+1;
				}
			}
		}
		return ans;

	}

	private static Integer calDistance(Integer integer, TreeNode root, Integer dist) {
		if (root == null) {
			return -1;
		}
		if (root.data == integer) {
			return dist;
		}
		int d = calDistance(integer, root.left, dist + 1);
		if (d != -1) {
			return d;
		}
		d = calDistance(integer, root.right, dist + 1);

		return d;
	}

	private static TreeNode commonAncestor(Integer firstTreeNode, Integer secondTreeNode, TreeNode root) {

		if (root == null || root.data == secondTreeNode || root.data == firstTreeNode) {
			return root;
		}

		TreeNode left = commonAncestor(firstTreeNode, secondTreeNode, root.left);
		TreeNode right = commonAncestor(firstTreeNode, secondTreeNode, root.right);

		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else {
			return root;
		}

	}

	public static TreeNode countPairs1(TreeNode root, int distance, List<Integer> leafTreeNodes) {
		if (root == null)
			return null;

		root.left = countPairs1(root.left, distance, leafTreeNodes);
		root.right = countPairs1(root.right, distance, leafTreeNodes);
		if (root.left == null && root.right == null) {
			leafTreeNodes.add(root.data);
		}
		return root;
	}

	public static String getDirections(TreeNode root, int startValue, int destValue) {
		return null;

	}

	private static int binaryTreeTreeNodeMAXpathSum(TreeNode rootTreeNode) {
		List<TreeNode> allElements = new ArrayList<TreeNode>();
		getAllElements(rootTreeNode, allElements);

		return maxLength;

	}

	private static void getAllElements(TreeNode rootTreeNode, List<TreeNode> arrayList) {

		if (rootTreeNode != null) {
			getAllElements(rootTreeNode.left, arrayList);
			arrayList.add(rootTreeNode);
			getAllElements(rootTreeNode.right, arrayList);
		}
	}

	private static void topView(TreeNode rootTreeNode, String lefti) {

		if (rootTreeNode == null) {
			return;
		}
		System.out.println(rootTreeNode.data);
		if (lefti == "left") {
			topView(rootTreeNode.left, lefti);
		} else {
			topView(rootTreeNode.right, lefti);
		}
	}

	private static void diameter(TreeNode rootTreeNode) {
		maxLength = 0;
		System.out.println(dfs(rootTreeNode));

	}

	private static int dfs(TreeNode rootTreeNode) {

		if (rootTreeNode == null) {
			return maxLength;
		}
		int dfsLeft = dfs(rootTreeNode.left);
		int right = dfs(rootTreeNode.right);
		maxLength = Math.max(maxLength, right + dfsLeft);
		return 1 + Math.max(dfsLeft, right);

	}
}
