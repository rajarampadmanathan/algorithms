package random.programs;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
class MinStopIdentifier {
	public static void main(String[] args) {
		System.out.println(new MinStopIdentifier().numBusesToDestination(new int[][] {{1,2,7},{3,6,7}}, 1, 6));
	}
    public int numBusesToDestination(int[][] routes, int S, int T) {
        
        HashMap<Integer, HashSet<Integer>> paths=new HashMap<Integer,HashSet<Integer>>();
        for(int i=0;i<routes.length;i++)
            for(int j=0;j<routes[i].length;j++)
            if(paths.containsKey(j))
                paths.get(j).add(i);
            else{
                HashSet<Integer> buses=new HashSet<Integer>();
                buses.add(i);
                paths.put(j,buses);
            }
        ArrayBlockingQueue<Point> queue=new ArrayBlockingQueue<Point>(10);
        HashSet<Integer> visited =new HashSet<Integer>();
        queue.add(new Point(S,0));
        visited.add(S);
        while(!queue.isEmpty() ){
            Point p=queue.poll();
            Arrays.asList(p.getClass().getDeclaredMethods()).stream().map(a->a.getName()).forEach(System.out::println);
            int bus=(int)p.getX();
            int stop=(int)p.getY();
            if(stop==T)
                return bus;
            for(int i:paths.get(stop))
                for(int j:routes[i])
                    if(!visited.contains(j)){
                        queue.offer(new Point(j,bus+1));
                        visited.add(j);
                    }
        }
        return -1;
        
    }
}