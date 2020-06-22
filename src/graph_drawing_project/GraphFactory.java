
package graph_drawing_project;

public class GraphFactory
{
    public static GraphInterface getDirectedGraph(String graphType)
    {
        if("DirectedGraph".equals(graphType))
            return new DirectedGraph();
        else if("UnDirectedGraph".equals(graphType))
            return new UnDirectedGraph();
        return null;
    }
    public static WeightedGraphInterface getWeightedGraph()
    {
        return new WeightedGraph();
    }
    
}
