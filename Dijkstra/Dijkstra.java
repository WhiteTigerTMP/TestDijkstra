import java.util.ArrayList;
import java.util.Set;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Dijkstra {
  
  List<Vertex> nodes;
  List<Edge> edges;
  Set<Vertex> setNodes;
  Set<Vertex> unSetNodes;
  Map<Vertex,Vertex> pre;
  Map<Vertex,Integer> distance;
  
  public Dijkstra(Graph graph){
    nodes = new List<Vertex>();
    nodes = graph.getVertices();
    edges = new List<Edge>();
    edges = graph.getEdges();
  }
  
  public void run(Vertex source){
    setNodes = new HashSet<Vertex>();
    unSetNodes = new HashSet<Vertex>();
    distance = new HashMap<Vertex, Integer>();
    pre = new HashMap<Vertex, Vertex>();
    distance.put(source, 0);
    unSetNodes.add(source);
    while (unSetNodes.size() > 0) { 
      Vertex node = getMin(unSetNodes);
      setNodes.add(node);
      unSetNodes.remove(node);
      findMinDist(node);
    } // end of while
  }
  
  private void findMinDist(Vertex node){
    ArrayList<Vertex> nearTo = getNeighbors(node);
    for (Vertex target : nearTo){
      if (getShortDist(target) > getShortDist(node) + getDist(node, target)) {
        pre.put(target, node);
        unSetNodes.add(target);
      } // end of if
    }
  } 
  
  private double getDist(Vertex node, Vertex target){
    ArrayList<Edge> edgees = new ArrayList<Edge>();
    edgees.add(edges.getContent()); 
    
    for (Edge edge : edgees){
      if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
        return edge.getWeight();
      }
      else {
        System.out.println("Error by getting the distance between edges.");
      }
    }
    return 0.0;
  }
  
  private Vertex getMin(Set<Vertex> verticies){
    Vertex min = null;
    for (Vertex vertex : verticies ) {
      if (min == null) {
        min = vertex;
      } else {
        if (getShortDist(vertex) < getShortDist(min)){
          min = vertex;
        }
      }
    } // end of for
    return min;
  }
  
  private boolean isSetteld(Vertex vertex){
    return setNodes.contains(vertex);
  }
  
  private int getShortDist(Vertex destination){
    Integer d = distance.get(destination);
    if (d == null) {
      return Integer.MAX_VALUE;
    } else {
      return d;
    }
  }
  
  private ArrayList<Vertex> getNeighbors(Vertex node){
    ArrayList<Vertex> neighbors = new ArrayList<Vertex>();
    
    ArrayList<Edge> edgees = new ArrayList<Edge>();
    edgees.add(edges.getContent()); 
    
    for (Edge edge : edgees){
      if(edge.getSource().equals(node) && !isSetteld(edge.getDestination())){
        neighbors.add(edge.getDestination());
      }
    }
    return neighbors;
  }
  
  public LinkedList<Vertex> getPath(Vertex target){
    LinkedList<Vertex> path = new LinkedList<Vertex>();
    Vertex step = target;
    
    if (pre.get(step) == null) {
      return null;
    } 
    path.add(step);
    while (pre.get(step) != null) { 
      step = pre.get(step);
      path.add(step);
    }
    
    Collections.reverse(path);
    return path;
  }
  
}
