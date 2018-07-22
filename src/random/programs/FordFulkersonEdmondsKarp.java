package random.programs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FordFulkersonEdmondsKarp {

	public static void main(String[] args) {
		System.out.println(findMaxFlow(new int[][] { { 0, 16, 13, 0, 0, 0 }, { 0, 0, 10, 12, 0, 0 },
				{ 0, 4, 0, 0, 14, 0 }, { 0, 0, 9, 0, 0, 20 }, { 0, 0, 0, 7, 0, 4 }, { 0, 0, 0, 0, 0, 0 } }, 0, 5));
	}

	private static int findMaxFlow(int[][] is, int s, int d) {
		int result = 0;

		boolean cont = true;
		while (cont) {
			cont = false;
			Set<Integer> vis = new HashSet<>();
			Queue<Integer> que = new ArrayDeque<>();
			Map<Integer, Integer> pMap = new HashMap<>();
			que.add(s);
			vis.add(s);
			while (!que.isEmpty()) {
				int c = que.poll();
				if (c == d) {
					result += modfiyValue(is, pMap, s, d);
					cont = true;
					break;
				} else {
					for (int n=0;n<is[c].length;n++) {
						if (is[c][n] >0 && !vis.contains(n)) {
							pMap.put(n,c);
							vis.add(n);
							que.add(n);
						}
					}
				}

			}

		}
		return result;
	}

	private static int modfiyValue(int[][] is, Map<Integer, Integer> pMap, int s, int d) {
		Arrays.stream(is).map(Arrays::toString).forEach(System.out::println);
		System.out.println(pMap);
		System.out.println("s:"+s+":::::d:"+d);
		int st = d;
		List<Integer> ls = new ArrayList<>();
		int minVal = Integer.MAX_VALUE;
		ls.add(st);
		while (st != s) {
			ls.add(pMap.get(st));
			int temp = is[pMap.get(st)][st];
			if (temp < minVal)
				minVal = temp;
			st = pMap.get(st);
		}
		System.out.println("MinVal:"+minVal);
		System.out.println("Route:"+ls);
		for (int i = 1; i < ls.size(); i++) {
			is[ls.get(i)][ls.get(i - 1)] -= minVal;
			is[ls.get(i - 1)][ls.get(i)] += minVal;
		}
		Arrays.stream(is).map(Arrays::toString).forEach(System.out::println);
		return minVal;
	}
}
