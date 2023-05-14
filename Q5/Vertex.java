import java.util.ArrayList;
import java.util.List;

public class Vertex<T extends Comparable<T>> {
	T vertexInfo;
	int indeg;
	int outdeg;
	Vertex<T> nextVertex;
	Edge<T> firstEdge;
	boolean visited;
	List<Vertex<T>> neighbors = new ArrayList<>();
	
	public Vertex() {
		vertexInfo = null;
		indeg = 0;
		outdeg = 0;
		nextVertex = null;
		firstEdge = null;
		visited = false;
	}
	
	public Vertex(T vInfo, Vertex<T> next) {
		vertexInfo = vInfo;
		indeg = 0;
		outdeg = 0;
		nextVertex = next;
		firstEdge = null;
		visited = false;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean getVisited() {
		return visited;
	}
}
