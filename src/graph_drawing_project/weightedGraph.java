/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph_drawing_project;

/**
 *
 * @author lenovo
 */
import java.util.*;
import javafx.util.Pair;

public class weightedGraph {
    
    Vector connection;
    
    public weightedGraph(){
        connection = new Vector();
    }
    
    void addVertex(Vertex vertex){
        Vector tmp = new Vector();
        tmp.add(vertex.getIndex());
        connection.add(tmp);
    }
    
    void addVertex(int indx){
        if(findVertex(indx)==-1){
            Vector tmp = new Vector();
            tmp.add(indx);
            connection.add(tmp);
        }
    }
    
    int findVertex(Vertex vertex){
        for(int i=0; i<connection.size(); i++){
            Vector tmp = (Vector)connection.elementAt(i);
            if((int)tmp.elementAt(0)==vertex.getIndex()){
                return i;
            }
        }
        return -1;
    }
    
    int findVertex(int vertex){
        for(int i=0; i<connection.size(); i++){
            Vector tmp = (Vector)connection.elementAt(i);
            if((int)tmp.elementAt(0)==vertex){
                return i;
            }
        }
        return -1;
    }
    
    void addEdge(int firstindex , int secondindex , int weight){
        boolean foundFirst =false , foundSecond=false;
        int indx=-1;
        for(int i=0; i<connection.size(); i++){
            Vector tmp = (Vector)connection.elementAt(i);
            if((int)tmp.elementAt(0)==firstindex){
                indx = i;
                foundFirst = true;
            }
            if((int)tmp.elementAt(0)==secondindex){
                foundSecond = true;
            }
        }
        if(foundFirst && foundSecond){
            Vector tmp = (Vector)connection.elementAt(indx);
            tmp.add(new weightedConnection(firstindex,secondindex,weight));
        }
        else{
            if(!foundFirst){
                addVertex(firstindex);
            }
            if(!foundSecond){
                addVertex(secondindex);
            }
            addEdge(firstindex, secondindex, weight);
        }
    }
    
    void deleteVertex(int index){
        for(int i=0; i<connection.size(); i++){
            Vector tmp = (Vector)connection.elementAt(i);
            if((int)tmp.elementAt(0)==index){
                connection.remove(i);
                i--;
            }
            else{
                boolean removed = false;
                for(int j=1; j<tmp.size(); j++){
                    weightedConnection wc = (weightedConnection)tmp.elementAt(j);
                    if(wc.getIndx2() == index){
                        tmp.remove(j);
                        //System.out.println(i + " " +j);
                        j--;
                        removed = true;
                    }
                }
                if(removed){
                    connection.remove(i);
                    connection.add(tmp);
                    i--;
                }
            }
        }
        
    }
    
    void deleteEdge(int idx1 , int idx2 , int weight){
        for(int i=0; i<connection.size(); i++){
            Vector tmp = (Vector)connection.elementAt(i);
            if((int)tmp.elementAt(0) == idx1){
                boolean removed = false;
                for(int j=1; j<tmp.size(); j++){
                    if(((weightedConnection)tmp.elementAt(j)).getIndx2() == idx2 &&
                            ((weightedConnection)tmp.elementAt(j)).getWeight()== weight){
                        tmp.remove(j);
                    }
                }
                if(removed){
                    connection.remove(i);
                    connection.add(tmp);
                    i--;
                }
            }
        }
    }
    
    void deleteEdge(int idx1 , int idx2){
        for(int i=0; i<connection.size(); i++){
            Vector tmp = (Vector)connection.elementAt(i);
            if((int)tmp.elementAt(0) == idx1){
                boolean removed = false;
                for(int j=0; j<tmp.size(); j++){
                    if(((weightedConnection)tmp.elementAt(j)).getIndx2() == idx2){
                        tmp.remove(j);
                    }
                }
                if(removed){
                    connection.remove(i);
                    connection.add(tmp);
                    i--;
                }
            }
        }
    }
    
    void showGraph(){
        for(int i=0; i<connection.size(); i++){
            Vector tmp = (Vector)connection.elementAt(i);
            System.out.print((int)tmp.elementAt(0) + " --> ");
            for(int j=1; j<tmp.size(); j++){
                weightedConnection wc = (weightedConnection)tmp.elementAt(j);
                System.out.print("(" + wc.getIndx2() + "," +wc.weight+") , ");
            }
            System.out.println();
        }
    }
}
