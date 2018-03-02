package random.programs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class Prims {

	public static void main(String[] args) {
		
		System.out.println(Integer.toBinaryString(-3));
		System.out.println(-1>>32);
		//primsMST();
		//printMST();
	}

	private static void printMST() {
		for (int i = 1; i < processedVertex.length; i++) {
			System.out.println(parentVertex[i] + "---->" + i + " @" + processedCost[i]);
		}

	}

	private static void primsMST() {
		int i = 0;
		while (i >= 0) {
			for (int j = 0; j < graph[i].length; j++) {
				if (graph[i][j] > 0 && !processedVertex[j]
						&& (processedCost[j] == 0 || graph[i][j] < processedCost[j])) {
					parentVertex[j] = i;
					processedCost[j] = graph[i][j];
				}
			}
			processedVertex[i] = true;
			int minCost = Integer.MAX_VALUE;
			i = -1;
			for (int k = 0; k < graph.length; k++) {
				if (!processedVertex[k] && processedCost[k] > 0 && processedCost[k] < minCost) {
					i = k;
					minCost=processedCost[k];
				}
			}
		}
	}

	/*
	 * static int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, {
	 * 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 }, { 0, 5, 7, 9, 0 }, };
	 */
	static int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
			{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
			{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
			{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
	static boolean[] processedVertex = new boolean[graph.length];
	static int[] processedCost = new int[graph.length];
	static int[] parentVertex = new int[graph.length];

}
