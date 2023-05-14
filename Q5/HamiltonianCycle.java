import java.util.ArrayList;
import java.util.Stack;

public class HamiltonianCycle <T extends Comparable<T>> {
	 //start (& end) vertex
	  Vertex<T> start;
	  //stack used as list to store the path of the cycle
	  Stack<Vertex<T>> cycle = new Stack<>();
	  Stack<Vertex<T>> cloneStack = new Stack<>();
	  ArrayList<Integer> list = new ArrayList<>();
	  //number of vertices in the graph
	  int N;
	  //varibale to mark if graph has the cycle
	  boolean hasCycle = false;

	  //constructor
	  public HamiltonianCycle(Vertex<T> start, int N){
	    this.start = start;
	    this.N = N;
	  }

	  //method to inititate the search of the Hamiltonian cycle
	  public void findCycle(){
	    //add starting vertex to the list
	    cycle.push(start);

	    //start searching the path
	    solve(start);
	  }

	  private void solve(Vertex<T> vertex){
	    //Base condition: if the vertex is the start vertex
	    //and all nodes have been visited (start vertex twice)
	    if(vertex == start && cycle.size() == N+1){
	      hasCycle = true;

	      //output the cycle
	      cloneStack = (Stack<Vertex<T>>) cycle.clone();
	      while(!cloneStack.isEmpty())
	    	  list.add((Integer) cloneStack.pop().vertexInfo);
	      System.out.println(list.toString());
	      list.clear();

	      //return to explore more hamiltonian cycles
	      return;
	    }

	    //iterate through the neighbor vertices
	    for(Vertex<T> nbr: vertex.neighbors){
	      if(!nbr.visited){
	        //visit and add vertex to the cycle
	        nbr.visited = true;
	        cycle.push(nbr);

	        //Go to the neighbor vertex to find the cycle
	        solve(nbr);

	        //Backtrack
	        nbr.visited = false;
	        cycle.pop();
	      }
	    }
	  }
}
