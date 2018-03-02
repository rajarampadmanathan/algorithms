package random.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class SkyLineView {

	public static void main(String[] args) {
		int[][] buildingsArray = { { 1, 3, 4 }, { 3, 4, 4 }, { 2, 6, 2 }, { 8, 11, 4 }, { 7, 9, 3 }, { 10, 11, 2 } };
		Wall[] walls = new Wall[buildingsArray.length * 2];
		int i = 0;
		Wall wall;
		for (int[] buildingDetails : buildingsArray) {
			wall = new Wall(buildingDetails[0], buildingDetails[2], true);
			walls[i++] = wall;
			wall = new Wall(buildingDetails[1], buildingDetails[2], false);
			walls[i++] = wall;
		}
		Arrays.sort(walls);
		TreeMap<Integer, Integer> queue = new TreeMap<Integer, Integer>();
		queue.put(0, 1);
		ArrayList<int[]> results = new ArrayList<int[]>();
		int lastHt = 0;
		for (Wall eachWall : walls) {
			System.out.println(eachWall.getX()+","+eachWall.getHeight()+"-"+eachWall.start);
			if (eachWall.start) {
				queue.compute(eachWall.height, (key, value) -> {
					if (value == null)
						return 1;
					else
						return value + 1;
				});
			} else {
				queue.compute(eachWall.height, (key, value) -> {
					if (value == 1)
						return null;
					else
						return value - 1;
				});
			}
			int currentMaxHt= queue.lastKey();
			if ( lastHt != currentMaxHt) {
				results.add(new int[] { eachWall.x, currentMaxHt });
				lastHt = currentMaxHt;
			}
			
		}

		for (int[] point : results) {
			System.out.println(point[0] + "," + point[1]);
		}
	}

	static class Wall implements Comparable<Wall> {

		int x;
		int height;
		boolean start;

		public Wall(int x, int height, boolean start) {
			super();
			this.x = x;
			this.height = height;
			this.start = start;
		}

		public int getX() {
			return x;
		}

		public int getHeight() {
			return height;
		}

		@Override
		public int compareTo(Wall wall) {
			if (this.x != wall.x) {
				return this.x - wall.x;
			}
			return (this.start ? -this.height : this.height) - (wall.start ? -wall.height : wall.height);
		}

	}
}
