package util;
import java.util.*;

import departments.Department;

import java.io.*;

/** A ListGraph is an extension of the AbstractGraph abstract class
*   that uses an array of lists to represent the edges.
*   @author Koffman and Wolfgang
*/

public class ListGraph extends AbstractGraph {

  // Data Field
  /** An array of Lists to contain the edges that
      originate with each vertex. */
  private ArrayList<LinkedList<Edge>> edges;

  /** Construct a graph with the specified number of
      vertices and directionality.
      @param numV The number of vertices
      @param directed The directionality flag
   */
  public ListGraph(boolean directed) {
    super(0, directed);
    edges = new ArrayList<LinkedList<Edge>>();
  }

  /** Determine whether an edge exists.
      @param source The source vertex
      @param dest The destination vertex
      @return true if there is an edge from source to dest
   */
  public boolean isEdge(Department source, Department dest) {
    Iterator<Edge> it = edgeIterator(source);
    Edge current;

    while(it.hasNext()){
      current = it.next();

      if(current.getDest().equals(dest)){
        return true;
      }
    }
    
    return false;
  }

  /** Insert a new edge into the graph.
      @param edge The new edge
   */
  public void insert(Edge edge) {
    boolean isAddedNormal = false;
    boolean isAddedReverse = false;

    for(int i = 0; i < getNumV(); i++){
      if(edges.get(i).get(0).getSource().equals(edge.getSource())){
        edges.get(i).add(edge);
        isAddedNormal = true;
      }
    }

    if(!isAddedNormal){
      LinkedList<Edge> a = new LinkedList<>();
      a.add(edge);
      
      edges.add(a);

      increaseNumV();
    }

    if (!isDirected()) {
      for(int i = 0; i < getNumV(); i++){
        if(edges.get(i).get(0).getSource().equals(edge.getDest())){
          edges.get(i).add(new Edge(edge.getDest(), edge.getSource()));
          isAddedReverse = true;
        }
      }

      if(!isAddedReverse){
        LinkedList<Edge> a = new LinkedList<>();
        a.add(new Edge(edge.getDest(), edge.getSource()));
        
        edges.add(a);

        increaseNumV();
      }
    }
  }

  public Iterator < Edge > edgeIterator(Department source) {

    for(int i = 0; i < getNumV(); i++){
      if(edges.get(i).get(0).getSource().equals(source)){
        return edges.get(i).iterator();
      }
    }

    return null;
  }

  /** Get the edge between two vertices. If an
      edge does not exist, an Edge with a weight
      of Double.POSITIVE_INFINITY is returned.
      @param source The source
      @param dest The destination
      @return the edge between these two vertices
   */
  public Edge getEdge(Department source, Department dest) {
    Iterator<Edge> it = edgeIterator(source);
    Edge current;

    if(it != null){
      while(it.hasNext()){
        current = it.next();

        if(current.getDest().equals(dest)){
          return current;
        }
      }
    }

    return null;
  }

  private int minDistance(ArrayList<Integer> dist, ArrayList<Boolean>  sptSet){
      // Initialize min value
      int min = Integer.MAX_VALUE, min_index = -1;

      for (int v = 0; v < getNumV(); v++)
          if (sptSet.get(v) == false && dist.get(v) <= min) {
              min = dist.get(v);
              min_index = v;
          }

      return min_index;
  }

  public int dijkstra(Department src, Department dest){
        ArrayList<Integer> dist = new ArrayList<>(); 
        // The output array. dist[i] will hold
        // the shortest distance from src to i

        ArrayList<Boolean> sptSet = new ArrayList<>();
        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        
 
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < getNumV(); i++) {
            dist.add(Integer.MAX_VALUE);
            sptSet.add(false);
        }
 
        // Distance of source vertex from itself is always 0
        dist.set(src.getId(), 0);
 
        // Find shortest path for all vertices
        for (int count = 0; count < getNumV()-1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);
 
            // Mark the picked vertex as processed
            sptSet.set(u, true);
 
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < getNumV(); v++)

                if (!sptSet.get(v) && isEdge(edges.get(u).get(0).getSource(),edges.get(v).get(0).getSource()) && dist.get(u) != Integer.MAX_VALUE && dist.get(u) + getEdge(edges.get(u).get(0).getSource(), edges.get(v).get(0).getSource()).getWeight() < dist.get(v))
                    dist.set(v, dist.get(u) + (int) (getEdge(edges.get(u).get(0).getSource(), edges.get(v).get(0).getSource()).getWeight()));
        }
 
        return dist.get(dest.getId());
    }

  /** Load the edges of a graph from the data in an input file.
        The file should contain a series of lines, each line
        with two or three data values. The first is the source
        the second is the destination, and the optional third
        is the weight
        @param bufferedReader The BufferedReader that is connected
                              to the file that contains the data
        @throws IOException - If an I/O error occurs
   */
  public void loadEdgesFromFile(BufferedReader bufferedReader) throws IOException {
    /*
    TODO : write this method

    Department source, dest;
    double weight;
    

    String line;
    while ( (line = bufferedReader.readLine()) != null
           && line.length() != 0) {
      Scanner sc = new Scanner(line);

      source = 
      dest = 
      weight = 1.0;
      if (sc.hasNextDouble())
        weight = sc.nextDouble();
      insert(new Edge(source, dest, weight));
    }*/
    
  }

}
