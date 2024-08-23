package Shortest;

import java.io.*;
import java.util.*;

//JAVA program to print all
//paths from a source to
//destination.
import java.util.ArrayList;
import java.util.List;

public class Graph {

	// No. of vertices in graph
	private int v;

	// adjacency list
	private ArrayList<Integer>[] adjList;

	// Constructor
	public Graph(int vertices)
	{

		// initialise vertex count
		this.v = vertices;

		// initialise adjacency list
		initAdjList();
	}

	// utility method to initialise
	// adjacency list
	@SuppressWarnings("unchecked")
	private void initAdjList()
	{
		adjList = new ArrayList[v];

		for (int i = 0; i < v; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	// add edge from u to v
	public void addEdge(int u, int v)
	{
		// Add v to u's list.
		adjList[u].add(v);
	}

	// Prints all paths from
	// 's' to 'd'
	public void printAllPaths(int s, int d)
	{
		boolean[] isVisited = new boolean[v];
		ArrayList<Integer> pathList = new ArrayList<>();

		// add source to path[]
		pathList.add(s);

		// Call recursive utility
		printAllPathsUtil(s, d, isVisited, pathList);
	}

	private void printAllPathsUtil(Integer u, Integer d,
								boolean[] isVisited,
								List<Integer> localPathList)
	{

		if (u.equals(d)) {
			System.out.println(localPathList);
			return;
		}

		isVisited[u] = true;

		for (Integer i : adjList[u]) {
			if (!isVisited[i]) {
				localPathList.add(i);
				printAllPathsUtil(i, d, isVisited, localPathList);

				localPathList.remove(i);
			}
		}

		isVisited[u] = false;
	}

	public static void main(String[] args)
	{
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(1, 3);

		int s = 2;

		int d = 3;

		System.out.println(
			"Following are all different paths from "
			+ s + " to " + d);
		g.printAllPaths(s, d);
	}
}

