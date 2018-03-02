package random.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Dijikstras {

	public static void main(String[] args) {
		Graph graph = buildGraph();
		displayGraph(graph, true);
		findShortestPath(graph);
		System.out.println("***************SOLUTION ******************");
		displayGraph(graph, false);
		
		/*HashMap<Object,Object> hs=new HashMap<>();
		System.out.println(hs.put("1","A"));
		System.out.println(hs.put("1","B"));*/

	}

	private static void findShortestPath(Graph graph) {
		LinkedList<Vertex> processingQueue = new LinkedList<Vertex>();
		Vertex currentVertex = graph.getVertrices().get("A");
		currentVertex.setCost(0);
		processingQueue.add(currentVertex);
		while (processingQueue.size() > 0) {
			currentVertex = processingQueue.poll();
			for (Edge e : currentVertex.getEdges()) {
				String to = e.getTo();
				int toCost = e.getCost() + currentVertex.getCost();
				if (toCost < graph.getVertrices().get(to).getCost()) {
					graph.getVertrices().get(to).setCost(toCost);
					List<String> currentShortestPath = new LinkedList<String>(currentVertex.getShortestPath());
					currentShortestPath.add(e.getFrom());
					graph.getVertrices().get(to).setShortestPath(currentShortestPath);
					processingQueue.add(graph.getVertrices().get(to));
				}
			}
		}
	}

	private static void displayGraph(Graph graph, boolean includeAllDetails) {
		for (String key : graph.getVertrices().keySet()) {
			Vertex vertex = graph.getVertrices().get(key);
			System.out.println("Vertex:" + vertex.getName() + "   Shortest path:" + vertex.getShortestPath() + " at cost :"
					+ vertex.getCost());
			if (includeAllDetails) {
				for (Edge e : vertex.getEdges()) {
					System.out.println(e.getTo() + "--->" + e.getCost());
				}
			}
		}

	}

	private static Graph buildGraph() {
		Edge e1 = new Edge("A", "B", 10);
		Edge e2 = new Edge("A", "C", 15);
		Edge e3 = new Edge("B", "F", 15);
		Edge e4 = new Edge("B", "D", 12);
		Edge e5 = new Edge("D", "F", 1);
		Edge e6 = new Edge("D", "E", 2);
		Edge e7 = new Edge("F", "E", 5);
		Edge e8 = new Edge("C", "E", 10);
		ArrayList<Edge> AEdges = new ArrayList<Edge>();
		AEdges.add(e1);
		AEdges.add(e2);
		ArrayList<Edge> BEdges = new ArrayList<Edge>();
		BEdges.add(e3);
		BEdges.add(e4);
		ArrayList<Edge> CEdges = new ArrayList<Edge>();
		CEdges.add(e8);
		ArrayList<Edge> DEdges = new ArrayList<Edge>();
		DEdges.add(e5);
		DEdges.add(e6);
		ArrayList<Edge> FEdges = new ArrayList<Edge>();
		FEdges.add(e7);
		ArrayList<Edge> EEdges = new ArrayList<Edge>();
		Vertex a = new Vertex("A", Integer.MAX_VALUE, AEdges);
		Vertex b = new Vertex("B", Integer.MAX_VALUE, BEdges);
		Vertex c = new Vertex("C", Integer.MAX_VALUE, CEdges);
		Vertex d = new Vertex("D", Integer.MAX_VALUE, DEdges);
		Vertex e = new Vertex("E", Integer.MAX_VALUE, EEdges);
		Vertex f = new Vertex("F", Integer.MAX_VALUE, FEdges);
		HashMap<String, Vertex> vertices = new HashMap<String, Vertex>();
		vertices.put("A", a);
		vertices.put("B", b);
		vertices.put("C", c);
		vertices.put("D", d);
		vertices.put("E", e);
		vertices.put("F", f);
		Graph graph = new Graph(vertices);
		return graph;
	}
}

class Graph {

	private HashMap<String, Vertex> vertices = new HashMap<String, Vertex>();

	public Graph(HashMap<String, Vertex> vertrices) {
		super();
		this.vertices = vertrices;
	}

	public HashMap<String, Vertex> getVertrices() {
		return vertices;
	}

	public void setVertrices(HashMap<String, Vertex> vertices) {
		this.vertices = vertices;
	}

}

class Vertex {
	private String name;
	private int cost;
	private List<String> shortestPath = new LinkedList<String>();
	private List<Edge> edges = new LinkedList<Edge>();

	public Vertex(String name, int cost, List<Edge> edges) {
		super();
		this.name = name;
		this.cost = cost;
		this.edges = edges;
	}

	public String getName() {
		return name;
	}

	public void setCost(int cost) {
		this.cost = cost;
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

	public List<Edge> getEdges() {
		return edges;
	}

}

class Edge {
	private String from;
	private String to;
	private int cost;

	public Edge(String from, String to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public int getCost() {
		return cost;
	}

}