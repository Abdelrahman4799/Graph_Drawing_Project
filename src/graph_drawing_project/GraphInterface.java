
package graph_drawing_project;
import java.util.Vector;
public interface GraphInterface 
{
    void setGraph(Vector adjacentVertices);
    void addVertex(int index);
    void DeleteVertex(int index);
    void addEdge(int firstEdge,int secondEdge);
    void deleteEdge(int firstEdge,int secondEdge);
    void showGraph();
    void clearGraph();

}
