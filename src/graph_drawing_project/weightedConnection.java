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
public class weightedConnection {
    int indx1 , indx2 , weight;

    public weightedConnection(int indx1 , int indx2 , int weight) {
        this.indx1 = indx1;
        this.indx2 = indx2;
        this.weight = weight;
    }

    public int getIndx1() {
        return indx1;
    }

    public int getIndx2() {
        return indx2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    
}
