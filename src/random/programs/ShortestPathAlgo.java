package random.programs;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class ShortestPathAlgo {

	public static void main(String[] args) {
			
		System.out.println(shortestpath(new int[][]{{1,2,3},{0},{0},{0}}));
		System.out.println(shortestpath(new int[][]{{1},{0,2,4},{1,3,4},{2},{1,2}}));
	}
	
	private static int shortestpath(int[][] graph) {
		int n=graph.length;
		Set<Tuple> set=new HashSet<>();
		ArrayDeque<Tuple> queue=new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			int t=1<<i;
			set.add(new Tuple(i, 0,t));
			queue.add(new Tuple(i, 1,t));
		}
		while(!queue.isEmpty()) {
			Tuple tuple= queue.poll();
			System.out.println("Tuple:"+tuple.index+" ###Cost:"+tuple.cost+"### bit:"+tuple.bit);
			if(tuple.bit ==(1<<n)-1)
				return tuple.cost-1;
			else {
				int[] neighbours=graph[tuple.index];
				for(int neighbour:neighbours) {
					int bit=tuple.bit;
					bit=bit | (1<< neighbour);
					System.out.println(bit);
					Tuple t=new Tuple(neighbour, tuple.cost+1, bit);
					if(!set.contains(t)) {
						set.add(t);
						queue.add(t);
					}
				}
			}
			
		}
		
		return -1;
	}

	static class Tuple {
		private int index;
		private int cost;
		private int bit;

		public Tuple(int index, int cost, int bit) {
			super();
			this.index = index;
			this.cost = cost;
			this.bit = bit;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Tuple) {
				Tuple tp = (Tuple) obj;
				return tp.bit == this.bit && tp.cost == this.cost && tp.index == this.index;
			}
			return false;
		}

		@Override
		public int hashCode() {
			int result = 1;
			result = (result * 31) + index;
			result = (result * 31) + cost;
			result = (result * 31) + bit;
			return result;
		}

	}
}
