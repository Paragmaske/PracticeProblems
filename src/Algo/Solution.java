//package Algo;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//
//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode() {
//	}
//
//	TreeNode(int val) {
//		this.val = val;
//	}
//
//	TreeNode(int val, TreeNode left, TreeNode right) {
//		this.val = val;
//		this.left = left;
//		this.right = right;
//	}
//}
//
//public class Solution {
//	public static TreeNode createBinaryTree(int[][] descriptions) {
//		Set<Integer> l = new HashSet<Integer>();
//		Map<Integer,List<List<Integer>>> tr=new HashMap<>();
//		for (int[] d : descriptions) {
//
//			l.add(d[0]);
//			l.add(d[1]);
//
//			
//				List<List<Integer>> orDefault = tr.getOrDefault(d[0], new ArrayList<List<Integer>>());
//				Integer a=d[1];
//				Integer b=d[2];
//				List<Integer> ans=new ArrayList<Integer>();
//				ans.add(a);
//				ans.add(b);
//				orDefault.add(ans);
//				tr.put(d[0], orDefault);
//			
//		}
//
//		for (int[] d : descriptions) {
//			l.remove(d[1]);
//		}
//
//		int root = 0;
//		Iterator<Integer> it = l.iterator();
//		root = it.next();
//		System.out.println(root);
//		TreeNode t = new TreeNode(root);
//		generate(t,tr);
//		return t;
//
//	}
//
//
//
//
//
//
//
//	private static void generate(TreeNode t, Map<Integer, List<List<Integer>>> tr) {
//
//		
//		List<List<Integer>> list = tr.getOrDefault(t.val, new ArrayList<List<Integer>>());
//		
//		for(List<Integer> k:list)
//		{
//			if(k.get(1)==1)
//			{
//				t.left=new TreeNode(k.get(0));
//				generate(t.left, tr);
//			}
//			else if(k.get(1)==0)
//			{
//				t.right=new TreeNode(k.get(0));
//				generate(t.right, tr);
//			}
//		}
//	}
//
//
//
//
//
//
//
//	public static void main(String[] args) {
//		int[][] t = { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 }, { 80, 19, 1 } };
//		createBinaryTree(t);
//	}
//}
