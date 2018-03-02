package random.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GraphColoring {

	public static void main(String[] args) {
		BiGraph graph = buildGraph();
		displayGraph(graph, true);
		doColor(graph);
		System.out.println("***************SOLUTION ******************");
		displayGraph(graph, false);

	}

	private static void doColor(BiGraph graph) {
		boolean[] availableColors=new boolean[graph.getVertrices().size()];
		for(String key:graph.getVertrices().keySet()) {
			Arrays.fill(availableColors, true);
			BiDirectionalVertex currentVertex=graph.getVertrices().get(key);
			for(Edge e:currentVertex.getInBoundEdges()) {
				int color;
				if((color=graph.getVertrices().get(e.getFrom()).getColor()) != -1) {
					availableColors[color]=false;
				}
			}
			
			for(Edge e:currentVertex.getOutBoundEdges()) {
				int color;
				if((color=graph.getVertrices().get(e.getTo()).getColor()) != -1) {
					availableColors[color]=false;
				}
			}
			
			System.out.println(Arrays.toString(availableColors));
			for(int i=0;i<availableColors.length;i++) {
				if(availableColors[i]) {
					currentVertex.setColor(i);
					break;
				}
			}
		}
	}

	private static void displayGraph(BiGraph graph, boolean includeAllDetails) {
		for (String key : graph.getVertrices().keySet()) {
			BiDirectionalVertex vertex = graph.getVertrices().get(key);
			System.out.println("Vertex:" + vertex.getName() + " Color:"+vertex.getColor());
			if (includeAllDetails) {
				for (Edge e : vertex.getInBoundEdges()) {
					System.out.println(e.getFrom() + "--->" + e.getCost());
				}
				
				for (Edge e : vertex.getOutBoundEdges()) {
					System.out.println(e.getTo() + "--->" + e.getCost());
				}
			}
		}

	}

	private static BiGraph buildGraph() {
		Edge e1 = new Edge("A", "B", 1);
		Edge e2 = new Edge("A", "C", 1);
		Edge e3 = new Edge("B", "C", 1);
		Edge e4 = new Edge("B", "D", 1);
		Edge e5 = new Edge("C", "D", 1);
		Edge e6 = new Edge("D", "E", 1);
		
		Edge e11 = new Edge("B", "A", 1);
		Edge e22= new Edge("C", "A", 1);
		Edge e33 = new Edge("C", "B", 1);
		Edge e44 = new Edge("D", "B", 1);
		Edge e55 = new Edge("D", "C", 1);
		Edge e66 = new Edge("E", "D", 1);
		
		ArrayList<Edge> AOutEdges = new ArrayList<Edge>();
		AOutEdges.add(e1);
		AOutEdges.add(e2);
		
		ArrayList<Edge> AInEdges = new ArrayList<Edge>();
		AInEdges.add(e11);
		AInEdges.add(e22);
		
		ArrayList<Edge> BOutEdges = new ArrayList<Edge>();
		BOutEdges.add(e3);
		BOutEdges.add(e4);
		BOutEdges.add(e11);
		
		ArrayList<Edge> BInEdges = new ArrayList<Edge>();
		BInEdges.add(e33);
		BInEdges.add(e44);
		BInEdges.add(e1);
		
		ArrayList<Edge> CoutEdges = new ArrayList<Edge>();
		CoutEdges.add(e5);
		CoutEdges.add(e22);
		CoutEdges.add(e33);
		
		ArrayList<Edge> CInEdges = new ArrayList<Edge>();
		CInEdges.add(e55);
		CInEdges.add(e2);
		CInEdges.add(e3);
		
		ArrayList<Edge> DOutEdges = new ArrayList<Edge>();
		DOutEdges.add(e6);
		DOutEdges.add(e44);
		DOutEdges.add(e55);
		
		ArrayList<Edge> DInEdges = new ArrayList<Edge>();
		DInEdges.add(e66);
		DInEdges.add(e4);
		DInEdges.add(e5);

		ArrayList<Edge> EOutEdges = new ArrayList<Edge>();
		EOutEdges.add(e66);
		
		ArrayList<Edge> EInEdges = new ArrayList<Edge>();
		EInEdges.add(e6);

		
		BiDirectionalVertex a = new BiDirectionalVertex("A", Integer.MAX_VALUE, AInEdges,AOutEdges);
		BiDirectionalVertex b = new BiDirectionalVertex("B", Integer.MAX_VALUE, BInEdges,BOutEdges);
		BiDirectionalVertex c = new BiDirectionalVertex("C", Integer.MAX_VALUE, CInEdges,CoutEdges);
		BiDirectionalVertex d = new BiDirectionalVertex("D", Integer.MAX_VALUE, DInEdges,DOutEdges);
		BiDirectionalVertex e = new BiDirectionalVertex("E", Integer.MAX_VALUE, EInEdges,EOutEdges);
		HashMap<String, BiDirectionalVertex> vertices = new HashMap<String, BiDirectionalVertex>();
		vertices.put("A", a);
		vertices.put("B", b);
		vertices.put("C", c);
		vertices.put("D", d);
		vertices.put("E", e);
		BiGraph graph = new BiGraph(vertices);
		return graph;
	}
}

class BiGraph {

	private HashMap<String, BiDirectionalVertex> vertices = new HashMap<String, BiDirectionalVertex>();

	public BiGraph(HashMap<String, BiDirectionalVertex> vertrices) {
		super();
		this.vertices = vertrices;
	}

	public HashMap<String, BiDirectionalVertex> getVertrices() {
		return vertices;
	}

	public void setVertrices(HashMap<String, BiDirectionalVertex> vertices) {
		this.vertices = vertices;
	}

}

class BiDirectionalVertex {
	private String name;
	private int cost;
	private int color=-1;
	private List<String> shortestPath = new LinkedList<String>();
	private List<Edge> outBoundEdges = new LinkedList<Edge>();
	private List<Edge> inBoundEdges = new LinkedList<Edge>();

	public BiDirectionalVertex(String name, int cost, List<Edge> inBoundEdges,List<Edge> outBoundEdges) {
		super();
		this.name = name;
		this.cost = cost;
		this.inBoundEdges = inBoundEdges;
		this.outBoundEdges = outBoundEdges;
	}
	
	public BiDirectionalVertex(String name, int cost) {
		this(name,cost,null,null);
	}
	
	public BiDirectionalVertex(String name, int cost, List<Edge> inBoundEdges) {
		this(name,cost,inBoundEdges,null);
	}
	
	public BiDirectionalVertex(String name, List<Edge> outBoundEdges,int cost) {
		this(name,cost,null,outBoundEdges);
	}
	

	public String getName() {
		return name;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void setShortestPath(List<String> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public int getCost() {
		return cost;
	}

	public List<String> getShortestPath() {
		return shortestPath;
	}

	public List<Edge> getInBoundEdges() {
		return inBoundEdges;
	}
	
	public List<Edge> getOutBoundEdges() {
		return outBoundEdges;
	}

}
