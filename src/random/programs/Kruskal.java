package random.programs;

import java.util.LinkedList;
import java.util.TreeSet;

public class Kruskal {

	public static void main(String[] args) {
		SimpleGraph graph=addGraph();
		LinkedList<SimpleEdge> mst=kruskalMST(graph);
		printMST(mst);
	}

	static void printMST(LinkedList<SimpleEdge> mst) {
		for(SimpleEdge se: mst) {
			System.out.println(se.from+"---->"+se.to+" @"+se.cost);
		}
		
	}

	private static LinkedList<SimpleEdge> kruskalMST(SimpleGraph graph) {
		LinkedList<SimpleEdge> edges=new LinkedList<SimpleEdge>();
		LinkedList<Integer> addedVertices=new LinkedList<Integer>();
		for(SimpleEdge se:graph.edges) {
			boolean fromConnected = false;
			boolean toConnected = false;
			System.out.println(se.from+"----->"+se.to+"....."+addedVertices);
			
			for(int addedVertex:addedVertices) {
				if(addedVertex==se.to) {
					System.out.println("To connected");
					toConnected=true;
				}
				if(addedVertex==se.from) {
					System.out.println("From connected");
					fromConnected=true;
				}
				if(fromConnected && toConnected) {
					System.out.println("Forming loop");
					break;
					
				}
			}
			if(fromConnected && toConnected) {

			}else {
				edges.add(se);
				addedVertices.add(se.from);
				addedVertices.add(se.to);
			}
		}
		return edges;
		
	}

	private static SimpleGraph addGraph() {
		SimpleGraph graph = new SimpleGraph(4, 5);
		 
		SimpleEdge e1=new SimpleEdge();
	    e1.from = 0;
	    e1.to = 1;
	    e1.cost = 10;

	    SimpleEdge e2=new SimpleEdge();
	    e2.from = 0;
	    e2.to = 2;
	    e2.cost = 6;

	    SimpleEdge e3=new SimpleEdge();
	    e3.from = 0;
	    e3.to = 3;
	    e3.cost = 5;
	    
	    SimpleEdge e4=new SimpleEdge();
	    e4.from = 1;
	    e4.to = 3;
	    e4.cost = 15;

	    SimpleEdge e5=new SimpleEdge();
	    e5.from = 2;
	    e5.to = 3;
	    e5.cost = 4;
	    graph.addEdge(e1);
	    graph.addEdge(e2);
	    graph.addEdge(e3);
	    graph.addEdge(e4);
	    graph.addEdge(e5);
	    return graph;
	}
}

class SimpleGraph {

	int vNum, eNum;
	LinkedList<Integer>[] adjacentVertices;
	TreeSet<SimpleEdge> edges;

	SimpleGraph(int vNum, int eNum) {
		this.vNum = vNum;
		this.eNum = eNum;
		adjacentVertices = new LinkedList[vNum];
		for(int i=0;i<vNum;i++) {
			adjacentVertices[i]=new LinkedList<Integer>();
		}
		edges=new TreeSet<SimpleEdge>();
	}

	void addEdge(SimpleEdge e) {
		edges.add(e);
		adjacentVertices[e.from].add(e.to);
		adjacentVertices[e.to].add(e.from);
	}
}

class SimpleEdge implements Comparable<SimpleEdge> {
	int from;
	int to;
	int cost;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SimpleEdge) {
			SimpleEdge obj2 = (SimpleEdge) obj;
			if (obj2.from == this.from && obj2.to == this.to) {
				return true;
			} else if (obj2.from == this.to && obj2.to == this.from) {
				return true;
			} else
				return false;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(SimpleEdge o) {
		return Integer.compare(this.cost, o.cost);
	}
}