
package graph_drawing_project;

import java.util.Vector;

public class DirectedGraph implements GraphInterface
{
   Vector adjacentVertex= new Vector() ;
     private static int numOfvertex;
     private static int numOfEdges;
     
     public void setGraph(Vector adjacentVertex)
     {
         this.adjacentVertex= adjacentVertex;
     }
    public int findVertex(int index)
    {
        for(int i=0 ;i<adjacentVertex.size();i++)
        {
            Vector v = new Vector();
            v =(Vector) adjacentVertex.elementAt(i);
            Vertex  vertex =(Vertex) v.elementAt(0);
            if(vertex.getIndex()==index)
                return i;
        }
                    return -1;

    }
    public void addVertex(int index)
    {
      if(findVertex(index)==-1)
      {
            Vector vec =new Vector();
            Vertex vertex = new Vertex(index);
            vec.add(vertex);
            adjacentVertex.add(vec);
            numOfvertex++;
      }
     
    }
    public void DeleteVertex(int  index)
    {
        
            if(findVertex(index)!=-1)
            {
                adjacentVertex.remove(findVertex(index));
                return;
            }
            numOfvertex--;
    }
    public void addEdge(int firstIndex ,int secondIndex)
    {
        int fVertix=findVertex(firstIndex);
        if(fVertix !=-1)
        {
            Vector v = (Vector)adjacentVertex.elementAt(fVertix);
            if(!v.contains(secondIndex))
            {
                v.add(secondIndex);
                adjacentVertex.set(fVertix,v);
                numOfEdges++;
            }
        }
    }
    public void deleteEdge(int firstIndex ,int secondIndex)
    {
        int fVertex = findVertex(firstIndex);
        Vector v = (Vector)adjacentVertex.elementAt(fVertex);
        if(v.contains(secondIndex))
            {       
                v.remove(v.indexOf(secondIndex));
                adjacentVertex.set(fVertex,v);
                numOfEdges--;
            }
    }
    public void showGraph()
    {   
        for(int i=0 ;i<adjacentVertex.size();i++)
        {
            Vector v = (Vector)adjacentVertex.elementAt(i);
            for(int j=1 ;j<v.size();j++)
            {
                Vertex x =(Vertex)v.elementAt(0);
                System.out.println(x.getIndex()+"   "+v.elementAt(j));
            }
        }
    }
    public void clearGraph()
    {
        adjacentVertex.clear();
    }
    
}