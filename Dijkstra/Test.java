import java.util.LinkedList;
import java.util.ArrayList;

public class Test{
  
  public Test(){
    Graph g = new Graph();
    
    
    Vertex dor = new Vertex("Dortmund");
    Vertex k = new Vertex("Koln");
    Vertex d = new Vertex("Duesseldorf");
    Vertex aa = new Vertex("Aachen");
    Vertex bn = new Vertex("Bonn");
    Vertex wu = new Vertex("Wuppertal");
    Vertex e = new Vertex("Essen");
    Vertex bo = new Vertex("Bochum");
    Vertex du = new Vertex("Duisburg");
    
    g.addVertex(k);
    g.addVertex(d);
    g.addVertex(aa);
    g.addVertex(bn);
    g.addVertex(wu);
    g.addVertex(e);
    g.addVertex(d);
    g.addVertex(bo);
    g.addVertex(du);
    
    g.addEdge(new Edge(k,d,33.0));
    g.addEdge(new Edge(k,aa,61.0));
    g.addEdge(new Edge(k,bn,25.0));
    g.addEdge(new Edge(bn,aa,71.0));
    g.addEdge(new Edge(bn,wu,60.0));
    g.addEdge(new Edge(wu,d,30.0));
    g.addEdge(new Edge(wu,k,37.0));
    g.addEdge(new Edge(wu,e,25.0));
    g.addEdge(new Edge(wu,dor,33.0));
    g.addEdge(new Edge(dor,bo,17.0));
    g.addEdge(new Edge(bo,e,15.0));
    g.addEdge(new Edge(e,du,17.0));
    g.addEdge(new Edge(du, d,23.0));
    
    Dijkstra dij = new Dijkstra(g);
    //double a = dij.getDist(g.getVertex("Koln"), g.getVertex("Essen"));
    
    dij.run(g.getVertex("Koln"));
    LinkedList<Vertex> path = dij.getPath(g.getVertex("Essen"));
    ArrayList<Vertex> vert = new ArrayList<Vertex>(path);
    //System.out.println(a);
    
    for (Vertex vertex : vert) {
      System.out.println(vertex);
    }
    
  }
  
    public static void main(String[] args){
    new Test();
  }
}
