//package Algo;
//
//import java.util.*;
//import java.util.LinkedList;
//
//public class HarMaidanFateh {
//	static Map<Integer, List<Integer>> adjList = new HashMap<>();
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int postsInMaze = sc.nextInt();
//		for (int i = 1; i <= postsInMaze; i++) {
//			adjList.put(i, new ArrayList<Integer>());
//		}
//		for (int i = 0; i < postsInMaze - 1; i++) {
//
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			adjList.get(a).add(b);
//			adjList.get(b).add(a);
//
//		}
//		sc.nextLine();
//		String type = sc.nextLine();
//
//		char[] colorArray = type.toCharArray();
//		int no0fRed = 0;
//		for (char ch : colorArray) {
//			if (ch == 'R')
//
//			{
//				no0fRed += 1;
//			}
//		}
//		boolean[] visited = new boolean[postsInMaze + 1];
//		for (int i = 1; i <= postsInMaze; i++) {
//			System.out.println(calMaxDist(i, Arrays.copyOf(visited, visited.length), no0fRed, colorArray));
//		}
//	}
//
//	private static int calMaxDist(int i, boolean[] visited, int no0fRed, char[] colorArray) {
//
//		Queue<Integer> qu = new LinkedList<Integer>();
//
//		int count = 0;
//		int maxRedToGreen = (no0fRed / 2) * 2;
//		boolean flag = false;
//		if (maxRedToGreen >= 2) {
//			flag = true;
//		}
//		if (colorArray[i - 1] == 'R' && maxRedToGreen == 0) {
//
//		} else if (colorArray[i - 1] == 'R' && maxRedToGreen > 0) {
//			qu.add(i);
//			maxRedToGreen--;
//		} else {
//			qu.add(i);
//			visited[i] = true;
//		}
//		while (!qu.isEmpty()) {
//
//			Integer remove = qu.remove();
//			count++;
//			for (int k : adjList.get(remove)) {
//				if (visited[k] == false) {
//					if (colorArray[k - 1] == 'G') {
//						visited[k] = true;
//						qu.add(k);
//					} else if (colorArray[k - 1] == 'R' && flag == true && maxRedToGreen > 0) {
//						visited[k] = true;
//						qu.add(k);
//						maxRedToGreen--;
//					}
//				}
//			}
//		}
//		return count;
//	}
//}
