
package graph_drawing_project;
public class Graph_Drawing_Project 
{
    public static void main(String[] args) 
    {
        GraphInterface GI = GraphFactory.getDirectedGraph("DirectedGraph");
        GI.addVertex(2);
        GI.addVertex(1);
        GI.addEdge(1,2);
        GI.deleteEdge(1,2);
        GI.addVertex(5);
        GI.addVertex(10);
        GI.addEdge(1,5);
        GI.addEdge(1,10);
        GI.showGraph();
    }
}
