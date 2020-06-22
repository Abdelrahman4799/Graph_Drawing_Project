
package graph_drawing_project;
import java.util.Vector;
public interface WeightedGraphInterface extends GraphInterface
{
    void updateWeight(int first,int second ,int weight);
    int showSumOfSumWeights(Vector vertices);
}
