package graph_drawing_project;

import java.util.Vector;

public class UnDirectedGraph implements GraphInterface
{
    private Vector adjacentVertices = new Vector();
    
    private int getIndexOfVertex(Vertex newVertex)
    {
        for(int i=0;i<adjacentVertices.size();i++)
        {
            Vector v = (Vector)adjacentVertices.elementAt(i);
            Vertex vtx = (Vertex)v.elementAt(0);
            if(vtx.getIndex() == newVertex.getIndex())
                return i;
        }
        return -1;
    }
    @Override
    public void setGraph(Vector adjacentVertices) 
    {
        this.adjacentVertices = adjacentVertices;
    }

    @Override
    public void addVertex(int index) 
    {
        Vertex newVertex = new Vertex(index);
        Vector VectorOfVertex = new Vector();
        if(getIndexOfVertex(newVertex) != -1)
        {
            System.out.println("Vertex does exist");
            return;
        }   
        VectorOfVertex.add(newVertex);
        adjacentVertices.add(VectorOfVertex);
        System.out.println("Done!");
    }
    
    @Override
    public void DeleteVertex(int index) 
    {
        Vertex newVertex = new Vertex(index);
        int index_of_vertex = getIndexOfVertex(newVertex);
        if(index_of_vertex == -1)
            return ;
        adjacentVertices.removeElementAt(index_of_vertex);
    }

    @Override
    public void addEdge(int firstEdge, int secondEdge) 
    {
        Vertex v1 = new Vertex(firstEdge);
        int index_of_first = getIndexOfVertex(v1);
        Vertex v2 = new Vertex(secondEdge);
        int index_of_second = getIndexOfVertex(v2);
        Vector vec1 = (Vector)adjacentVertices.elementAt(index_of_first);
        if(vec1.contains(secondEdge))
            return;
        Vector vec2 = (Vector)adjacentVertices.elementAt(index_of_second);
        vec1.add(secondEdge);
        vec2.add(firstEdge);
        adjacentVertices.set(index_of_first, vec1);
        adjacentVertices.set(index_of_second, vec2);
    }

    @Override
    public void deleteEdge(int firstEdge, int secondEdge)
    {
        Vertex v1 = new Vertex(firstEdge);
        int index_of_first = getIndexOfVertex(v1);
        Vertex v2 = new Vertex(secondEdge);
        int index_of_second = getIndexOfVertex(v2);
        Vector vec1 = (Vector)adjacentVertices.elementAt(index_of_first);
        if(!vec1.contains(secondEdge))
            return;
        Vector vec2 = (Vector)adjacentVertices.elementAt(index_of_second);
        vec1.remove(vec1.indexOf(secondEdge));
        
        vec2.remove(vec2.indexOf(firstEdge));
        adjacentVertices.set(index_of_first, vec1);
        adjacentVertices.set(index_of_second, vec2);
    }

    @Override
    public void showGraph()
    {
        for(int i=0 ;i<adjacentVertices.size();i++)
        {
            Vector v = (Vector)adjacentVertices.elementAt(i);
            for(int j=1 ;j<v.size();j++)
            {
                Vertex vtx =(Vertex)v.elementAt(0);
                System.out.println(vtx.getIndex()+"   "+v.elementAt(j));
            }
        }
    }

    @Override
    public void clearGraph() 
    {
        adjacentVertices.clear();
    }
    
}
