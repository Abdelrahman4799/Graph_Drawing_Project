/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph_drawing_project;

import java.util.Vector;

/**
 *
 * @author Abd El-Rahman
 */
public class unDirectedWeightedGraph implements WeightedGraphInterface
{
        private Vector adjacentVertices = new Vector();
        private static int numOfvertex;
        private static int numOfEdges;
        
    public void setGraph(Vector adjacentVertex)
     {
         this.adjacentVertices= adjacentVertex;
     }
        
    public int findVertex(int index)
    {
        for(int i =0; i<adjacentVertices.size();i++)
        { 
            Vector v = new Vector();
            v=(Vector)adjacentVertices.elementAt(i);
            Vertex ver = (Vertex)v.elementAt(0);
           if(ver.getIndex()==i)
               return i;
        }
        return -1;
    }
        
    public void addVertex(int index)
    {
        if(findVertex(index)==-1)
        {
         Vector v = new Vector();
         Vertex ver =new Vertex(index);
         v.add(ver);
         adjacentVertices.add(v);
         numOfvertex++;
        }
        
    }
    
    
    public void DeleteVertex(int  index)
    { 
         if(findVertex(index)!=-1)
         {
             //clear vector from all relations with deleted vertex
             for (int i=0;i<adjacentVertices.size();i++)
             {
               Vector v =(Vector) adjacentVertices.elementAt(i);
               for(int j=1;j<v.size();j++)
                {
                if(((weightedConnection)v.elementAt(j)).indx2 == index||((weightedConnection)v.elementAt(j)).indx1 == index)
                    {
                     v.remove(j);
                    }
                }
               adjacentVertices.set(i, v);
             }
             adjacentVertices.remove(findVertex(index));
             numOfvertex--;
         }

    
    }
    public void addEdge(int f,int s){}//3shan ashel el error
    public void addEdge(int firstIndex ,int secondIndex,int weight)
    {
      boolean foundFirst =false , foundSecond=false;
      int indxF=-1,indxS=-1;
        for(int i=0; i<adjacentVertices.size(); i++)
        {
            Vector v = (Vector)adjacentVertices.elementAt(i);
            if((int)v.elementAt(0)==firstIndex)
            {
                indxF = i;
                foundFirst = true;
            }
            if((int)v.elementAt(0)==secondIndex)
            {
                indxS=i;
                foundSecond = true;
            }
            
            
            if(foundFirst && foundSecond)
            {
                // add two objects for first vertex vector and seconed vertex vector 
            Vector tmp = (Vector)adjacentVertices.elementAt(indxF);
            tmp.add(new weightedConnection(firstIndex,secondIndex,weight));
            tmp = (Vector)adjacentVertices.elementAt(indxS);
            tmp.add(new weightedConnection(secondIndex,firstIndex,weight));
            }
            
           
            addEdge(firstIndex, secondIndex, weight);

         }
    }
    
    public void deleteEdge(int firstIndex ,int secondIndex)
    {
        for(int i=0; i<adjacentVertices.size(); i++)
        {
             Vector v = (Vector)adjacentVertices.elementAt(i);
             for(int j=1;j<v.size();j++)
             {
                if(((weightedConnection)v.elementAt(j)).indx1==firstIndex||((weightedConnection)v.elementAt(j)).indx1==secondIndex)
                {
                    v.remove(j);
                }
             }
        
        }
        numOfEdges--;
      
    }

        
     public void showGraph()
    {   
        for(int i=0 ;i<adjacentVertices.size();i++)
        {
            Vector v = (Vector)adjacentVertices.elementAt(i);
            for(int j=1 ;j<v.size();j++)
            {
                Vertex x =(Vertex)v.elementAt(0);//my vertex 
                System.out.println(x.getIndex()+"   "+v.elementAt(j));//tl3 vertex w mtwsala b kza w kza
            }
        }
    }
     
     
    public void clearGraph()
    {
        adjacentVertices.clear();
    }
    
    
        
   public void updateWeight(int first,int seconed ,int weight)
   {
       int vertex = findVertex(first);
       Vector v = (Vector)adjacentVertices.elementAt(vertex);
       for(int i = 1 ; i <v.size();i++)
       {
            if(((weightedConnection)v.elementAt(i)).indx2==seconed)
            {
             ((weightedConnection)v.elementAt(i)).weight=weight;
            }
       }
   }
   public int showSumOfSumWeights(Vector vertices)
    {
        int sum=0;
        for (int i=1;i<vertices.size();i++)
        {
         sum+=((weightedConnection)vertices.elementAt(i)).weight;
        }
        return sum;
    }
    
}
